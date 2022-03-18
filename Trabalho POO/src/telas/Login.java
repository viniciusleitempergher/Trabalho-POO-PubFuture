package telas;

import javax.swing.JOptionPane;

import main.Main;
import modelos.usuarios.Administrador;
import modelos.usuarios.Gerente;
import modelos.usuarios.Vendedor;
import utils.Perguntador;

public class Login {
	/**
	 * Mostra a primeira tela do sistema com op��o de login, alterar senha e sair
	 * 
	 * @return 	3 - caso a senha seja alterada com sucesso;
	 * 			0 a 2 - retorna o n�vel do usu�rio entre 0 e 2 caso ele fa�a login;
	 * 			-1 - caso ele tente logar com informa��es incorretas;
	 * 			-2 - caso ele tente alterar a senha e erre a resposta da pergunta;
	 * 			-3 - caso ele clique para alterar a senha e informe um email n�o existente.
	 */
	public int iniciar() {
		String[] opcoes = {
				"Login",
                "Alterar Senha",
                "Sair"
                };
		int opcao = JOptionPane.showOptionDialog(null,
				"Escolha uma op��o:",
				"Sistema",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				opcoes,
				opcoes[0]
			);
		switch (opcao) {
		case 0:
			return logar();
		case 1:
			return alterarSenha();
		default:
			return 4;
		}
	}
	
	/**
	 * Pede o login e senha ao usu�rio, retorna o n�vel dele no sistema ou -1 no caso das informa��es estarem incorretas
	 * Tamb�m altera a vari�vel usuarioLogado da classe Main para o novo usu�rio
	 * 
	 * @return nivel - O n�vel do usu�rio logado, -1 caso as informa��es de login forem incorretas
	 */
	private int logar() {
		String login = Perguntador.perguntar("Digite seu login:");
		String senha = Perguntador.perguntar("Digite sua senha:");
		
		Vendedor v = null;
		
		for (Vendedor usuario : Main.uS.listar()) {
			if (usuario.getLogin().equals(login)
					&& usuario.getSenha().equals(senha)) {
				v = usuario;
				Main.usuarioLogado = v;
			}
		}
		
		if (v instanceof Administrador) {
			return 2;
		} else if (v instanceof Gerente) {
			return 1;
		} else if (v instanceof Vendedor) {
			return 0;
		} else {
			return -1;
		}
	}

	/**
	 * M�todo que faz a altera��o da senha
	 * 
	 * @return 	3 - caso bem sucedida;
	 * 			-2 - caso erre a resposta;
	 * 			-3 - caso digite um email inexistente.
	 */
	private int alterarSenha() {
		String email = Perguntador.perguntar("Digite seu email:");
		
		Vendedor v = null;
		
		for (Vendedor usuario : Main.uS.listar()) {
			if (usuario.getEmail().equals(email)) {
				v = usuario;
			}
		}
		
		if (v != null) {
			String resposta = Perguntador.perguntar(v.getPerguntaSecreta());
			if (resposta.equalsIgnoreCase(v.getRespostaSecreta())) {
				String novaSenha = Perguntador.perguntar("Digite a nova senha:");
				v.setSenha(novaSenha);
				Main.uS.alterar(v.getLogin(), v);
				return 3;
			} else {
				return -2;
			}
		}
		return -3;
	}
}
