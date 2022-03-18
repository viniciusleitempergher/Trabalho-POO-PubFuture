package telas;

import javax.swing.JOptionPane;

import main.Main;
import modelos.Marca;
import modelos.Produto;
import utils.Perguntador;

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
			case 0: // Cadastrar
				String nome = Perguntador.perguntar("Digite o nome da marca:");
				
				if (!validarNome(nome)) break;
				
				Main.mS.cadastrar(new Marca(nome));
				break;
			case 1: // Alterar
				nome = Perguntador.perguntar("Digite o nome da marca:");
				Marca m = Main.mS.pesquisar(nome);
				
				if (m == null) {
					JOptionPane.showMessageDialog(null, "Marca não encontrada!");
					break;
				}
				
				String novoNome = Perguntador.perguntar("Digite o novo nome da marca:");
				
				// Caso o novo nome seja diferente do anterior, valida se já não existe esse nome
				if (!nome.equals(novoNome)) {
					if (!validarNome(novoNome)) break;
				}
				
				m.setNome(novoNome);
				
				Main.mS.alterar(nome, m);
				break;
			case 2: // Remover
				nome = Perguntador.perguntar("Digite o nome da marca:");
				m = Main.mS.pesquisar(nome);
				
				if (m == null) {
					JOptionPane.showMessageDialog(null, "Marca não encontrada!");
					break;
				}
				
				boolean temProdutos = false;
				
				for (Produto p : Main.pS.listar()) {
					if (p.getIndiceMarca() == Main.mS.listar().indexOf(m)) {
						temProdutos = true;
						break;
					}
				}
				
				if (temProdutos) {
					JOptionPane.showMessageDialog(null, "Existem produtos cadastrados desta marca!");
					break;
				}
				
				Main.mS.remover(m.getNome());
				
				break;
			case 3: // Listar
				String marcas = "Lista de Marcas:\n\n";
				for (Marca marca : Main.mS.listar()) {
					marcas += marca.getNome() + "\n";
				}
				JOptionPane.showMessageDialog(null, marcas);
				break;
			case 4: // Voltar
				break infinito;
			}
		}
	}
	
	private boolean validarNome(String nome) {
		if (Main.mS.pesquisar(nome) != null) {
			JOptionPane.showMessageDialog(null, "Já existe uma marca com este nome!");
			return false;
		}
		return true;
	}
}
