package dao;

import java.io.File;
import java.util.Vector;

import model.Curso;
import util.DaoException;

public class TabelaCurso extends ArquivoTextoDao implements Dao<Curso, String> {

	static
    {
        // Caso o diretório não exista, o mesmo será criado
        File tDir = new File(DIRETORIO + TabelaCurso.class.getClass().getSimpleName());
        if (!tDir.exists())
            if (!tDir.mkdirs())
                throw new IllegalArgumentException("Erro na criação do diretório " + DIRETORIO);
    }
	
	@Override
	public Curso ler(String pChave) throws DaoException {
		Curso tCurso = new Curso();

        String tObjeto = lerObjeto(pChave);
        if (tObjeto == null)
            return null;

        carregarCurso(tObjeto, tCurso);

        return tCurso;
	}

	@Override
	public boolean gravar(Curso pEntidade) throws DaoException {
		String tLinha = pEntidade.getCodigo() + SEPARADOR +
						pEntidade.getNome() + SEPARADOR +
						pEntidade.getDescricao() + SEPARADOR +
                		pEntidade.getCargaHoraria();

		return gravarObjeto(pEntidade.getCodigo(), tLinha);
	}

	@Override
	public boolean regravar(Curso pEntidade) throws DaoException {
		String tLinha = pEntidade.getCodigo() + SEPARADOR +
				pEntidade.getNome() + SEPARADOR +
				pEntidade.getDescricao() + SEPARADOR +
        		pEntidade.getCargaHoraria();

		return regravarObjeto(pEntidade.getCodigo(), tLinha);
	}

	@Override
	public boolean excluir(String pChave) throws DaoException {
		return excluirObjeto(pChave);
	}

	@Override
	public Vector<Curso> obterRelacaoGeral() throws DaoException {
		String[] tLinhas = obterListaObjetos();

        Vector<Curso> tRelacao = new Vector<>();

        for (String tLinha : tLinhas)
        {
        	Curso tCurso = new Curso();
            carregarCurso(tLinha, tCurso);
            tRelacao.add(tCurso);
        }
        return tRelacao;
	}
	
	private void carregarCurso(String pObjeto, Curso pCurso)
    {
        String[] tPartes = pObjeto.split(SEPARADOR);
        pCurso.setCodigo(tPartes[0]);
        pCurso.setNome(tPartes[1]);
        pCurso.setDescricao(tPartes[2]);
        pCurso.setCargaHoraria(Integer.parseInt(tPartes[3]));
    }

}
