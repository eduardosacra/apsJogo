package modelo;

import java.util.Calendar;

public class Jogador {
	String nome;
	int movimentos;
	Calendar tempo;
	
	public Jogador() {
		this.nome="";
		this.movimentos=0;
		
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getMovimentos() {
		return movimentos;
	}
	public void setMovimentos(int movimentos){
		this.movimentos = movimentos;
	}
	public void setSomaMovimentos(int movimento){
		this.movimentos += movimento;
	}
	
	public Calendar getTempo() {
		return tempo;
	}
	public void setTempo(Calendar tempo) {
		this.tempo = tempo;
	}
}
