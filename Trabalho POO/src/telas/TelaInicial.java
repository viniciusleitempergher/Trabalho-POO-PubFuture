package telas;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class TelaInicial {
	
	/**
	 * Tela inicial do sistema, após logado.
	 * Nela se encontram as opções de: Logout, Vender, Gerenciar Marcas, Gerenciar Produtos e Gerenciar Usuários.
	 * As opções são exibidas de acordo com o nível do usuário passado como parâmetro:
	 * 			Nível 0 - vendedor: só tem acesso as funções de Logout e Vender
	 * 			Nível 1 - gerente: tem acesso às funções do vendedor, com o incremento de Gerenciar Marcas e Produtos
	 * 			Nível 2 - administrador: tem acesso às funções do gerente, com o incremento de Gerenciar Usuários
	 * 
	 * @param nivel - O nível de acesso do usuário logado
	 */
	public void iniciar(int nivel) {
		ArrayList<String> arrayOpcoes = new ArrayList<>();
		arrayOpcoes.add("Logout");
		arrayOpcoes.add("Vender");
		
		if (nivel > 0) {
			arrayOpcoes.add("Gerenciar Marcas");
			arrayOpcoes.add("Gerenciar Produtos");
		}
		
		if (nivel > 1) arrayOpcoes.add("Gerenciar Usuários");
		
		infinito: while (true) {
			int opcao = JOptionPane.showOptionDialog(null,
					"Escolha uma opção:",
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
				TelaGerenciaVendas telaVendas = new TelaGerenciaVendas();
				telaVendas.iniciar();
				break;
			case 2:
				TelaGerenciaMarcas telaMarcas = new TelaGerenciaMarcas();
				telaMarcas.iniciar();
				break;
			case 3:
				TelaGerenciaProdutos telaProdutos = new TelaGerenciaProdutos();
				telaProdutos.iniciar();
				break;
			case 4:
				TelaGerenciaUsuarios telaUsuarios = new TelaGerenciaUsuarios();
				telaUsuarios.iniciar();
				break;
			}
		}
	}
}
