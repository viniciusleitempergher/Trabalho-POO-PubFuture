package padrao;

import java.util.ArrayList;

public interface CRUD<T> {
	public void cadastrar(T objeto);
	public void remover(String nome);
	public void alterar(String nome, T objeto);
	public ArrayList<T> listar();
	public T pesquisar(String nome);
}
