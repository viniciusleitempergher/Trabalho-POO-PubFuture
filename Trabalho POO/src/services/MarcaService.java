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
		for (int i = 0; i < marcas.size(); i++) {
			if (marcas.get(i).getNome().equals(nome)) {
				marcas.remove(marcas.get(i));
				break;
			}
		}
	}

	@Override
	public void alterar(String nome, Marca marca) {
		for (int i = 0; i < marcas.size(); i++) {
			if (marcas.get(i).getNome().equals(nome)) {
				marcas.remove(i);
				marcas.add(marca);
				break;
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
