package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.xml.ws.handler.MessageContext;

import modelo.DAOJogador;
import modelo.Elemento;
import modelo.Jogador;
import controle.Controle;

public class TelaJogo extends JPanel {
	ElementoTela el1,el2;
	int movimentos,contadorDeElementos;
	Label lbPontos;
	boolean teste;
	JPanel pnPrincipal,pnElementos,pnDicas,pnBotoes,pnJogador;	
	JButton btSairDoJogo,btPause,bt1,bt2;
	ArrayList<ElementoTela> botoes;
	Controle controle;
	
	
	public TelaJogo(List elementos,Controle controle) {
		movimentos =0;
		contadorDeElementos = 0;
		lbPontos = new Label("Movimentos: "+movimentos);
		el1 = new ElementoTela();
		el2 = new ElementoTela();
		teste = false;
		this.botoes = new ArrayList<ElementoTela>();
		this.controle = controle;
		this.controle.iniciaTelaJogo(this);	
		
		//JButton
		this.btPause = new JButton("Pausar");
		this.btPause.setSize(50, 50);
		
		this.btSairDoJogo = new JButton("Sair");
		this.btSairDoJogo.setSize(50, 50);
		
		//JPanel
		this.pnPrincipal = new JPanel(new BorderLayout(5,5));
		
		this.pnElementos = new JPanel(new GridLayout(5,4,5,5));
		boolean bo= true;
		for (Object ob : elementos) {
		

		ElementoTela elementoTela = new ElementoTela();
		//elementoTela.setBackground(Color.darkGray);		
		elementoTela.elemento = (Elemento)ob;
		elementoTela.setHorizontalTextPosition(JButton.CENTER);
		elementoTela.setVerticalTextPosition(JButton.BOTTOM);//(JButton.TOP);
		//elementoTela.setHorizontalAlignment(SwingConstants.SOUTH);//(SwingConstants.SOUTH);//(SwingConstants.);
		//botao.setIcon(icon);	
		elementoTela.setIcon(new ImageIcon("Imagem/ter2.jpg"));
		elementoTela.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(el1.foiSelecionado == false){
					el1 = elementoTela; 
					//elementoTela.setEnabled(false);
					elementoTela.setText(elementoTela.elemento.getNome());
					elementoTela.foiSelecionado = true;
					
					setaImagem(el1);
				
				}else {
					el2 = elementoTela;
					if(!el2.equals(el1)){
						setaImagem(el2);
					//elementoTela.setEnabled(false);
					elementoTela.setText(elementoTela.elemento.getNome());
					elementoTela.foiSelecionado = true;
					controle.verifica(el1,el2);
					}
					//teste = false;
				}
				
			}

			
		});
			this.botoes.add(elementoTela);
			this.pnElementos.add(elementoTela);
		}
		
		this.pnDicas = new JPanel(new FlowLayout(5,5,5));
		
		this.pnBotoes = new JPanel(new GridLayout(3,1,5,5));
		this.pnBotoes.add(this.btPause);
		this.pnBotoes.add(this.btSairDoJogo);
		this.pnBotoes.add(lbPontos);
		this.pnBotoes.setBorder(BorderFactory.createTitledBorder("Menu")  );
		
		this.pnJogador = new JPanel(new FlowLayout());
		this.pnJogador.add(new JLabel(this.controle.getNomeJogador()+", vamos testar nossa memória, encontre o lugar certo de jogar o lixo."));
		
		this.pnPrincipal.add(this.pnJogador,BorderLayout.NORTH);
		this.pnPrincipal.add(this.pnBotoes,BorderLayout.WEST);
		this.pnPrincipal.add(this.pnElementos,BorderLayout.CENTER);
		this.pnPrincipal.add(this.pnDicas,BorderLayout.SOUTH);
		
		this.setLayout(new BorderLayout());
		this.add(pnPrincipal,BorderLayout.CENTER);
		this.setSize(1200, 700);
		
	}

	private void setaImagem(ElementoTela elementoTela) {
		//if(elementoTela.elemento.getNome()=="Lixeira de Plástico"){
			elementoTela.setIcon(elementoTela.elemento.getImagem());
		//}else if(elementoTela.elemento.getNome()=="Lixeira de Papel e Papelão"){
			//elementoTela.setIcon(elementoTela.elemento.getImagem());
		//}
	}
	
	public void naoEIgual() {
		
		this.movimentos+=1;
		this.lbPontos.setText("Movimentos: "+this.movimentos);
		JOptionPane.showMessageDialog(null, "Errou");
		
		el1.setText("?");
		el1.setEnabled(true);
		el2.setText("?");
		el2.setEnabled(true);
		
		el1.setIcon(new ImageIcon("Imagem/ter2.jpg"));
		el2.setIcon(new ImageIcon("Imagem/ter2.jpg"));
		
		el1 = new ElementoTela();
		el2 = new ElementoTela();	
		
	}


	public void saoIguais() {
		
		this.movimentos+=1;
		this.lbPontos.setText("Movimentos: "+this.movimentos);
		JOptionPane.showMessageDialog(null, "Acertou");
		el1.setEnabled(false);
		el2.setEnabled(false);
		el1 = new ElementoTela();
		el2 = new ElementoTela();
				
	}
	public void avisaUsuario(String mensagem){
		JOptionPane.showMessageDialog(null, mensagem);
	}
	public void concluiu(Jogador jogador) {
		el1.setEnabled(false);
		el2.setEnabled(false);
		this.movimentos+=1;
		this.lbPontos.setText("Movimentos: "+this.movimentos);
		JOptionPane.showMessageDialog(null, "Parabéns "+jogador.getNome()+" "+
	"concluiu com "+jogador.getMovimentos()+" movimentos");
		
		this.controle.concluiu();
	}
}
