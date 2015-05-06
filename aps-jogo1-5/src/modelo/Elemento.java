package modelo;

import java.awt.Color;

import javax.swing.ImageIcon;

public class Elemento {
	private int id;
	private ImageIcon imagem;
	private int indice;
	private String nome;
	private String dica;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDica() {
		return dica;
	}

	public void setDica(String dica) {
		this.dica = dica;
	}

	public boolean comparaElemento(Elemento elemento){
		if(elemento.getIndice() == this.indice){
			return true;
		}else{
			return false;
		}
	
}
	
	public ImageIcon getImagem() {
		return imagem;
	}
	public void setImagem(ImageIcon imagem) {
		this.imagem = imagem;
	}
	public int getIndice() {
		return indice;
	}
	public void setIndice(int indice) {
		this.indice = indice;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
