package visao;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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
import javax.swing.JScrollPane;

import modelo.Elemento;
import modelo.Jogador;
import controle.Controle;

public class TelaMenu extends JPanel {
	TelaJogo tlJogo;
	JButton btNovoJogo;
	JPanel pn1, pnJogos, pnExGrid, pnExFlow;
	Controle controle;
	ImageIcon imagem;
	JPanel pnPrincipal2, pnJogadores, pnJogadores2;
	JButton btVoltar;
	ArrayList jogadores;
	JScrollPane sc;

	public TelaMenu(Controle controle) {
		this.controle = controle;
		inicialisaComponente();
	}

	private void inicialisaComponente() {

		this.jogadores = controle.getRecordes();
		this.btVoltar = new JButton("Voltar");
		this.pn1 = new JPanel(new BorderLayout(5, 5));
		this.pnJogadores2 = new JPanel(new FlowLayout());
		this.pnJogadores = new JPanel(new GridLayout(jogadores.size() + 1, 1,
				5, 5));
		this.pnJogadores
				.setBorder(BorderFactory.createTitledBorder("RECORDES"));
		this.pnJogadores.setPreferredSize(new Dimension(200, 200));

		this.sc = new JScrollPane(pnJogadores2);

		this.pnPrincipal2 = new JPanel(new BorderLayout());
		this.pnPrincipal2.add(btVoltar, BorderLayout.SOUTH);

		JLabel lbJogador = new JLabel("Jogador:");
		JLabel lbMovimentos = new JLabel("Movimentos:");
		JPanel pnteste1 = new JPanel(new GridLayout(1, 2, 0, 0));
		pnteste1.add(lbJogador);

		pnteste1.add(lbMovimentos);
		this.pnJogadores.add(pnteste1);

		for (Object object : jogadores) {
			Jogador jogador = (Jogador) object;

			JPanel pnLinha = new JPanel(new GridLayout(1, 2, 0, 0));
			pnLinha.add(new JLabel(jogador.getNome()));
			pnLinha.add(new JLabel(String.valueOf(jogador.getMovimentos())));
			this.pnJogadores.add(pnLinha);

		}

		this.pnJogadores2.add(this.pnJogadores);

		this.imagem = new ImageIcon("Imagem/especie-de-logo3.jpg");
		this.btNovoJogo = new JButton("Novo Jogo");
		this.btNovoJogo.setSize(40, 50);
		this.btNovoJogo.setToolTipText("Inice um novo jogo");

		this.btNovoJogo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean flag = true;
				String jogador = "";

				jogador = JOptionPane.showInputDialog("Nome do Jogador");
				if (jogador == null) {
					JOptionPane.showMessageDialog(null,
							"Tem certeza ??? \n Teste sua memória.");
				} else if (jogador.length() > 0) {

					flag = false;
					controle.iniciarJogo(jogador);
				} else {
					JOptionPane.showMessageDialog(null,
							"Nome inválido, insira novamente");
				}
			}
		});

		this.pnJogos = new JPanel(new BorderLayout());
		this.pnJogos.add(btNovoJogo, BorderLayout.CENTER);

		this.pnExFlow = new JPanel(new FlowLayout());
		this.pnExFlow.add(this.btNovoJogo);

		this.pn1 = new JPanel(new BorderLayout());
		this.pn1.add(new JLabel(imagem), BorderLayout.CENTER);
		this.pn1.add(this.pnExFlow, BorderLayout.SOUTH);

		this.setLayout(new BorderLayout());
		this.add(pn1, BorderLayout.CENTER);
		this.add(sc, BorderLayout.EAST);

		this.setSize(600, 420);
	}

}
