package adt;

public class EmpresaADT {
	public static String consistir(String pEmpresa) {
		if (pEmpresa == null || pEmpresa.isEmpty())
			return "Nome da empresa n�o pode ser vazio";
		return "";
	}
}
