package visao;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controle.Controle;

public class TelaPrincipal extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Controle controle;
	Container contentPane;
	TelaMenu tlMenu;	
	
	public TelaPrincipal(Controle controle) {
		this.controle = controle;
		inicialisaComponente();
	}
	
	private void inicialisaComponente(){
		this.contentPane = this.getContentPane();
		this.contentPane.setLayout(new BorderLayout());		
		this.setTitle("JOGO DA MEMORIA ASSOCIATIVO" );
		this.trocaTamanho(600,420);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void setPainel(JPanel painel) {	
		this.contentPane.removeAll();
		this.contentPane.add(painel);
		this.contentPane.validate();		
	}
	
	public void trocaTamanho(int largura, int altura ) {
		this.setSize(largura, altura);
		this.repaint();		
	}

	public void telaCheia() {
		this.setSize(this.getMaximumSize().width,this.getMaximumSize().height);
		this.repaint();
	}
	
}
