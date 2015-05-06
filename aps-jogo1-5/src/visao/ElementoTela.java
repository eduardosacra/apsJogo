package visao;

import javax.swing.JButton;

import modelo.Elemento;

public class ElementoTela extends JButton  {
	public Elemento elemento;
	public boolean foiSelecionado;
	public ElementoTela() {
		this.setText("?");
		this.foiSelecionado =false;
	}
	
}
