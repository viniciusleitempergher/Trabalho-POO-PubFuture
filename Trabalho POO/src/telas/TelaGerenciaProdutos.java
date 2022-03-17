package telas;

import javax.swing.JOptionPane;

import main.Main;
import modelos.Marca;
import modelos.Produto;

public class TelaGerenciaProdutos {
	public void iniciar() {
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
			
			switch (opcao) {
			case 0: // Cadastrar
				Produto p = perguntarProduto();
				
				if (p == null) break;
				
				Main.pS.cadastrar(p);
				
				break;
			case 1: // Alterar
				String nome = JOptionPane.showInputDialog("Digite o nome do produto");
				p = Main.pS.pesquisar(nome);
				
				if (p == null) {
					JOptionPane.showMessageDialog(null, "Produto não cadastrado!");
					break;
				} 
				
				JOptionPane.showMessageDialog(null, "Produto encontrado! Digite as novas informações a seguir:");
				
				Produto novoP = perguntarProduto();
				
				if (novoP == null) break;
				
				Main.pS.alterar(p.getNome(), novoP);
				JOptionPane.showMessageDialog(null, "Produto alterado!");
				
				break;
			case 2: // Remover
				nome = JOptionPane.showInputDialog("Digite o nome do produto");
				p = Main.pS.pesquisar(nome);
				
				if (p == null) {
					JOptionPane.showMessageDialog(null, "Produto não cadastrado!");
					break;
				}
				
				Main.pS.remover(p.getNome());
				
				JOptionPane.showMessageDialog(null, "Produto removido!");
				
				break;
			case 3: // Listar
				String produtos = "Lista de Marcas:\n\n";
				for (Produto produto : Main.pS.listar()) {					
					produtos += produto.getNome() + "\n";
					produtos += "Marca: " + Main.mS.listar().get(produto.getIndiceMarca()).getNome() + "\n";
					produtos += "Valor: " + produto.getValor() + "\n\n";
				}
				JOptionPane.showMessageDialog(null, produtos);
				break;
			case 4: // Voltar
				break infinito;
			}
		}
	}
	
	private Produto perguntarProduto() {
		String nomeMarca = JOptionPane.showInputDialog("Digite a marca:");
		Marca marca = Main.mS.pesquisar(nomeMarca);
		
		if (marca == null) {
			JOptionPane.showMessageDialog(null, "Marca não cadastrada!");
			return null;
		}
		
		int indiceMarca = Main.mS.listar().indexOf(marca);
		String nome = JOptionPane.showInputDialog("Digite o nome do produto:");
		double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do produto:"));
		
		return new Produto(indiceMarca, nome, valor);
	}
}
