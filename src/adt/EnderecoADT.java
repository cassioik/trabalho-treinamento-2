package adt;

public class EnderecoADT {
	public static String consistir(String pEndereco) {
		if (pEndereco == null || pEndereco.isEmpty())
			return "Endere�o n�o pode ser vazio";
		return "";
	}
}
