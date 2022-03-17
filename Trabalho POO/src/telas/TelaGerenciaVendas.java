package telas;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import main.Main;
import modelos.Produto;
import modelos.Venda;
import utils.Formatador;
import utils.Perguntador;

public class TelaGerenciaVendas {
	public void iniciar() {
		infinito: while (true) {
			String[] opcoes = {
					"Adicionar Venda",
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
				Venda venda = perguntarVenda();
				Main.vS.cadastrar(venda);
				break;
			case 1:
				ArrayList<Venda> vendas = Main.vS.listar();
				
				if (vendas.size() == 0) {
					JOptionPane.showMessageDialog(null, "Nenhuma venda!");
					break;
				}
				
				String vendasTxt = "Vendas: \n\n";
				int count = 0;
				
				for (Venda v : vendas) {
					vendasTxt += count++ + ")\n";
					vendasTxt += "Data: " + Formatador.sdf.format(v.getData()) + "\n";
					vendasTxt += "Valor Total: " + v.getValorTotal() + "\n";
					vendasTxt += "Produtos: \n";
					for (Produto p : v.getProdutos()) {
						vendasTxt += p.getNome() + " - Valor: " + p.getValor() + "\n";
					}
					vendasTxt += "\n";
				}
				vendasTxt += "Qual destas deseja remover? (Digite o número)";
				
				int indiceVenda = Perguntador.perguntarInt(vendasTxt);
				
				Main.vS.remover(indiceVenda);
				
				JOptionPane.showMessageDialog(null, "Venda removida!");
				
				break;
			case 2:
				vendas = Main.vS.listar();
				
				if (vendas.size() == 0) {
					JOptionPane.showMessageDialog(null, "Nenhuma venda!");
					break;
				}
				
				vendasTxt = "Vendas: \n\n";
				
				for (Venda v : vendas) {
					vendasTxt += "Data: " + Formatador.sdf.format(v.getData()) + "\n";
					vendasTxt += "Valor: " + v.getValorTotal() + "\n";
					vendasTxt += "Produtos: \n";
					for (Produto p : v.getProdutos()) {
						vendasTxt += p.getNome() + " - Valor: " + p.getValor() + "\n";
					}
					vendasTxt += "\n";
				}
				
				JOptionPane.showMessageDialog(null, vendasTxt);
				
				break;
			case 3:
				break infinito;
			}
		}
	}
	
	private Venda perguntarVenda() {
		ArrayList<Produto> produtos = new ArrayList<>();
		double total = 0;
		
		while (true) {
			boolean invalido = true;
			
			Produto p = null;
			
			while (invalido) {
				String nome = Perguntador.perguntar("Nome do produto que será vendido:");
				p = Main.pS.pesquisar(nome);
				
				if (p == null) {
					JOptionPane.showMessageDialog(null, "Produto não encontrado!");
				} else {
					invalido = false;
					JOptionPane.showMessageDialog(null, "Produto adicionado!");
					total += p.getValor();
					produtos.add(p);
				}
			}
			
			if (!Perguntador.simOuNao("Deseja adicionar mais produtos?")) break;
		}		
		
		return new Venda(produtos, total, new Date());
	}
}
