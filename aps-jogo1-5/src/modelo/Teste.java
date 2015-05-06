package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;








public class Teste {
	
		
		
		/*
		try{
			Class.forName("org.hsqldb.jdbcDriver");
		    Connection con = DriverManager.getConnection("jdbc:hsqldb:file:/banco/bdJDMA", "sa", "");
		    
			Jogador jogador =  new Jogador();
			jogador.setNome("jogador01");
			jogador.setSomaMovimentos(20);
			
			String sql = "Insert into Recordes (jogador,movimentos) values (?,?)";
			PreparedStatement stm2  =con.prepareStatement(sql);// con.prepareStatement(sql);
			
			stm2.setString(1,jogador.getNome());
		    stm2.setInt(2, jogador.getMovimentos());
		    	if( stm2.execute()){
		  
		    stm2.execute("SHUTDOWN");}
		}catch(ClassNotFoundException e){
		    System.out.println("Erro ao carregar o driver JDBC. ");
		}catch(SQLException e){
		    System.out.println("Erro de SQL: "+e);
		    e.printStackTrace();
		}*/
		public void testa(){
		try{
		    Class.forName("org.hsqldb.jdbcDriver");
		    Connection con = DriverManager.getConnection("jdbc:hsqldb:file:/banco/bdJDMA", "sa", "");
		 
		    Statement stm= con.createStatement();
		    ResultSet rs = stm.executeQuery("SELECT * FROM Recordes");
		 
		    while(rs.next()){
		        String nome = rs.getString("jogador");
		        String email = rs.getString("movimentos");
		 
		        System.out.println(nome+" - "+email);
		    }	
		    stm.execute("SHUTDOWN");
		}catch(ClassNotFoundException e){
		    System.out.println("Erro ao carregar o driver JDBC. ");
		}catch(SQLException e){
		    System.out.println("Erro de SQL: "+e);
		    e.printStackTrace();
		}
		}
		/*try{
		    Class.forName("org.hsqldb.jdbcDriver");
		    Connection con = DriverManager.getConnection("jdbc:hsqldb:file:/banco/dbteste", "sa", "");
		 
		    Statement stm= con.createStatement();
		    ResultSet rs = stm.executeQuery("SELECT * FROM usuarios");
		 
		    while(rs.next()){
		        String nome = rs.getString("nome");
		        String email = rs.getString("email");
		 
		        System.out.println(nome+" - "+email);
		    }
		    stm.execute("SHUTDOWN");
		}catch(ClassNotFoundException e){
		    System.out.println("Erro ao carregar o driver JDBC. ");
		}catch(SQLException e){
		    System.out.println("Erro de SQL: "+e);
		    e.printStackTrace();
		}*/
	
}
