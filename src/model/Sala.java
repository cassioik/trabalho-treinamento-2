package model;

public class Sala {
	private String mCodigo = null;
	private String mNome = null;
	private int mCapacidade = 0;
	private String mEndereco = null;
	
	public Sala(){
		
	}
	
	public Sala(String pCodigo, String pNome, int pCapacidade, String pEndereco) {
		super();
		mCodigo = pCodigo;
		mNome = pNome;
		mCapacidade = pCapacidade;
		mEndereco = pEndereco;
	}

	public String getCodigo() {
		return mCodigo;
	}

	public void setCodigo(String pCodigo) {
		mCodigo = pCodigo;
	}

	public String getNome() {
		return mNome;
	}

	public void setNome(String pNome) {
		mNome = pNome;
	}

	public int getCapacidade() {
		return mCapacidade;
	}

	public void setCapacidade(int pCapacidade) {
		mCapacidade = pCapacidade;
	}

	public String getEndereco() {
		return mEndereco;
	}

	public void setEndereco(String pEndereco) {
		mEndereco = pEndereco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + mCapacidade;
		result = prime * result + ((mCodigo == null) ? 0 : mCodigo.hashCode());
		result = prime * result + ((mEndereco == null) ? 0 : mEndereco.hashCode());
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
		Sala other = (Sala) obj;
		if (mCapacidade != other.mCapacidade)
			return false;
		if (mCodigo == null) {
			if (other.mCodigo != null)
				return false;
		} else if (!mCodigo.equals(other.mCodigo))
			return false;
		if (mEndereco == null) {
			if (other.mEndereco != null)
				return false;
		} else if (!mEndereco.equals(other.mEndereco))
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
		return "Sala [mCodigo=" + mCodigo + ", mNome=" + mNome + ", mCapacidade=" + mCapacidade + ", mEndereco="
				+ mEndereco + "]";
	}
	
}
