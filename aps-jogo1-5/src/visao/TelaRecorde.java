package visao;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.Jogador;

public class TelaRecorde extends JPanel{
	JPanel pnPrincipal,pnJogadores;
	JButton btVoltar;
	ArrayList jogadores;
	
	public TelaRecorde(List buscaTodosJogadores) {
		this.jogadores =  (ArrayList) buscaTodosJogadores;
		
		this.btVoltar = new JButton("Voltar");
		
		this.pnPrincipal = new JPanel(new BorderLayout(5,5));
		
		this.pnJogadores = new JPanel(new GridLayout(11,1,5,5));
		this.pnJogadores.setBorder( BorderFactory.createTitledBorder("RECORDES") );
		
		this.pnPrincipal.add(btVoltar,BorderLayout.SOUTH);
		//DAOJogador  dao = new DAOJogador();
		
		//ArrayList elementos = (ArrayList) dao.buscaTodosJogadores();
		JLabel lbJogador = new JLabel("Jogador:");
		JLabel lbMovimentos = new JLabel("Movimentos:");
		JPanel pnteste1 = new JPanel(new GridLayout(1,2,5,5));
		pnteste1.add(lbJogador);
		
		pnteste1.add(lbMovimentos);
		this.pnJogadores.add(pnteste1);
		this.pnJogadores.add(pnteste1);
	
		for (Object object : jogadores) {
			Jogador jogador =  (Jogador) object;
			
			JPanel pnLinha = new JPanel(new GridLayout(1,2,5,5));			
			pnLinha.add(new JLabel(jogador.getNome()));			
			pnLinha.add(new JLabel( String.valueOf(jogador.getMovimentos())));
			this.pnJogadores.add(pnLinha);
			
		}
		this.pnPrincipal.add(pnJogadores,BorderLayout.CENTER);
		this.setLayout(new FlowLayout());
		this.add(pnJogadores);
		
	}
	
}
