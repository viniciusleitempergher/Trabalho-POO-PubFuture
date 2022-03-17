package telas;

import javax.swing.JOptionPane;

import main.Main;
import modelos.Marca;

public class TelaGerenciaMarcas {
	public void iniciar() {
		infinito: while (true) {
			String[] opcoes = {
					"Cadastrar Marca",
	                "Alterar Marca",
	                "Remover Marca",
	                "Listar Marcas",
	                "Voltar"
	                };
			int opcao = JOptionPane.showOptionDialog(null,
					"Escolha uma opção:",
					"Sistema",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null,
					opcoes,
					opcoes[0]
				);
			switch (opcao) {
			case 0:
				String nome = JOptionPane.showInputDialog("Digite o nome da marca:");
				Main.mS.cadastrar(new Marca(nome));
				break;
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break infinito;
			}
		}
	}
}
