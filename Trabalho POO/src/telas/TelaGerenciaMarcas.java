package telas;

import javax.swing.JOptionPane;

import main.Main;
import modelos.Marca;
import modelos.Produto;

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
				nome = JOptionPane.showInputDialog("Digite o nome da marca:");
				Marca m = Main.mS.pesquisar(nome);
				
				if (m == null) {
					JOptionPane.showMessageDialog(null, "Marca não encontrada!");
					break;
				}
				
				m.setNome(JOptionPane.showInputDialog("Digite o novo nome da marca:"));
				Main.mS.alterar(nome, m);
				break;
			case 2:
				nome = JOptionPane.showInputDialog("Digite o nome da marca:");
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
			case 3:
				String marcas = "Lista de Marcas:\n\n";
				for (Marca marca : Main.mS.listar()) {
					marcas += marca.getNome() + "\n";
				}
				JOptionPane.showMessageDialog(null, marcas);
				break;
			case 4:
				break infinito;
			}
		}
	}
}
