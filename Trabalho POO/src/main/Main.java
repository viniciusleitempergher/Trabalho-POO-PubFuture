package main;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import modelos.Marca;
import modelos.Produto;
import modelos.Venda;
import modelos.usuarios.Administrador;
import modelos.usuarios.Vendedor;
import services.MarcaService;
import services.ProdutoService;
import services.UsuarioService;
import services.VendaService;
import telas.Login;
import telas.TelaInicial;

public class Main {
	public static Vendedor usuarioLogado;
	public static UsuarioService uS = new UsuarioService();
	public static MarcaService mS = new MarcaService();
	public static ProdutoService pS = new ProdutoService();
	public static VendaService vS = new VendaService();
	
	public static void main(String[] args) {
		// Cadastrar o administrador
		uS.cadastrar(new Administrador("admin", "admin", "admin@email.com", new ArrayList<>(),
				"Qual o nome da sua primeira escola?", "Escola Aleatória")); 
		
		preencherArrays();
		
		Login login = new Login();
		int tentativas = 0;
		int tentativasAlterarSenha = 0;
		
		infinito: while (true) {
			int nivelUsuario = login.iniciar();
			
			switch (nivelUsuario) {
			case -3:
				JOptionPane.showMessageDialog(null, "Usuário não encontrado!");
				break;
			case -2:
				JOptionPane.showMessageDialog(null, "Resposta Incorreta!");
				if (++tentativasAlterarSenha == 3) {
					bloquear(60 * 10);
				}
				break;
			case -1:
				JOptionPane.showMessageDialog(null, "Informações incorretas!");
				if (++tentativas == 3) {					
					bloquear(60 * 3);
				}
				break;
			case 0, 1, 2:
				JOptionPane.showMessageDialog(null, "Logado com sucesso!");
				TelaInicial telaInicial = new TelaInicial();
				telaInicial.iniciar(nivelUsuario);
				break;
			case 3:
				JOptionPane.showMessageDialog(null, "Senha alterada!");
				break;
			case 4:
				break infinito;
			}
		}
	}
	
	static boolean bloqueado = false;
	static int tempoBloqueio = 0;
	
	/**
	 * Bloqueia o sistema com uma mensagem mostrando o tempo que falta para ser liberado
	 * @param tempo - O tempo de bloqueio
	 */
	static void bloquear(int tempo) {
		bloqueado = true;
		tempoBloqueio = tempo;
		
		new Thread() {
			@Override
			public void run() {
				while (tempoBloqueio > 0) {
					try {
						Thread.sleep(1000);
						tempoBloqueio--;
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				bloqueado = false;
			}
		}.start();
		
		while (bloqueado) {
			JOptionPane.showMessageDialog(null, "Sistema bloqueado! Aguarde mais " + tempoBloqueio + " segundos");
		}
	}
	
	/**
	 * Método para deixar alguns dados pré cadastrados nos arrays
	 */
	static void preencherArrays() {
		mS.cadastrar(new Marca("Acer"));
		mS.cadastrar(new Marca("Coca"));
		mS.cadastrar(new Marca("Samsung"));
		
		Produto notebook = new Produto(0, "Notebook", 4000);
		pS.cadastrar(notebook);
		
		Produto refri = new Produto(1, "Refri", 15);
		pS.cadastrar(refri);
		
		Produto celular = new Produto(2, "Celular", 3000);
		pS.cadastrar(celular);
		
		ArrayList<Produto> produtos = new ArrayList<>();
		produtos.add(notebook);
		produtos.add(refri);
		vS.cadastrar(new Venda(new ArrayList<Produto>(produtos), 4015, new Date()));
		
		produtos.clear();
		produtos.add(celular);
		produtos.add(refri);
		vS.cadastrar(new Venda(new ArrayList<Produto>(produtos), 3015, new Date()));
		
		produtos.clear();
		produtos.add(refri);
		produtos.add(refri);
		vS.cadastrar(new Venda(new ArrayList<Produto>(produtos), 30, new Date()));
	}
}
