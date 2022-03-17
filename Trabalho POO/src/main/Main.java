package main;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelos.usuarios.Administrador;
import services.MarcaService;
import services.ProdutoService;
import services.UsuarioService;
import services.VendaService;
import telas.Login;
import telas.TelaInicial;

public class Main {
	public static UsuarioService uS = new UsuarioService();
	public static MarcaService mS = new MarcaService();
	public static ProdutoService pS = new ProdutoService();
	public static VendaService vS = new VendaService();
	
	public static void main(String[] args) {
		uS.cadastrar(new Administrador("admin", "admin", "admin@email.com", new ArrayList<>(),
				"Qual o nome da sua primeira escola?", "Escola Aleatória")); // Cadastrar o administrador
		
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
			default:
				break infinito;
			}
		}
	}
	
	static boolean bloqueado = false;
	static int tempoBloqueio = 0;
	
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
}
