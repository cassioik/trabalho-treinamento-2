package adt;

public class NomeADT {

	public static String consistir(String pNome) {
		if (pNome == null || pNome.isEmpty())
			return "Nome n�o pode ser vazio";
		return "";
	}
}
