package utils;

import javax.swing.JOptionPane;

public class Perguntador {
	public static String perguntar(String texto) {
		boolean invalido = true;
		String resposta = "";
		
		while (invalido) {
			resposta = JOptionPane.showInputDialog(texto);
			
			if (resposta == null || resposta.equals("")) {
				JOptionPane.showMessageDialog(null, "Preencha corretamente!");
			} else {
				invalido = false;
			}
		}
		
		return resposta;
	}
	
	public static Double perguntarDouble(String texto) {
		boolean invalido = true;
		double resposta = -1;
		
		while (invalido) {
			try {
				resposta = Double.parseDouble(JOptionPane.showInputDialog(texto));
				if (resposta < 0) {
					throw new NumberFormatException();
				}
				invalido = false;
			} catch (NumberFormatException | NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Preencha corretamente!");
			}
		}
		
		return resposta;
	}
}
