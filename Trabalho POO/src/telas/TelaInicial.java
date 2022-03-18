package telas;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class TelaInicial {
	
	/**
	 * Tela inicial do sistema, ap�s logado.
	 * Nela se encontram as op��es de: Logout, Vender, Gerenciar Marcas, Gerenciar Produtos e Gerenciar Usu�rios.
	 * As op��es s�o exibidas de acordo com o n�vel do usu�rio passado como par�metro:
	 * 			N�vel 0 - vendedor: s� tem acesso as fun��es de Logout e Vender
	 * 			N�vel 1 - gerente: tem acesso �s fun��es do vendedor, com o incremento de Gerenciar Marcas e Produtos
	 * 			N�vel 2 - administrador: tem acesso �s fun��es do gerente, com o incremento de Gerenciar Usu�rios
	 * 
	 * @param nivel - O n�vel de acesso do usu�rio logado
	 */
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
