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
	public <String> void remover(String nome) {
		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).getLogin().equals(nome)) {
				usuarios.remove(usuarios.get(i));
				break;
			}
		}
	}

	@Override
	public void alterar(String login, Vendedor usuario) {
		for (Vendedor usuarioVelho : usuarios) {
			if (usuarioVelho.getLogin().equals(login)) {
				usuarios.remove(usuarioVelho);
				usuarios.add(usuario);
				break;
			}
		}
	}

	@Override
	public ArrayList<Vendedor> listar() {
		return usuarios;
	}

	@Override
	public <String> Vendedor pesquisar(String nome) {
		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).getLogin().equals(nome)) return usuarios.get(i);
		}
		return null;
	}
	
}
