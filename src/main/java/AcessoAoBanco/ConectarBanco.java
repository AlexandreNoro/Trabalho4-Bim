package AcessoAoBanco;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectarBanco {

	private Connection conexao;

	private static ConectarBanco instanciar;

	private ConectarBanco() {
	}

	public static ConectarBanco getInstace() {
		if (instanciar == null)
			return instanciar = new ConectarBanco();
		return instanciar;
	}

	public Connection abreConexao() {
		String url = "jdbc:h2://localhost/Alexandre";
		String user = "root";
		String pass = "'142536'";
		try {
			return conexao = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void fechaConexao() {
		try {
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
