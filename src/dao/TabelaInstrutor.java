package dao;

import java.io.File;
import java.util.Vector;

import model.Instrutor;
import util.DaoException;

public class TabelaInstrutor extends ArquivoTextoDao implements Dao<Instrutor, String>{
	static
    {
        // Caso o diretório não exista, o mesmo será criado
        File tDir = new File(DIRETORIO + TabelaInstrutor.class.getClass().getSimpleName());
        if (!tDir.exists())
            if (!tDir.mkdirs())
                throw new IllegalArgumentException("Erro na criação do diretório " + DIRETORIO);
    }

    @Override
    public Instrutor ler(String pChave) throws DaoException
    {
    	Instrutor tInstrutor = new Instrutor();

        String tObjeto = lerObjeto(pChave);
        if (tObjeto == null)
            return null;

        carregarInstrutor(tObjeto, tInstrutor);

        return tInstrutor;
    }

    @Override
    public boolean gravar(Instrutor pEntidade) throws DaoException
    {
        String tLinha = pEntidade.getCodigo() + SEPARADOR +
						pEntidade.getNome() + SEPARADOR +
						pEntidade.getEmpresa() + SEPARADOR +
						pEntidade.getTelefone() + SEPARADOR +
						pEntidade.getDocumento() + SEPARADOR +
		                pEntidade.getTipoDocumento();

        return gravarObjeto(String.valueOf(pEntidade.getCodigo()), tLinha);
    }

    @Override
    public boolean regravar(Instrutor pEntidade) throws DaoException
    {
        String tLinha = pEntidade.getCodigo() + SEPARADOR +
        				pEntidade.getNome() + SEPARADOR +
        				pEntidade.getEmpresa() + SEPARADOR +
        				pEntidade.getTelefone() + SEPARADOR +
        				pEntidade.getDocumento() + SEPARADOR +
                        pEntidade.getTipoDocumento();

        return regravarObjeto(String.valueOf(pEntidade.getCodigo()), tLinha);
    }

    @Override
    public boolean excluir(String pChave) throws DaoException
    {
        return excluirObjeto(pChave);
    }

    @Override
    public Vector<Instrutor> obterRelacaoGeral() throws DaoException
    {
        String[] tLinhas = obterListaObjetos();

        Vector<Instrutor> tRelacao = new Vector<>();

        for (String tLinha : tLinhas)
        {
        	Instrutor tInstrutor = new Instrutor();
            carregarInstrutor(tLinha, tInstrutor);
            tRelacao.add(tInstrutor);
        }
        return tRelacao;
    }

    private void carregarInstrutor(String pObjeto, Instrutor pInstrutor)
    {
        String[] tPartes = pObjeto.split(SEPARADOR);
        pInstrutor.setCodigo(Integer.parseInt(tPartes[0]));
        pInstrutor.setNome(tPartes[1]);
        pInstrutor.setEmpresa(tPartes[2]);
        pInstrutor.setTelefone(Long.parseLong(tPartes[3]));
        pInstrutor.setDocumento(tPartes[4]);
        pInstrutor.setTipoDocumento(tPartes[5]);
    }
}
