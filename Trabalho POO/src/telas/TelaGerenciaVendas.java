package telas;

import javax.swing.JOptionPane;

public class TelaGerenciaVendas {
	public void iniciar() {
		infinito: while (true) {
			String[] opcoes = {
					"Adicionar Venda",
	                "Alterar Venda",
	                "Remover Venda",
	                "Listar Vendas",
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
				
				break;
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			}
		}
	}
}
