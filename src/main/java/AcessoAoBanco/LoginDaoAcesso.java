package AcessoAoBanco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class LoginDaoAcesso {
	
	public Connection con;
	public Statement st;
	public ResultSet rs;
	
	
	String driverName = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost/trabalho4bim";
	String user = "root";
	String pass = "142536";
	
	public void abreConexao(){
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(url, user, pass);
			
			st = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
