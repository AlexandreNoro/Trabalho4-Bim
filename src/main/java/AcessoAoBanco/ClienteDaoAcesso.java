package AcessoAoBanco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import br.univel.cadastroCliente.Cliente;
import br.univel.cadastroCliente.Estado;
import br.univel.cadastroCliente.Genero;

public class ClienteDaoAcesso implements ClienteDao {

	private static Connection con;

	private static ClienteDaoAcesso instanciar;
	
	//Construtor da classe
	private ClienteDaoAcesso() {

	}
	//M�todo para retornar nova Inst�ncia
	public static ClienteDaoAcesso getNovaInstancia() {
		if (instanciar == null)
			return instanciar = new ClienteDaoAcesso();
		return instanciar;
	}
	
	//M�todo para abrir conexao com o banco
	private void abrirConexao() throws SQLException {

		String url = "jdbc:h2:~/Alexandre";
		String user = "sa";
		String password = "sa";
		con = DriverManager.getConnection(url, user, password);

	}

	//M�todo para fechar conex�o com o banco
	private void fecharConexao() throws SQLException {

		con.close();

	}

	//M�todo inserir
	@Override
	public void inserir(Cliente c) {

		PreparedStatement ps;
		try {
			ps = con.prepareStatement(
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

	//M�todo atualizar
	@Override
	public void atualizar(Cliente c) {

		PreparedStatement ps;
		try {
			ps = con.prepareStatement(
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

	//M�todo excluir 
	@Override
	public void excluir(Cliente c) {

		PreparedStatement ps;
		try {
			ps = con.prepareStatement("DELETE FROM CLIENTE WHERE ID =" + c.getId());

			int res = ps.executeUpdate();

			ps.close();

			System.out.println(res + "Exclu�do com Sucesso");

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	//M�todo para buscar
	@Override
	public Cliente buscar(int id) {

		Statement st = null;
		ResultSet rs = null;
		Cliente c = null;
		Estado uf = Estado.PR;
		Genero gn = Genero.M;
		try {
			st = con.createStatement();
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

	//M�todo para listar 
	@Override
	public List<Cliente> listar() {

		return null;
	}

}
