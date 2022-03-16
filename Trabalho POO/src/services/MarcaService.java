package services;

import java.util.ArrayList;

import modelos.Marca;
import padrao.CRUD;

public class MarcaService implements CRUD<Marca> {

	private ArrayList<Marca> marcas = new ArrayList<>();
	
	@Override
	public void cadastrar(Marca marca) {
		marcas.add(marca);
	}

	@Override
	public void remover(String nome) {
		for (Marca marca : marcas) {
			if (marca.getNome().equals(nome)) {
				marcas.remove(marca);
			}
		}
	}

	@Override
	public void alterar(String nome, Marca marca) {
		for (Marca marcaVelha : marcas) {
			if (marcaVelha.getNome().equals(nome)) {
				marcas.remove(marcaVelha);
				marcas.add(marca);
			}
		}
	}

	@Override
	public ArrayList<Marca> listar() {
		return marcas;
	}

	@Override
	public Marca pesquisar(String nome) {
		for (int i = 0; i < marcas.size(); i++) {
			if (marcas.get(i).getNome().equals(nome)) return marcas.get(i);
		}
		return null;
	}
	
}
