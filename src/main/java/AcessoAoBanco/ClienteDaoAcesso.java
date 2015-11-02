package AcessoAoBanco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import br.univel.cadastroCliente.Cliente;
import br.univel.cadastroCliente.Estado;
import br.univel.cadastroCliente.Genero;

public class ClienteDaoAcesso implements ClienteDao {

	private Connection conexao = ConectarBanco.getInstace().abreConexao();
	
	//Método inserir
	@Override
	public void inserir(Cliente c) {

		PreparedStatement ps;
		try {
			ps = conexao.prepareStatement(
					"INSERT INTO CLIENTE(ID,NOME,ENDERECO,TELEFONE,CIDADE,ESTADO,GENERO,EMAIL) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

			ps.setInt(1, c.getId());
			ps.setString(2, c.getNome());
			ps.setString(3, c.getEndereco());
			ps.setString(4, c.getTelefone());
			ps.setString(5, c.getCidade());
			ps.setObject(6, c.getEstado().getNome());
			ps.setObject(7, c.getGenero().getNome());
			ps.setString(8, c.getEmail());

			int res = ps.executeUpdate();

			ps.close();

			System.out.println(res + "Inserido com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	//Método atualizar
	@Override
	public void atualizar(Cliente c) {

		PreparedStatement ps;
		try {
			ps = conexao.prepareStatement(
					"UPDATE CLIENTE SET NOME = ?,ENDERECO = ?,TELEFONE = ?,ESTADO = ?,GENERO = ?, EMAIL = ?  WHERE ID ="
							+ c.getId());

			ps.setInt(1, c.getId());
			ps.setString(2, c.getNome() + "");
			ps.setString(3, c.getEndereco() + "");
			ps.setString(4, c.getTelefone() + "");
			ps.setString(5, c.getCidade() + "");
			ps.setObject(6, c.getEstado() + "");
			ps.setObject(7, c.getGenero() + "");
			ps.setString(8, c.getEmail() + "");

			int res = ps.executeUpdate();

			ps.close();

			System.out.println(res + "Alterado com Sucesso");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//Método excluir 
	@Override
	public void excluir(Cliente c) {

		PreparedStatement ps;
		try {
			ps = conexao.prepareStatement("DELETE FROM CLIENTE WHERE ID =" + c.getId());

			int res = ps.executeUpdate();

			ps.close();

			System.out.println(res + "Excluído com Sucesso");

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	//Método para buscar
	@Override
	public Cliente buscar(int id) {

		Statement st = null;
		ResultSet rs = null;
		Cliente c = null;
		Estado uf = Estado.PR;
		Genero gn = Genero.M;
		try {
			st = conexao.createStatement();
			rs = st.executeQuery(
					"SELECT NOME,ENDERECO,TELEFONE,CIDADE,ESTADO,GENERO,EMAIL  FROM CLIENTE WHERE ID=" + id);
			rs.next();
			c = new Cliente(id, rs.getString("NOME"), rs.getString("ENDERECO"), rs.getString("TELEFONE"),
					rs.getString("CIDADE"), uf.validar(rs.getObject("ESTADO")), gn.validar(rs.getObject("GENERO")),
					rs.getString("EMAIL"));
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao buscar o Cliente desejado!\n" + e.getMessage());
		}
		return c;
	}

	//Método para listar 
	@Override
	public List<Cliente> listar() {

		return null;
	}

}
