package telas;

import javax.swing.JOptionPane;

import main.Main;
import modelos.usuarios.Administrador;
import modelos.usuarios.Gerente;
import modelos.usuarios.Vendedor;
import utils.Perguntador;

public class Login {
	public int iniciar() {
		String[] opcoes = {
				"Login",
                "Alterar Senha",
                "Sair"
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
		case 0:
			return logar();
		case 1:
			return alterarSenha();
		default:
			return 4;
		}
	}
	
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
