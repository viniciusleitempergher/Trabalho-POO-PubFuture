package services;

import java.util.ArrayList;
import java.util.Date;

import modelos.Produto;
import modelos.Venda;
import padrao.CRUD;

public class VendaService implements CRUD<Venda> {

	private ArrayList<Venda> vendas = new ArrayList<>();
	
	@Override
	public void cadastrar(Venda venda) {
		vendas.add(venda);
	}

	@Override
	public <Integer> void remover(Integer indice) {
		vendas.remove((int) indice);
	}

	@Override
	public void alterar(String nome, Venda produto) {
	}

	@Override
	public ArrayList<Venda> listar() {
		return vendas;
	}

	@Override
	public <Date> Venda pesquisar(Date data) {
		for (int i = 0; i < vendas.size(); i++) {
			if (vendas.get(i).getData().equals(data)) return vendas.get(i);
		}
		return null;
	}
}
