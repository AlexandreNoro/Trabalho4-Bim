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
	@Override
	public void inserir(Usuario user) {

		PreparedStatement ps;
		try {
			ps = conexao.prepareStatement("INSERT INTO USUARIO(IDCOD_C, CLIENTE , SENHA) VALUES (?, ?, ?)");

			ps.setInt(1, user.getIdCliente());
			ps.setString(2, user.getCliente());
			ps.setString(3, user.getSenha());

			ps.executeUpdate();

			ps.close();

			JOptionPane.showInternalMessageDialog(null, "Usuário: " + user.getCliente() + "inserido com sucesso!!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	//Método de atualizar 
	@Override
	public void atualizar(Usuario user) {
		PreparedStatement ps;
		try {
			ps = conexao.prepareStatement(
					"UPDATE USUARIO SET IDCOD_C= ?,CLIENTE = ?, SENHA = ?  WHERE USER =" + user.getId());

			ps.setInt(1, user.getIdCliente());
			ps.setString(2, user.getCliente());
			ps.setString(3, user.getSenha());

			ps.executeUpdate();

			ps.close();

			JOptionPane.showMessageDialog(null, "Usuário" + user.getCliente() + "alterado com Sucesso!!!");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	//Método excluir
	@Override
	public void excluir(int user) {
		PreparedStatement ps;
		try {
			ps = conexao.prepareStatement("DELETE FROM USUARIO WHERE USER =" + user);

			ps.executeUpdate();

			ps.close();

			JOptionPane.showMessageDialog(null, "Usuário excluído com Sucesso!!!");

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
	
	
	//Método de busca
	@Override
	public Usuario buscar(int user) {
		Statement st = null;
		ResultSet rs = null;
		Usuario u = null;
		try {
			st = conexao.createStatement();
			rs = st.executeQuery("SELECT ID_C, CLIENTE, SENHA FROM USUARIO WHERE USER =" + user);
			rs.next();
			if (rs.getString("CLIENTE") != null) {
				u = new Usuario();
				u.setId(rs.getInt("IDCOD_C"));
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
	@Override
	public List<Usuario> listar() {

		Statement st = null;
		ResultSet rs = null;
		Usuario u = null;

		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		try {
			st = conexao.createStatement();
			rs = st.executeQuery("SELECT USER, IDCOD_C, CLIENTE, SENHA FROM USUARIO");
			while (rs.next()) {
				u = new Usuario();
				u.setId(rs.getInt("USER"));
				u.setIdCliente(rs.getInt("IDCOD_C"));
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
			JOptionPane.showMessageDialog(null, "Erro ao listar Usuários!!!/n" + e.getMessage());
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
			rs = st.executeQuery(
					"SELECT USUARIO, SENHA FROM USUARIO WHERE USUARIO = '" + user + "' AND SENHA = '" + password + "'");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
