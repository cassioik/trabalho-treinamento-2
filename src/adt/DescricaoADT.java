package adt;

public class DescricaoADT {
	public static String consistir(String pDescricao) {
		if (pDescricao == null || pDescricao.isEmpty())
			return "Descri��o n�o pode ser vazio";
		return "";
	}
}
