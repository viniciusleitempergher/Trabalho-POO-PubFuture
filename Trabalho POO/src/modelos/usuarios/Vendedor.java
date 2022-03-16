package modelos.usuarios;

import java.util.ArrayList;

import modelos.Venda;

public class Vendedor {
	protected String login, senha;
	protected ArrayList<Venda> vendas;
	protected double salario;
	protected double comissao;
	protected String perguntaSecreta;
	protected String respostaSecreta;
	
	public Vendedor(String login, String senha, ArrayList<Venda> vendas, 
			String perguntaSecreta, String respostaSecreta) {
		this.login = login;
		this.senha = senha;
		this.vendas = vendas;
		this.salario = 1200;
		this.comissao = 0.08;
		this.perguntaSecreta = perguntaSecreta;
		this.respostaSecreta = respostaSecreta;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public double getComissao() {
		return comissao;
	}

	public void setComissao(double comissao) {
		this.comissao = comissao;
	}

	public ArrayList<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(ArrayList<Venda> vendas) {
		this.vendas = vendas;
	}

	public String getPerguntaSecreta() {
		return perguntaSecreta;
	}

	public void setPerguntaSecreta(String perguntaSecreta) {
		this.perguntaSecreta = perguntaSecreta;
	}

	public String getRespostaSecreta() {
		return respostaSecreta;
	}

	public void setRespostaSecreta(String respostaSecreta) {
		this.respostaSecreta = respostaSecreta;
	}
}