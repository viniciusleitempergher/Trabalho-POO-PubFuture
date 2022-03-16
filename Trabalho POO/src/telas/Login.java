package telas;

import javax.swing.JOptionPane;

import modelos.usuarios.Administrador;
import modelos.usuarios.Gerente;
import modelos.usuarios.Vendedor;
import services.UsuarioService;

public class Login {
	private UsuarioService uS;
	
	public Login(UsuarioService uS) {
		this.uS = uS;
	}
	
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
		String login = JOptionPane.showInputDialog("Digite seu login:");
		String senha = JOptionPane.showInputDialog("Digite sua senha:");
		
		Vendedor v = null;
		
		for (Vendedor usuario : uS.listar()) {
			if (usuario.getLogin().equals(login)
					&& usuario.getSenha().equals(senha)) {
				v = usuario;
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
		String login = JOptionPane.showInputDialog("Digite seu login:");
		
		Vendedor v = null;
		
		for (Vendedor usuario : uS.listar()) {
			if (usuario.getLogin().equals(login)) {
				v = usuario;
			}
		}
		
		if (v != null) {
			String resposta = JOptionPane.showInputDialog(v.getPerguntaSecreta());
			if (resposta.equalsIgnoreCase(v.getRespostaSecreta())) {
				String novaSenha = JOptionPane.showInputDialog("Digite a nova senha:");
				v.setSenha(novaSenha);
				uS.alterar(v.getLogin(), v);
				return 3;
			} else {
				return -2;
			}
		}
		return -3;
	}
}
