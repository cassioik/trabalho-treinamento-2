package adt;

public class CodigoADT {
	public static String consistir(String pCodigo) {
		if (!pCodigo.matches("[a-zA-Z]{4}"))
			return "C�digo precisa ter 4 caracteres alfab�ticos";
		return "";
	}
	
	public static String consistir(int pCodigo) {
		if (pCodigo <= 0)
			return "C�digo precisa ser maior que zero";
		return "";
	}
	
	public static String consistirCurso(String pCodigo) {
		if (!pCodigo.matches("[A-Z]{2}[0-9]{3}"))
			return "Siga o padr�o de c�digos AA999, AA - duas letras maiusculas e 999 tr�s n�meros";
		return "";
	}
}
