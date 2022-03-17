package utils;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Formatador {
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
	private static Locale ptBr = new Locale("pt", "BR");
	public static NumberFormat rsf = NumberFormat.getCurrencyInstance(ptBr);
}
