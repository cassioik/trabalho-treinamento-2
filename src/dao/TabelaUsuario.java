package dao;

import java.io.File;
import java.util.Vector;

import model.Usuario;
import util.DaoException;

public class TabelaUsuario extends ArquivoTextoDao implements Dao<Usuario, String>
{
    static
    {
        // Caso o diretório não exista, o mesmo será criado
        File tDir = new File(DIRETORIO + TabelaUsuario.class.getClass().getSimpleName());
        if (!tDir.exists())
            if (!tDir.mkdirs())
                throw new IllegalArgumentException("Erro na criação do diretório " + DIRETORIO);
    }

    @Override
    public Usuario ler(String pChave) throws DaoException
    {
        Usuario tUsuario = new Usuario();

        String tObjeto = lerObjeto(pChave);
        if (tObjeto == null)
            return null;

        carregarUsuario(tObjeto, tUsuario);

        return tUsuario;
    }

    @Override
    public boolean gravar(Usuario pEntidade) throws DaoException
    {
        String tLinha = pEntidade.getConta() + SEPARADOR +
                        pEntidade.getSenha();

        return gravarObjeto(pEntidade.getConta(), tLinha);
    }

    @Override
    public boolean regravar(Usuario pEntidade) throws DaoException
    {
        String tLinha = pEntidade.getConta() + SEPARADOR +
                        pEntidade.getSenha();

        return regravarObjeto(pEntidade.getConta(), tLinha);
    }

    @Override
    public boolean excluir(String pChave) throws DaoException
    {
        return excluirObjeto(pChave);
    }

    @Override
    public Vector<Usuario> obterRelacaoGeral() throws DaoException
    {
        String[] tLinhas = obterListaObjetos();

        Vector<Usuario> tRelacao = new Vector<>();

        for (String tLinha : tLinhas)
        {
            Usuario tUsuario = new Usuario();
            carregarUsuario(tLinha, tUsuario);
            tRelacao.add(tUsuario);
        }
        return tRelacao;
    }

    private void carregarUsuario(String pObjeto, Usuario pUsuario)
    {
        String[] tPartes = pObjeto.split(SEPARADOR);
        pUsuario.setConta(tPartes[0]);
        pUsuario.setSenha(tPartes[1]);
    }
}
