package services;

import java.util.ArrayList;

import modelos.Produto;
import padrao.CRUD;

public class ProdutoService implements CRUD<Produto> {

	private ArrayList<Produto> produtos = new ArrayList<>();
	
	@Override
	public void cadastrar(Produto marca) {
		produtos.add(marca);
	}

	@Override
	public void remover(String nome) {
		for (Produto produto : produtos) {
			if (produto.getNome().equals(nome)) {
				produtos.remove(produto);
			}
		}
	}

	@Override
	public void alterar(String nome, Produto produto) {
		for (Produto produtoVelho : produtos) {
			if (produtoVelho.getNome().equals(nome)) {
				produtos.remove(produtoVelho);
				produtos.add(produto);
			}
		}
	}

	@Override
	public ArrayList<Produto> listar() {
		return produtos;
	}

	@Override
	public Produto pesquisar(String nome) {
		for (int i = 0; i < produtos.size(); i++) {
			if (produtos.get(i).getNome().equals(nome)) return produtos.get(i);
		}
		return null;
	}
	
}