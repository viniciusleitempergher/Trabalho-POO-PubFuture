package modelos;

import java.util.ArrayList;
import java.util.Date;

public class Venda {
	private ArrayList<Produto> produtos;
	private double valorTotal;
	private Date data;
	
	public Venda(ArrayList<Produto> produtos, double valorTotal, Date data) {
		this.produtos = produtos;
		this.valorTotal = valorTotal;
		this.data = data;
	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
}
