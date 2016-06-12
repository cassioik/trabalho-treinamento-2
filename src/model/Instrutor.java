package model;

import adt.CodigoADT;
import adt.DocumentoADT;
import adt.EmpresaADT;
import adt.NomeADT;
import adt.TelefoneADT;

public class Instrutor {
	private int mCodigo = 0;
	private String mNome = "";
	private String mEmpresa = "";
	private long mTelefone;
	private String mDocumento = "";
	private String mTipoDocumento = "";
	
	public Instrutor(){
		
	}
	
	public Instrutor(int pCodigo, String pNome, String pEmpresa, long pTelefone, String pDocumento,
			String pTipoDocumento) {
		super();
		mCodigo = pCodigo;
		mNome = pNome;
		mEmpresa = pEmpresa;
		mTelefone = pTelefone;
		mDocumento = pDocumento;
		mTipoDocumento = pTipoDocumento;
	}

	public int getCodigo() {
		return mCodigo;
	}

	public void setCodigo(int pCodigo) {
		CodigoADT.consistir(pCodigo);
		mCodigo = pCodigo;
	}

	public String getNome() {
		return mNome;
	}

	public void setNome(String pNome) {
		NomeADT.consistir(pNome);
		mNome = pNome;
	}

	public String getEmpresa() {
		return mEmpresa;
	}

	public void setEmpresa(String pEmpresa) {
		EmpresaADT.consistir(pEmpresa);
		mEmpresa = pEmpresa;
	}

	public long getTelefone() {
		return mTelefone;
	}

	public void setTelefone(long pTelefone) {
		TelefoneADT.consistir(pTelefone);
		mTelefone = pTelefone;
	}

	public String getDocumento() {
		return mDocumento;
	}

	public void setDocumento(String pDocumento) {
		DocumentoADT.consistir(pDocumento);
		mDocumento = pDocumento;
	}

	public String getTipoDocumento() {
		return mTipoDocumento;
	}

	public void setTipoDocumento(String pTipoDocumento) {
		DocumentoADT.consistirTipo(pTipoDocumento);
		mTipoDocumento = pTipoDocumento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + mCodigo;
		result = prime * result + ((mDocumento == null) ? 0 : mDocumento.hashCode());
		result = prime * result + ((mEmpresa == null) ? 0 : mEmpresa.hashCode());
		result = prime * result + ((mNome == null) ? 0 : mNome.hashCode());
		result = prime * result + (int) (mTelefone ^ (mTelefone >>> 32));
		result = prime * result + ((mTipoDocumento == null) ? 0 : mTipoDocumento.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Instrutor other = (Instrutor) obj;
		if (mCodigo != other.mCodigo)
			return false;
		if (mDocumento == null) {
			if (other.mDocumento != null)
				return false;
		} else if (!mDocumento.equals(other.mDocumento))
			return false;
		if (mEmpresa == null) {
			if (other.mEmpresa != null)
				return false;
		} else if (!mEmpresa.equals(other.mEmpresa))
			return false;
		if (mNome == null) {
			if (other.mNome != null)
				return false;
		} else if (!mNome.equals(other.mNome))
			return false;
		if (mTelefone != other.mTelefone)
			return false;
		if (mTipoDocumento == null) {
			if (other.mTipoDocumento != null)
				return false;
		} else if (!mTipoDocumento.equals(other.mTipoDocumento))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Instrutor [mCodigo=" + mCodigo + ", mNome=" + mNome + ", mEmpresa=" + mEmpresa + ", mTelefone="
				+ mTelefone + ", mDocumento=" + mDocumento + ", mTipoDocumento=" + mTipoDocumento + "]";
	}
}
