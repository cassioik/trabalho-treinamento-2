package model;

import adt.CargaHorariaADT;
import adt.CodigoADT;
import adt.DescricaoADT;
import adt.NomeADT;

public class Curso {
	private String mCodigo = null;
	private String mNome = null;
	private String mDescricao = null;
	private int mCargaHoraria = 0;
	
	public Curso() {

	}

	public Curso(String pCodigo, String pNome, String pDescricao, int pCargaHorario) {
		super();
		mCodigo = pCodigo;
		mNome = pNome;
		mDescricao = pDescricao;
		mCargaHoraria = pCargaHorario;
	}

	public String getCodigo() {
		return mCodigo;
	}

	public void setCodigo(String pCodigo) {
		CodigoADT.consistirCurso(pCodigo);
		mCodigo = pCodigo;
	}

	public String getNome() {
		return mNome;
	}

	public void setNome(String pNome) {
		NomeADT.consistir(pNome);
		mNome = pNome;
	}

	public String getDescricao() {
		return mDescricao;
	}

	public void setDescricao(String pDescricao) {
		DescricaoADT.consistir(pDescricao);
		mDescricao = pDescricao;
	}

	public int getCargaHoraria() {
		return mCargaHoraria;
	}

	public void setCargaHoraria(int pCargaHoraria) {
		CargaHorariaADT.consistir(pCargaHoraria);
		mCargaHoraria = pCargaHoraria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + mCargaHoraria;
		result = prime * result + ((mCodigo == null) ? 0 : mCodigo.hashCode());
		result = prime * result + ((mDescricao == null) ? 0 : mDescricao.hashCode());
		result = prime * result + ((mNome == null) ? 0 : mNome.hashCode());
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
		Curso other = (Curso) obj;
		if (mCargaHoraria != other.mCargaHoraria)
			return false;
		if (mCodigo == null) {
			if (other.mCodigo != null)
				return false;
		} else if (!mCodigo.equals(other.mCodigo))
			return false;
		if (mDescricao == null) {
			if (other.mDescricao != null)
				return false;
		} else if (!mDescricao.equals(other.mDescricao))
			return false;
		if (mNome == null) {
			if (other.mNome != null)
				return false;
		} else if (!mNome.equals(other.mNome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Curso [mCodigo=" + mCodigo + ", mNome=" + mNome + ", mDescricao=" + mDescricao + ", mCargaHoraria="
				+ mCargaHoraria + "]";
	}
	
}
