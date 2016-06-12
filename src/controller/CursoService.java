package controller;

import java.util.Vector;

import dao.Dao;
import dao.DaoFactory;
import dto.CursoDTO;
import model.Curso;
import util.DaoException;

public class CursoService {

	public CursoDTO processarInclusao(String pCodigo, String pNome, String pDescricao, int pCargaHorario) {
		try {
			// Criando o objeto DAO para a inclus�o
			Dao<Curso, String> tDao = DaoFactory.getCursoDao();

			// Criando o objeto para persist�ncia
			Curso tCurso = new Curso(pCodigo, pNome, pDescricao, pCargaHorario);

			// Persistindo o objeto e verificando se deu OK
			if (tDao.gravar(tCurso))
				return new CursoDTO(true, "Curso inclu�do com sucesso", tCurso);

			return new CursoDTO(false, "Curso j� existe no cadastro");
		} catch (DaoException tExcept) {
			return new CursoDTO(false, "Problemas na inclus�o do curso", tExcept);
		}
	}

	public CursoDTO processarAlteracao(String pCodigo, String pNome, String pDescricao, int pCargaHorario) {
		try {
			// Criando o objeto DAO para a altera��o
			Dao<Curso, String> tDao = DaoFactory.getCursoDao();

			// Criando o objeto para persist�ncia
			Curso tCurso = new Curso(pCodigo, pNome, pDescricao, pCargaHorario);

			// Alterando o objeto e verificando se deu OK
			if (tDao.regravar(tCurso))
				return new CursoDTO(true, "Curso atualizado com sucesso", tCurso);

			return new CursoDTO(false, "Curso n�o existe no cadastro");
		} catch (DaoException tExcept) {
			return new CursoDTO(false, "Problemas na atualiza��o do curso", tExcept);
		}
	}

	public CursoDTO processarExclusao(String pCodigo) {
		try {
			// Criando o objeto DAO para a exclus�o
			Dao<Curso, String> tDao = DaoFactory.getCursoDao();

			// Realizando a leitura do objeto
			Curso tCurso = tDao.ler(pCodigo);

			// Verificando se o curso foi lido
			if (tCurso == null)
				return new CursoDTO(false, "Curso n�o existe no cadastro");

			// Excluindo o objeto e verificando se deu OK
			if (tDao.excluir(pCodigo))
				return new CursoDTO(true, "Curso exclu�do com sucesso", tCurso);

			return new CursoDTO(false, "Curso n�o existe no cadastro");
		} catch (DaoException tExcept) {
			return new CursoDTO(false, "Problemas na exclus�o do curso", tExcept);
		}
	}

	public CursoDTO processarConsulta(String pCodigo) {
		try {
			// Criando o objeto DAO para a leitura
			Dao<Curso, String> tDao = DaoFactory.getCursoDao();

			// Realizando a leitura do objeto
			Curso tCurso = tDao.ler(pCodigo);

			// Verificando se o curso foi lido
			if (tCurso == null)
				return new CursoDTO(false, "Curso n�o existe no cadastro");

			return new CursoDTO(true, "Curso recuperado com sucesso", tCurso);
		} catch (DaoException tExcept) {
			return new CursoDTO(false, "Problemas na recupera��o do curso", tExcept);
		}
	}

	public CursoDTO processarRelacao() {
		try {
			// Criando o objeto DAO para a recupera��o da lista
			Dao<Curso, String> tDao = DaoFactory.getCursoDao();

			// Reuperando a lista de usu�rios
			Vector<Curso> tLista = tDao.obterRelacaoGeral();

			// verificando se a lista tem usu�rios ou est� vazia
			if (tLista.isEmpty())
				return new CursoDTO(false, "N�o existem cursos cadastrados");

			return new CursoDTO(true, "Cursos cadastrados", tLista);
		} catch (DaoException tExcept) {
			return new CursoDTO(false, "Problemas na listagem do curso", tExcept);
		}
	}
}
