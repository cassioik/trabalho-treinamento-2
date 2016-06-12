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
			// Criando o objeto DAO para a inclusão
			Dao<Curso, String> tDao = DaoFactory.getCursoDao();

			// Criando o objeto para persistência
			Curso tCurso = new Curso(pCodigo, pNome, pDescricao, pCargaHorario);

			// Persistindo o objeto e verificando se deu OK
			if (tDao.gravar(tCurso))
				return new CursoDTO(true, "Curso incluído com sucesso", tCurso);

			return new CursoDTO(false, "Curso já existe no cadastro");
		} catch (DaoException tExcept) {
			return new CursoDTO(false, "Problemas na inclusão do curso", tExcept);
		}
	}

	public CursoDTO processarAlteracao(String pCodigo, String pNome, String pDescricao, int pCargaHorario) {
		try {
			// Criando o objeto DAO para a alteração
			Dao<Curso, String> tDao = DaoFactory.getCursoDao();

			// Criando o objeto para persistência
			Curso tCurso = new Curso(pCodigo, pNome, pDescricao, pCargaHorario);

			// Alterando o objeto e verificando se deu OK
			if (tDao.regravar(tCurso))
				return new CursoDTO(true, "Curso atualizado com sucesso", tCurso);

			return new CursoDTO(false, "Curso não existe no cadastro");
		} catch (DaoException tExcept) {
			return new CursoDTO(false, "Problemas na atualização do curso", tExcept);
		}
	}

	public CursoDTO processarExclusao(String pCodigo) {
		try {
			// Criando o objeto DAO para a exclusão
			Dao<Curso, String> tDao = DaoFactory.getCursoDao();

			// Realizando a leitura do objeto
			Curso tCurso = tDao.ler(pCodigo);

			// Verificando se o curso foi lido
			if (tCurso == null)
				return new CursoDTO(false, "Curso não existe no cadastro");

			// Excluindo o objeto e verificando se deu OK
			if (tDao.excluir(pCodigo))
				return new CursoDTO(true, "Curso excluído com sucesso", tCurso);

			return new CursoDTO(false, "Curso não existe no cadastro");
		} catch (DaoException tExcept) {
			return new CursoDTO(false, "Problemas na exclusão do curso", tExcept);
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
				return new CursoDTO(false, "Curso não existe no cadastro");

			return new CursoDTO(true, "Curso recuperado com sucesso", tCurso);
		} catch (DaoException tExcept) {
			return new CursoDTO(false, "Problemas na recuperação do curso", tExcept);
		}
	}

	public CursoDTO processarRelacao() {
		try {
			// Criando o objeto DAO para a recuperação da lista
			Dao<Curso, String> tDao = DaoFactory.getCursoDao();

			// Reuperando a lista de usuários
			Vector<Curso> tLista = tDao.obterRelacaoGeral();

			// verificando se a lista tem usuários ou está vazia
			if (tLista.isEmpty())
				return new CursoDTO(false, "Não existem cursos cadastrados");

			return new CursoDTO(true, "Cursos cadastrados", tLista);
		} catch (DaoException tExcept) {
			return new CursoDTO(false, "Problemas na listagem do curso", tExcept);
		}
	}
}
