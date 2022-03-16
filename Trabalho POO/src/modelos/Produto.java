package modelos;

public class Produto {
	private int indiceMarca; // O índice da marca deste produto, no vetor de marcas
	private String nome;
	private double valor;
	
	public Produto(int indiceMarca, String nome, double valor) {
		this.indiceMarca = indiceMarca;
		this.nome = nome;
		this.valor = valor;
	}

	public int getIndiceMarca() {
		return indiceMarca;
	}

	public void setIndiceMarca(int indiceMarca) {
		this.indiceMarca = indiceMarca;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}
