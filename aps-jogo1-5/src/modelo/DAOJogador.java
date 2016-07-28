package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import factory.Conexao;

public class DAOJogador {
	public DAOJogador() {

	}

	public ArrayList buscaTodosJogadores() {

		ArrayList jogadores = new ArrayList();
		try {

			Connection con = Conexao.getConexao();

			Statement stm = con.createStatement();
			ResultSet rs = stm
					.executeQuery("SELECT * FROM recordes order by movimentos asc;");

			while (rs.next()) {
				Jogador jogador = new Jogador();
				jogador.setNome(rs.getString("nome") + "\t");
				jogador.setMovimentos(rs.getInt("movimentos"));
				jogadores.add(jogador);
			}
			rs.close();
			stm.close();
			Conexao.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return jogadores;

	}

	public boolean salvaJogador(Jogador jogador) {
		

		try {

			Connection con = Conexao.getConexao();

			String sql = "Insert into recordes (nome,movimentos) values (?,?)";
			PreparedStatement stm2 = con.prepareStatement(sql);

			stm2.setString(1, jogador.getNome());
			stm2.setInt(2, jogador.getMovimentos());

			stm2.execute();
			return true;

		} catch (SQLException e) {
			System.out.println("Erro de SQL: " + e);
			e.printStackTrace();
			return false;
		}

	}

	public ArrayList getRecordes() {

		return this.buscaTodosJogadores();
	}
}
