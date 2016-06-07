package dto;

import java.util.Vector;

public abstract class AbstractDTO<T>
{
    private boolean            mOk;
    private String             mAviso;
    private Exception          mExcecao;
    private T                  mObjeto;
    private Vector<T>            mRelacao;

    public AbstractDTO()
    {
        this(false, "", null, null, null);
    }

    public AbstractDTO(boolean pOk)
    {
        this(pOk, "", null, null, null);
    }

    public AbstractDTO(boolean pOk, String pAviso)
    {
        this(pOk, pAviso, null, null, null);
    }

    public AbstractDTO(boolean pOk, String pAviso, Exception pExcecao)
    {
        this(pOk, pAviso, pExcecao, null, null);
    }

    public AbstractDTO(boolean pOk, String pAviso, T pObjeto)
    {
        this(pOk, pAviso, null, pObjeto, null);
    }

    public AbstractDTO(boolean pOk, String pAviso, Vector<T> pRelacao)
    {
        this(pOk, pAviso, null, null, pRelacao);
    }

    private AbstractDTO(boolean pOk, String pAviso, Exception pExcecao, T pObjeto, Vector<T> pRelacao)
    {
        setOk(pOk);
        setAviso(pAviso);
        setExcecao(pExcecao);
        setObjeto(pObjeto);
        setRelacao(pRelacao);
    }

    public boolean isOk()
    {
        return mOk;
    }

    public void setOk(boolean pOk)
    {
        mOk = pOk;
    }

    public String getAviso()
    {
        return mAviso;
    }

    public void setAviso(String pAviso)
    {
        mAviso = pAviso;
    }

    public Exception getExcecao()
    {
        return mExcecao;
    }

    public void setExcecao(Exception pExcecao)
    {
        mExcecao = pExcecao;
    }

    public T getObjeto()
    {
        return mObjeto;
    }

    public void setObjeto(T pObjeto)
    {
        mObjeto = pObjeto;
    }

    public Vector<T> getRelacao()
    {
        return mRelacao;
    }

    public void setRelacao(Vector<T> pRelacao)
    {
        mRelacao = pRelacao;
    }

    public String getAvisoCompleto()
    {
        if (getExcecao() != null)
        {
            String tResultado = mAviso + "\n";
            tResultado += getExcecao().getMessage();
            Throwable tExcecao = getExcecao().getCause();
            while (tExcecao != null)
            {
                tResultado +=  "\n" + tExcecao.getMessage();
                tExcecao = tExcecao.getCause();
            }
            return tResultado;
        }
        return mAviso;
    }
}
