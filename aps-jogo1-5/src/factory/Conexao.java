package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	public static Connection conexao =null;
	
	

	public static Connection getConexao() {
		
		final String driver = "com.mysql.jdbc.Driver";
		
		final String banco = "jma";
		final String url = "jdbc:mysql://localhost:3306/" + banco;
		final String login = "userjma";
		final String senha = "123QwErT@";
		
		try {
			Class.forName(driver);
			conexao = DriverManager.getConnection(url, login, senha);
			System.out.println("Conectado com sucesso");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return conexao;
	}
	
	public static void close(){
		try {
			conexao.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
