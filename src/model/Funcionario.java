package model;

import java.time.LocalDate;

import adt.DataADT;
import adt.MatriculaADT;
import adt.NomeADT;
import adt.SetorADT;
import adt.TelefoneADT;

public class Funcionario {
	private int mMatricula = 0;
	private String mNome = "";
	private String mSetor = "";
	private long mTelefone;
	private LocalDate mDataNascimento;
	
	public Funcionario(){
		
	}
	
	public Funcionario(int pMatricula, String pNome, String pSetor, long pTelefone, LocalDate pDataNascimento) {
		super();
		mMatricula = pMatricula;
		mNome = pNome;
		mSetor = pSetor;
		mTelefone = pTelefone;
		mDataNascimento = pDataNascimento;
	}

	public int getMatricula() {
		return mMatricula;
	}

	public void setMatricula(int pMatricula) {
		MatriculaADT.consistir(pMatricula);
		mMatricula = pMatricula;
	}

	public String getNome() {
		return mNome;
	}

	public void setNome(String pNome) {
		NomeADT.consistir(pNome);
		mNome = pNome;
	}

	public String getSetor() {
		return mSetor;
	}

	public void setSetor(String pSetor) {
		SetorADT.consistir(pSetor);
		mSetor = pSetor;
	}

	public long getTelefone() {
		return mTelefone;
	}

	public void setTelefone(long pTelefone) {
		TelefoneADT.consistir(pTelefone);
		mTelefone = pTelefone;
	}

	public LocalDate getDataNascimento() {
		return mDataNascimento;
	}

	public void setDataNascimento(LocalDate pDataNascimento) {
		DataADT.consistir(String.valueOf(pDataNascimento));
		mDataNascimento = pDataNascimento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mDataNascimento == null) ? 0 : mDataNascimento.hashCode());
		result = prime * result + mMatricula;
		result = prime * result + ((mNome == null) ? 0 : mNome.hashCode());
		result = prime * result + ((mSetor == null) ? 0 : mSetor.hashCode());
		result = prime * result + (int) (mTelefone ^ (mTelefone >>> 32));
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
		Funcionario other = (Funcionario) obj;
		if (mDataNascimento == null) {
			if (other.mDataNascimento != null)
				return false;
		} else if (!mDataNascimento.equals(other.mDataNascimento))
			return false;
		if (mMatricula != other.mMatricula)
			return false;
		if (mNome == null) {
			if (other.mNome != null)
				return false;
		} else if (!mNome.equals(other.mNome))
			return false;
		if (mSetor == null) {
			if (other.mSetor != null)
				return false;
		} else if (!mSetor.equals(other.mSetor))
			return false;
		if (mTelefone != other.mTelefone)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Funcionario [mMatricula=" + mMatricula + ", mNome=" + mNome + ", mSetor=" + mSetor + ", mTelefone="
				+ mTelefone + ", mDataNascimento=" + mDataNascimento + "]";
	}
	
	
}
