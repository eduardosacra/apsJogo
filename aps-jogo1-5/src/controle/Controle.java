package controle;

import java.util.ArrayList;

import modelo.DAOJogador;
import modelo.Elemento;
import modelo.Jogo;
import visao.ElementoTela;
import visao.TelaJogo;
import visao.TelaMenu;
import visao.TelaPrincipal;

public class Controle {
	TelaPrincipal tlPrincipal;
	Jogo jogo;
	TelaJogo telaJogo;
	DAOJogador dao;
	
	public Controle() {
		dao = new DAOJogador();
		tlPrincipal = new TelaPrincipal(this);
		tlPrincipal.setPainel(new TelaMenu(this));
		tlPrincipal.setSize(750, 400);
		tlPrincipal.setVisible(true);
	}

	public void iniciaTelaJogo(TelaJogo tlJogo) {
		this.telaJogo = tlJogo;
	}

	public void iniciarJogo(String jogador) {
		jogo = new Jogo(jogador);
		tlPrincipal.setSize(1200, 700);
		tlPrincipal.setPainel(new TelaJogo(this.jogo.getElementos(),this));
	
	}

	public void verifica(ElementoTela el1, ElementoTela el2) {
		if (jogo.verifica(el1.elemento, el2.elemento)) {
			if(this.jogo.getContadorDeCombinacao() < 10){				
				this.telaJogo.saoIguais();
				
			}else{
				telaJogo.concluiu( this.jogo.getJogador());
			}
			
		}else{
			this.telaJogo.naoEIgual();
		}
		
	}

	public String getNomeJogador() {
		
		return this.jogo.getJogador().getNome();
	}

	//public void recordes() {
		//this.tlPrincipal.mostraRecordes(dao.buscaTodosJogadores());
		
	//}

	public ArrayList getRecordes() {
		
		return this.dao.getRecordes();
	}

	
	public void concluiu() {
		if(this.dao.salvaJogador(this.jogo.getJogador())){
			this.telaJogo.avisaUsuario("Salvo com sucesso");
			tlPrincipal.setSize(900, 520);
			this.tlPrincipal.setPainel(new TelaMenu(this));
		
		}
		
	}

}
