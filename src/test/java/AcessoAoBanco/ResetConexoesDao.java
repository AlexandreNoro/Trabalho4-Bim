package AcessoAoBanco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//Feito para poder deixar o banco zerado. Pra iniciar testes do zero.
public class ResetConexoesDao {

	Connection conexao = ConectarBanco.getInstace().abreConexao();

	public void reset(String nomeTable) {
		try {
			PreparedStatement ps;
			if ("USUARIO".equals(nomeTable)) {
				ps = getConexao().prepareStatement("DELETE FROM " + nomeTable + " WHERE ID_U > 1");
				ps.executeUpdate();
				ps = getConexao().prepareStatement("ALTER TABLE " + nomeTable + " AUTO_INCREMENT = 2");
				ps.executeUpdate();
				ps.close();
			} else {
				ps = getConexao().prepareStatement("DELETE FROM " + nomeTable);
				ps.executeUpdate();
				ps = getConexao().prepareStatement("ALTER TABLE " + nomeTable + " AUTO_INCREMENT = 1");
				ps.executeUpdate();
				ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConexao() {
		return conexao;
	}

}
