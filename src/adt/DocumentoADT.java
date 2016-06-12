package adt;

import model.TipoDocumento;

public class DocumentoADT {
	public static String consistir(String pDocumento) {
		if (pDocumento == null || pDocumento.isEmpty())
			return "Documento não pode ser vazio";
		return "";
	}
	
	public static String consistirTipo(String pTipoDocumento) {
		if (pTipoDocumento.equals(TipoDocumento.CNH.toString()) || pTipoDocumento.equals(TipoDocumento.PAS.toString()) || pTipoDocumento.equals(TipoDocumento.RG.toString()) || pTipoDocumento.equals(TipoDocumento.TRAB.toString()))
			return "";
		return "Tipo de documentos aceitos: RG, PAS, TRAB ou CNH";
	}
}
