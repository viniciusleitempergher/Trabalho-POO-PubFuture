package telas;

import javax.swing.JOptionPane;

import main.Main;
import modelos.Marca;
import modelos.Produto;
import utils.Formatador;
import utils.Perguntador;

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
					"Escolha uma op??o:",
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
				if (!validarNome(p.getNome())) break;
				
				Main.pS.cadastrar(p);
				
				break;
			case 1: // Alterar
				String nome = Perguntador.perguntar("Digite o nome do produto");
				p = Main.pS.pesquisar(nome);
				
				if (p == null) {
					JOptionPane.showMessageDialog(null, "Produto n?o cadastrado!");
					break;
				} 
				
				JOptionPane.showMessageDialog(null, "Produto encontrado! Digite as novas informa??es a seguir:");
				
				Produto novoP = perguntarProduto();
				
				if (novoP == null) break;
				
				// Caso o nome anterior seja diferente do novo, valida se j? n?o existe um igual
				if  (!p.getNome().equals(novoP.getNome())) {
					if (!validarNome(novoP.getNome())) break;
				}
				
				Main.pS.alterar(p.getNome(), novoP);
				JOptionPane.showMessageDialog(null, "Produto alterado!");
				
				break;
			case 2: // Remover
				nome = Perguntador.perguntar("Digite o nome do produto");
				p = Main.pS.pesquisar(nome);
				
				if (p == null) {
					JOptionPane.showMessageDialog(null, "Produto n?o cadastrado!");
					break;
				}
				
				Main.pS.remover(p.getNome());
				
				JOptionPane.showMessageDialog(null, "Produto removido!");
				
				break;
			case 3: // Listar
				String produtos = "Lista de Produtos:\n\n";
				for (Produto produto : Main.pS.listar()) {					
					produtos += produto.getNome() + "\n";
					produtos += "Marca: " + Main.mS.listar().get(produto.getIndiceMarca()).getNome() + "\n";
					produtos += "Valor: " + Formatador.rsf.format(produto.getValor()) + "\n\n";
				}
				JOptionPane.showMessageDialog(null, produtos);
				break;
			case 4: // Voltar
				break infinito;
			}
		}
	}

	private boolean validarNome(String nome) {
		if (Main.pS.pesquisar(nome) != null) {
			JOptionPane.showMessageDialog(null, "J? existe um produto com este nome!");
			return false;
		}
		return true;
	}
	
	/**
	 * Pergunta as informa??es de um produto ao usu?rio e as retorna como um objeto.
	 * @return Produto - O produto informado
	 */
	private Produto perguntarProduto() {
		String nomeMarca = Perguntador.perguntar("Digite a marca:");
		Marca marca = Main.mS.pesquisar(nomeMarca);
		
		if (marca == null) {
			JOptionPane.showMessageDialog(null, "Marca n?o cadastrada!");
			return null;
		}
		
		int indiceMarca = Main.mS.listar().indexOf(marca);
		String nome = Perguntador.perguntar("Digite o nome do produto:");
		double valor = Perguntador.perguntarDouble("Digite o valor do produto:");
		
		return new Produto(indiceMarca, nome, valor);
	}
}
