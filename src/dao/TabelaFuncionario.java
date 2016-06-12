package dao;

import java.io.File;
import java.time.LocalDate;
import java.util.Vector;

import model.Funcionario;
import util.DaoException;

public class TabelaFuncionario extends ArquivoTextoDao implements Dao<Funcionario, String>{
	
	static
    {
        // Caso o diretório não exista, o mesmo será criado
        File tDir = new File(DIRETORIO + TabelaFuncionario.class.getClass().getSimpleName());
        if (!tDir.exists())
            if (!tDir.mkdirs())
                throw new IllegalArgumentException("Erro na criação do diretório " + DIRETORIO);
    }
	
	@Override
	public Funcionario ler(String pChave) throws DaoException {
		Funcionario tFuncionario = new Funcionario();

        String tObjeto = lerObjeto(pChave);
        if (tObjeto == null)
            return null;

        carregarFuncionario(tObjeto, tFuncionario);

        return tFuncionario;
	}

	@Override
	public boolean gravar(Funcionario pEntidade) throws DaoException {
		String tLinha = pEntidade.getMatricula() + SEPARADOR +
						pEntidade.getNome() + SEPARADOR +
						pEntidade.getSetor() + SEPARADOR +
						pEntidade.getTelefone() + SEPARADOR +
		        		pEntidade.getDataNascimento();

		return gravarObjeto(String.valueOf(pEntidade.getMatricula()), tLinha);
	}

	@Override
	public boolean regravar(Funcionario pEntidade) throws DaoException {
		String tLinha = pEntidade.getMatricula() + SEPARADOR +
						pEntidade.getNome() + SEPARADOR +
						pEntidade.getSetor() + SEPARADOR +
						pEntidade.getTelefone() + SEPARADOR +
		        		pEntidade.getDataNascimento();

		return regravarObjeto(String.valueOf(pEntidade.getMatricula()), tLinha);
	}

	@Override
	public boolean excluir(String pChave) throws DaoException {
		return excluirObjeto(pChave);
	}

	@Override
	public Vector<Funcionario> obterRelacaoGeral() throws DaoException {
		String[] tLinhas = obterListaObjetos();

        Vector<Funcionario> tRelacao = new Vector<>();

        for (String tLinha : tLinhas)
        {
        	Funcionario tFuncionario = new Funcionario();
            carregarFuncionario(tLinha, tFuncionario);
            tRelacao.add(tFuncionario);
        }
        return tRelacao;
	}

	private void carregarFuncionario(String pObjeto, Funcionario pFuncionario)
    {
        String[] tPartes = pObjeto.split(SEPARADOR);
        pFuncionario.setMatricula(Integer.parseInt(tPartes[0]));
        pFuncionario.setNome(tPartes[1]);
        pFuncionario.setSetor(tPartes[2]);
        pFuncionario.setTelefone(Long.parseLong(tPartes[3]));
        pFuncionario.setDataNascimento(LocalDate.parse(tPartes[4]));
    }
}
