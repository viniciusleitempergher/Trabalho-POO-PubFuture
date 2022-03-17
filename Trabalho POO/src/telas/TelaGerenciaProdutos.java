package telas;

import javax.swing.JOptionPane;

public class TelaGerenciaProdutos {
	public void inicia() {
		infinito: while (true) {
			String[] opcoes = {
					"Cadastrar Produto",
	                "Alterar Produto",
	                "Remover Produto",
	                "Listar Produtos",
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
		}
	}
}
