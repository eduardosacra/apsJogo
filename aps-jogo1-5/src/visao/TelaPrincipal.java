package visao;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import modelo.DAOJogador;
import modelo.Elemento;
import modelo.Jogador;
import controle.Controle;

public class TelaPrincipal extends JFrame {
	
	Controle controle;
	Container contentPane;
	TelaMenu tlMenu;
	
	
	
	
	public TelaPrincipal(Controle controle) {
		this.controle = controle;
		//this.tlMenu = new TelaMenu(controle);
		inicialisaComponente();
	}
	
	private void inicialisaComponente(){
		this.contentPane = this.getContentPane();
		this.contentPane.setLayout(new BorderLayout() );
		//this.add(pnJogos);
		//this.add(pnPrincipal);
		//this.contentPane.add(tlMenu,BorderLayout.CENTER);
		
		
		setTitle("JOGO DA MEMORIA ASSOCIATIVO" );
		setSize(600, 420);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setResizable(false);
	}

	public void setPainel(JPanel painel) {
	
		this.contentPane.removeAll();
		this.contentPane.add(painel);
		this.contentPane.validate();
		
	}
	
	

	public void verifica(Elemento elemento) {
		// TODO verificar se é necessário
		
	}

	

	

	
}
