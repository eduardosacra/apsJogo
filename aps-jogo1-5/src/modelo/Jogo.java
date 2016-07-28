package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;

public class Jogo {
	private List elementos;
	private String[] lixeiras;
	private String[] lixos;
	private Jogador jogador;
	private int contadorDeCombinacao;

	public int getContadorDeCombinacao() {
		return contadorDeCombinacao;
	}

	public Jogador getJogador() {
		return this.jogador;
	}

	public Jogo(String jogador) {
		this.contadorDeCombinacao = 0;
		this.jogador = new Jogador();
		this.jogador.setNome(jogador);
		this.elementos = new ArrayList();
		setaLixeiras();
		
		setaLixos();
		setaImagem();
		embaralhar();

	}

	private void setaImagem() {
		for (Object object : elementos) {
			Elemento elemento = (Elemento) object;
			if (elemento.getNome() == "Lixeira de Plastico") {
				elemento.setImagem(new ImageIcon("Imagem/plastico.jpg"));
			} else if (elemento.getNome() == "Lixeira de Papel e Papelao") {
				elemento.setImagem(new ImageIcon("Imagem/papel.jpg"));
			} else if (elemento.getNome() == "Lixeira de Madeira") {
				elemento.setImagem(new ImageIcon("Imagem/madeira.jpg"));
			} else if (elemento.getNome() == "Lixeira de Vidro") {
				elemento.setImagem(new ImageIcon("Imagem/vidro.jpg"));
			} else if (elemento.getNome() == "Lixeira de Metal") {
				elemento.setImagem(new ImageIcon("Imagem/metal.jpg"));
			} else if (elemento.getNome() == "Lixeira de Residuos Perigosos") {
				elemento.setImagem(new ImageIcon("Imagem/perigoso.jpg"));
			} else if (elemento.getNome() == "Lixeira de lixo hospitalar") {
				elemento.setImagem(new ImageIcon("Imagem/saude.jpg"));
			} else if (elemento.getNome() == "Lixeira de Residuos Radioativos") {
				elemento.setImagem(new ImageIcon("Imagem/radioativo.jpg"));
			} else if (elemento.getNome() == "Lixeira de Residuos Organicos") {
				elemento.setImagem(new ImageIcon("Imagem/organico.jpg"));
			} else if (elemento.getNome() == "Lixeira de Residuos Nao Reciclaveis") {
				elemento.setImagem(new ImageIcon("Imagem/nao-reciclavel.jpg"));

			} else if (elemento.getNome() == "Plastico") {
				elemento.setImagem(new ImageIcon("Imagem/lixo-plastico2.jpg"));
			} else if (elemento.getNome() == "Papel") {
				elemento.setImagem(new ImageIcon("Imagem/lixo-papel2.jpg"));
			} else if (elemento.getNome() == "Tabua") {
				elemento.setImagem(new ImageIcon("Imagem/lixo-madeira2.jpg"));
			} else if (elemento.getNome() == "Vidro") {
				elemento.setImagem(new ImageIcon("Imagem/lixo-vidro3.jpg"));
			} else if (elemento.getNome() == "Metal") {
				elemento.setImagem(new ImageIcon("Imagem/lixo-metal3-1.jpg"));
			} else if (elemento.getNome() == "Perigosos") {
				elemento.setImagem(new ImageIcon("Imagem/lixo-residuos2.jpg"));
			} else if (elemento.getNome() == "Saude") {
				elemento.setImagem(new ImageIcon("Imagem/lixo-hospitalar2.jpg"));
			} else if (elemento.getNome() == "Radioativos") {
				elemento.setImagem(new ImageIcon(
						"Imagem/lixo-radioativo2-1.jpg"));
			} else if (elemento.getNome() == "Organicos") {
				elemento.setImagem(new ImageIcon("Imagem/lixo-organico2.jpg"));
			} else if (elemento.getNome() == "Nao Reciclavel") {
				elemento.setImagem(new ImageIcon(
						"Imagem/lixo-nao-reciclavel3.jpg"));
			}
		}

	}

	public List getElementos() {

		return this.elementos;

	}

	public Jogador getVencedor() {
		return this.jogador;
	}

	private void setaLixeiras() {
		String[] lixeiras = { "Lixeira de Madeira",
				"Lixeira de Papel e Papelao", "Lixeira de Plastico",
				"Lixeira de Vidro", "Lixeira de Metal",
				"Lixeira de Residuos Perigosos", "Lixeira de lixo hospitalar",
				"Lixeira de Residuos Radioativos",
				"Lixeira de Residuos Organicos",
				"Lixeira de Residuos Nao Reciclaveis" };
		this.lixeiras = lixeiras;

		for (int i = 0; i < 10; i++) {
			Elemento elemento = new Elemento();

			elemento.setNome(this.lixeiras[i]);
			elemento.setIndice(i);
			this.elementos.add(elemento);
		}
	}

	private void setaLixos() {
		String[] lixos = { "Tabua", "Papel", "Plastico", "Vidro", "Metal",
				"Perigosos", "Saude", "Radioativos", "Organicos",
				"Nao Reciclavel" };
		this.lixos = lixos;

		for (int i = 0; i < 10; i++) {
			Elemento elemento = new Elemento();

			elemento.setNome(this.lixos[i]);
			elemento.setIndice(i);
			this.elementos.add(elemento);

		}
	}

	private void embaralhar() {
		Random rd = new Random();

		for (int j = 0; j <= 30; j++) {
			int a = rd.nextInt(20);
			int b = rd.nextInt(20);
			Elemento auxA = (Elemento) elementos.get(a);
			Elemento auxB = (Elemento) elementos.get(b);
			elementos.set(b, auxA);
			elementos.set(a, auxB);

		}
	}

	public boolean verifica(Elemento elemento, Elemento elemento2) {

		if (elemento.getIndice() == elemento2.getIndice()) {
			if (this.contadorDeCombinacao <= 9) {

				this.contadorDeCombinacao += 1;
			}
			this.jogador.setSomaMovimentos(1);
			return true;

		} else {
			this.jogador.setSomaMovimentos(1);
			return false;
		}

	}

}
