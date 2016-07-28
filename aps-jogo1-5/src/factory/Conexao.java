package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private static Connection conexao = null;

	private Conexao() {
	}

	public static Connection getConexao() {

		final String driver = "com.mysql.jdbc.Driver";
		final String banco = "jma";
		final String url = "jdbc:mysql://localhost:3306/" + banco;
		final String login = "userjma";
		final String senha = "123QwErT@";

		try {
			
			if (conexao == null || conexao.isClosed()) {

				Class.forName(driver);
				conexao = DriverManager.getConnection(url, login, senha);
			}
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();

		}
		return conexao;
	}

	public static void close() {
		try {
			conexao.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
