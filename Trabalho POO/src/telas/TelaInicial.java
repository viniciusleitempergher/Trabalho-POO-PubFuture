package telas;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class TelaInicial {
	
	public void iniciar(int nivel) {
		ArrayList<String> arrayOpcoes = new ArrayList<>();
		arrayOpcoes.add("Logout");
		arrayOpcoes.add("Vender");
		
		if (nivel > 0) {
			arrayOpcoes.add("Gerenciar Marcas");
			arrayOpcoes.add("Gerenciar Produtos");
		}
		
		if (nivel > 1) arrayOpcoes.add("Gerenciar Usu�rios");
		
		infinito: while (true) {
			int opcao = JOptionPane.showOptionDialog(null,
					"Escolha uma op��o:",
					"Sistema",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null,
					arrayOpcoes.toArray(),
					arrayOpcoes.get(0)
				);
			switch (opcao) {
			case 0:
				break infinito;
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			}
		}
	}
}