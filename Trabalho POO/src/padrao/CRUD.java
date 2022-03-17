package padrao;

import java.util.ArrayList;

public interface CRUD<T> {
	public void cadastrar(T objeto);
	public <U> void remover(U nome);
	public void alterar(String nome, T objeto);
	public ArrayList<T> listar();
	public <U> T pesquisar(U nome);
}
