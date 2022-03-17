package telas;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import main.Main;
import modelos.Venda;
import modelos.usuarios.Administrador;
import modelos.usuarios.Gerente;
import modelos.usuarios.Vendedor;
import utils.Perguntador;

public class TelaGerenciaUsuarios {
	public void iniciar() {
		infinito: while (true) {
			String[] opcoes = {
					"Cadastrar Usuário",
	                "Alterar Usuário",
	                "Remover Usuário",
	                "Listar Usuários",
	                "Voltar"
	                };
			int opcao = JOptionPane.showOptionDialog(null,
					"Escolha uma opção:",
					"Sistema",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null,
					opcoes,
					opcoes[0]
				);
			switch (opcao) {
			case 0: // Cadastrar
				Vendedor v = perguntarUsuario();
				Main.uS.cadastrar(v);
				break;
			case 1: // Alterar
				String login = Perguntador.perguntar("Digite o login do usuário:");
				Vendedor pesquisado = Main.uS.pesquisar(login);
				
				if (pesquisado == null) {
					JOptionPane.showMessageDialog(null, "Usuário não encontrado!");
					break;
				}
				
				JOptionPane.showMessageDialog(null, "Usuário encontrado, digite as novas informações a seguir:");
				
				Vendedor novoUsuario = perguntarUsuario();
				
				Main.uS.alterar(login, novoUsuario);
				
				JOptionPane.showMessageDialog(null, "Usuário alterado!");
				break;
			case 2: // Remover
				login = Perguntador.perguntar("Digite o login do usuário:");
				pesquisado = Main.uS.pesquisar(login);
				
				if (pesquisado == null) {
					JOptionPane.showMessageDialog(null, "Usuário não encontrado!");
					break;
				}
				if (pesquisado instanceof Administrador) {
					JOptionPane.showMessageDialog(null, "Impossível deletar o administrador!");
					break;
				}
				
				Main.uS.remover(login);
				JOptionPane.showMessageDialog(null, "Usuário removido!");
				break;
			case 3: // Listar
				ArrayList<Vendedor> usuarios = Main.uS.listar();
				usuarios.forEach(usuario -> {
					JOptionPane.showMessageDialog(null, "Login: " + usuario.getLogin() + "\n"
							+ "Email: " + usuario.getEmail() + "\n"
							+ "Senha: " + usuario.getSenha() + "\n"
							+ "Pergunta: " + usuario.getPerguntaSecreta() + "\n"
							+ "Resposta: " + usuario.getRespostaSecreta() + "\n"
							+ "Cargo: " + (usuario instanceof Administrador ? "Administrador" 
									: (usuario instanceof Gerente ? "Gerente" : "Vendedor")) + "\n"
							+ "Salário: " + usuario.getSalario() + "\n"
							+ "Comissão: " + usuario.calculaComissao()
							);
				});
				break;
			case 4: // Voltar
				break infinito;
			}
		}
	}
	
	private Vendedor perguntarUsuario() {
		String email = Perguntador.perguntar("Digite o email:");
		String login = Perguntador.perguntar("Digite o login:");
		String senha = Perguntador.perguntar("Digite a senha:");
		String fraseRecuperacao = Perguntador.perguntar("Digite a frase de recuperação:");
		String respostaRecuperacao = Perguntador.perguntar("Digite a resposta da frase:");
		
		String[] opcoes = { "Vendedor", "Gerente" };
		
		int opcao = JOptionPane.showOptionDialog(null,
				"Escolha uma cargo:",
				"Sistema",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				opcoes,
				opcoes[0]
			);
		
		if (opcao == 0)
			return new Vendedor(login, senha, email, new ArrayList<Venda>(), fraseRecuperacao, 
					respostaRecuperacao);
		if (opcao == 1)
			return new Gerente(login, senha, email, new ArrayList<Venda>(), fraseRecuperacao,
					respostaRecuperacao);
		
		return null;
	}
}
