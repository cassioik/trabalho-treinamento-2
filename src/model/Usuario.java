package model;

import adt.ContaUsuarioADT;
import adt.SenhaUsuarioADT;

public class Usuario
{
    private String mConta;
    private String mSenha;

    public Usuario()
    {

    }

    public Usuario(String pConta, String pSenha)
    {
        mConta = pConta;
        mSenha = pSenha;
    }

    public String getConta()
    {
        return mConta;
    }

    public void setConta(String pConta)
    {
        ContaUsuarioADT.validar(pConta);
        mConta = pConta;
    }

    public String getSenha()
    {
        return mSenha;
    }

    public void setSenha(String pSenha)
    {
        SenhaUsuarioADT.validar(pSenha);
        mSenha = pSenha;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((mConta == null) ? 0 : mConta.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Usuario other = (Usuario) obj;
        if (mConta == null)
        {
            if (other.mConta != null)
                return false;
        }
        else
            if (!mConta.equals(other.mConta))
                return false;
        return true;
    }

    @Override
    public String toString()
    {
        StringBuilder tBuilder = new StringBuilder();
        tBuilder.append("Usuario [");
        tBuilder.append(getConta());
        tBuilder.append(", ");
        tBuilder.append(getSenha());
        tBuilder.append("]");
        return tBuilder.toString();
    }
}
