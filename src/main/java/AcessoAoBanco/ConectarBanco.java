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
		String driverName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost/trabalho4bim";
		String user = "root";
		String pass = "142536";
		try {
			Class.forName(driverName);
			return conexao = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean fechaConexao() {
		try {
			conexao.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
