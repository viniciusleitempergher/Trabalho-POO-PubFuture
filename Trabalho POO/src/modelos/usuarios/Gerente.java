package modelos.usuarios;

import java.util.ArrayList;

import modelos.Venda;

public class Gerente extends Vendedor {
	public Gerente(String login, String senha, String email, ArrayList<Venda> vendas, 
			String perguntaSecreta, String respostaSecreta) {
		super(login, senha, email, vendas, perguntaSecreta, respostaSecreta);
		this.salario = 2500;
		this.comissao = 0.12;
	}
}
