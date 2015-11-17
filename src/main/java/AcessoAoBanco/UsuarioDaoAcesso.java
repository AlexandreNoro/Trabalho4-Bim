package AcessoAoBanco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import br.univel.cadastroCliente.Usuario;

public class UsuarioDaoAcesso implements AcessoDao<Usuario> {

	private Connection conexao = ConectarBanco.getInstace().abreConexao();

	//Método inserir 
	public int inserir(Usuario user) {

		PreparedStatement ps;
		try {
			ps = conexao.prepareStatement("INSERT INTO USUARIO (ID_C, CLIENTE, SENHA) VALUES (?, ?, ?)");
			ps.setInt(1, user.getIdCliente());
			ps.setString(2, user.getCliente());
			ps.setString(3, user.getSenha());
			int res = ps.executeUpdate();
			ps.close();

			JOptionPane.showMessageDialog(null, "Usuário: " + user.getCliente() + " inserido com sucesso!!!");
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}

	}

	//Método de atualizar 
	public int atualizar(Usuario user) {
		PreparedStatement ps;
		try {
			ps = conexao.prepareStatement("UPDATE USUARIO SET ID_C = ?, CLIENTE = ?, SENHA =? WHERE ID_U"
					+ user.getId());
			ps.setInt(1, user.getIdCliente());
			ps.setString(2, user.getCliente());
			ps.setString(3, user.getSenha());
			int res = ps.executeUpdate();
			ps.close();

			JOptionPane.showMessageDialog(null, "Usuário: " + user.getCliente() + " alterado com Sucesso!!!");
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}

	}
	
	//Método excluir
	public int excluir(int user) {
		PreparedStatement ps;
		try {
			ps = conexao.prepareStatement("DELETE FROM USUARIO WHERE ID_C = "
					+ user);
			int res = ps.executeUpdate();
			ps.close();

			JOptionPane.showMessageDialog(null, "Usuário excluído com Sucesso!!!");
			return res;
		} catch (SQLException e) {

			e.printStackTrace();
			
			return 0;
		}

	}
	
	
	//Método de busca
	public Usuario buscar(int user) {
		Statement st = null;
		ResultSet rs = null;
		Usuario u = null;
		try {
			st = conexao.createStatement();
			rs = st.executeQuery("SELECT ID_C, CLIENTE, SENHA FROM USUARIO WHERE ID_U = "
					+ user);
			rs.next();
			if (rs.getString("CLIENTE") != null) {
				u = new Usuario();
				u.setId(user);
				u.setIdCliente(rs.getInt("ID_C"));
				u.setCliente(rs.getString("CLIENTE"));
				u.setSenha(rs.getString("SENHA"));
				rs.close();
				st.close();
				return u;
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao buscar o Usuário desejado!\n" + e.getMessage());
		}
		return null;

	}
	
	
	//Método para listar
	public List<Usuario> listar() {

		Statement st = null;
		ResultSet rs = null;
		Usuario u = null;

		List<Usuario> lista = new ArrayList<Usuario>();
		lista = new ArrayList<Usuario>();
		try {
			st = conexao.createStatement();
			rs = st.executeQuery("SELECT ID_U, ID_C, CLIENTE, SENHA FROM USUARIO");
			while (rs.next()) {				
				u = new Usuario();
				u.setId(rs.getInt("ID_U"));
				u.setIdCliente(rs.getInt("ID_C"));
				u.setCliente(rs.getString("CLIENTE"));
				u.setSenha(rs.getString("SENHA"));
				lista.add(u);
			}
			rs.close();
			st.close();

			if (lista != null) {
				return lista;
			}

		} catch (Exception e) {
		e.printStackTrace();
		}
		return null;
	}

	public Connection getConexao() {
		return conexao;

	}
	
	
	public boolean Testar(String user, String password) {
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conexao.createStatement();
			rs = st.executeQuery("SELECT CLIENTE, SENHA FROM USUARIO WHERE CLIENTE = '"+user+"' AND SENHA = '"+password+"'");
			boolean v = rs.next();
			rs.close();
			rs.close();
			return v;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
