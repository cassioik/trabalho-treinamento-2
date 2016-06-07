package dao;

import java.util.Vector;

import util.DaoException;

public interface Dao<T, ID>
{
    public abstract T ler(ID pChave) throws DaoException;
    public abstract boolean gravar(T pEntidade) throws DaoException;
    public abstract boolean regravar(T pEntidade) throws DaoException;
    public abstract boolean excluir(ID pChave) throws DaoException;
    public abstract Vector<T> obterRelacaoGeral() throws DaoException;
}
