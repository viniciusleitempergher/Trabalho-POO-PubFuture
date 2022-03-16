package modelos.usuarios;

import java.util.ArrayList;

import modelos.Venda;

public class Administrador extends Gerente {
	public Administrador(String login, String senha, ArrayList<Venda> vendas, 
			String perguntaSecreta, String respostaSecreta) {
		super(login, senha, vendas, perguntaSecreta, respostaSecreta);
		this.salario = 6000;
		this.comissao = 0.2;
	}
}
