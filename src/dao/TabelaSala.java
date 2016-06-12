package dao;

import java.io.File;
import java.util.Vector;

import model.Sala;
import util.DaoException;

public class TabelaSala extends ArquivoTextoDao implements Dao<Sala, String> {
	
	static
    {
        // Caso o diretório não exista, o mesmo será criado
        File tDir = new File(DIRETORIO + TabelaSala.class.getClass().getSimpleName());
        if (!tDir.exists())
            if (!tDir.mkdirs())
                throw new IllegalArgumentException("Erro na criação do diretório " + DIRETORIO);
    }
	
	@Override
	public Sala ler(String pChave) throws DaoException {
		Sala tSala = new Sala();

        String tObjeto = lerObjeto(pChave);
        if (tObjeto == null)
            return null;

        carregarSala(tObjeto, tSala);

        return tSala;
	}

	@Override
	public boolean gravar(Sala pEntidade) throws DaoException {
		String tLinha = pEntidade.getCodigo() + SEPARADOR +
				pEntidade.getNome() + SEPARADOR +
				pEntidade.getCapacidade() + SEPARADOR +
        		pEntidade.getEndereco();

		return gravarObjeto(pEntidade.getCodigo(), tLinha);
	}

	@Override
	public boolean regravar(Sala pEntidade) throws DaoException {
		String tLinha = pEntidade.getCodigo() + SEPARADOR +
				pEntidade.getNome() + SEPARADOR +
				pEntidade.getCapacidade() + SEPARADOR +
        		pEntidade.getEndereco();

		return regravarObjeto(pEntidade.getCodigo(), tLinha);
	}

	@Override
	public boolean excluir(String pChave) throws DaoException {
		return excluirObjeto(pChave);
	}

	@Override
	public Vector<Sala> obterRelacaoGeral() throws DaoException {
		String[] tLinhas = obterListaObjetos();

        Vector<Sala> tRelacao = new Vector<>();

        for (String tLinha : tLinhas)
        {
        	Sala tSala = new Sala();
            carregarSala(tLinha, tSala);
            tRelacao.add(tSala);
        }
        return tRelacao;
	}
	
	private void carregarSala(String pObjeto, Sala pSala)
    {
        String[] tPartes = pObjeto.split(SEPARADOR);
        pSala.setCodigo(tPartes[0]);
        pSala.setNome(tPartes[1]);
        pSala.setCapacidade(Integer.parseInt(tPartes[2]));
        pSala.setEndereco(tPartes[3]);
    }

}
