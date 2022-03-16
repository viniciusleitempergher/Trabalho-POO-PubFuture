package services;

import java.util.ArrayList;

import modelos.usuarios.Vendedor;
import padrao.CRUD;

public class UsuarioService implements CRUD<Vendedor> {

	private ArrayList<Vendedor> usuarios = new ArrayList<>();
	
	@Override
	public void cadastrar(Vendedor usuario) {
		usuarios.add(usuario);
	}

	@Override
	public void remover(String nome) {
		for (Vendedor usuario : usuarios) {
			if (usuario.getLogin().equals(nome)) {
				usuarios.remove(usuario);
			}
		}
	}

	@Override
	public void alterar(String nome, Vendedor usuario) {
		for (Vendedor usuarioVelho : usuarios) {
			if (usuarioVelho.getLogin().equals(nome)) {
				usuarios.remove(usuarioVelho);
				usuarios.add(usuario);
			}
		}
	}

	@Override
	public ArrayList<Vendedor> listar() {
		return usuarios;
	}

	@Override
	public Vendedor pesquisar(String nome) {
		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).getLogin().equals(nome)) return usuarios.get(i);
		}
		return null;
	}
	
}
