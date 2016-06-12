package controller;

import java.time.LocalDate;
import java.util.Vector;

import dao.Dao;
import dao.DaoFactory;
import dto.FuncionarioDTO;
import model.Funcionario;
import util.DaoException;

public class FuncionarioService {
	public FuncionarioDTO processarInclusao(int pMatricula, String pNome, String pSetor, long pTelefone, LocalDate pDataNascimento) {
		try {
			// Criando o objeto DAO para a inclus�o
			Dao<Funcionario, String> tDao = DaoFactory.getFuncionarioDao();

			// Criando o objeto para persist�ncia
			Funcionario tFuncionario = new Funcionario(pMatricula, pNome, pSetor, pTelefone, pDataNascimento);

			// Persistindo o objeto e verificando se deu OK
			if (tDao.gravar(tFuncionario))
				return new FuncionarioDTO(true, "Funcion�rio inclu�do com sucesso", tFuncionario);

			return new FuncionarioDTO(false, "Funcion�rio j� existe no cadastro");
		} catch (DaoException tExcept) {
			return new FuncionarioDTO(false, "Problemas na inclus�o do funcion�rio", tExcept);
		}
	}

	public FuncionarioDTO processarAlteracao(int pMatricula, String pNome, String pSetor, long pTelefone, LocalDate pDataNascimento) {
		try {
			// Criando o objeto DAO para a altera��o
			Dao<Funcionario, String> tDao = DaoFactory.getFuncionarioDao();

			// Criando o objeto para persist�ncia
			Funcionario tFuncionario = new Funcionario(pMatricula, pNome, pSetor, pTelefone, pDataNascimento);

			// Alterando o objeto e verificando se deu OK
			if (tDao.regravar(tFuncionario))
				return new FuncionarioDTO(true, "Funcion�rio atualizado com sucesso", tFuncionario);

			return new FuncionarioDTO(false, "Funcion�rio n�o existe no cadastro");
		} catch (DaoException tExcept) {
			return new FuncionarioDTO(false, "Problemas na atualiza��o do funcion�rio", tExcept);
		}
	}

	public FuncionarioDTO processarExclusao(String pMatricula) {
		try {
			// Criando o objeto DAO para a exclus�o
			Dao<Funcionario, String> tDao = DaoFactory.getFuncionarioDao();

			// Realizando a leitura do objeto
			Funcionario tFuncionario = tDao.ler(pMatricula);

			// Verificando se o funcion�rio foi lido
			if (tFuncionario == null)
				return new FuncionarioDTO(false, "Funcion�rio n�o existe no cadastro");

			// Excluindo o objeto e verificando se deu OK
			if (tDao.excluir(pMatricula))
				return new FuncionarioDTO(true, "Funcion�rio exclu�do com sucesso", tFuncionario);

			return new FuncionarioDTO(false, "Funcion�rio n�o existe no cadastro");
		} catch (DaoException tExcept) {
			return new FuncionarioDTO(false, "Problemas na exclus�o do funcion�rio", tExcept);
		}
	}

	public FuncionarioDTO processarConsulta(String pMatricula) {
		try {
			// Criando o objeto DAO para a leitura
			Dao<Funcionario, String> tDao = DaoFactory.getFuncionarioDao();

			// Realizando a leitura do objeto
			Funcionario tFuncionario = tDao.ler(pMatricula);

			// Verificando se o funcion�rio foi lido
			if (tFuncionario == null)
				return new FuncionarioDTO(false, "Funcion�rio n�o existe no cadastro");

			return new FuncionarioDTO(true, "Funcion�rio recuperado com sucesso", tFuncionario);
		} catch (DaoException tExcept) {
			return new FuncionarioDTO(false, "Problemas na recupera��o do funcion�rio", tExcept);
		}
	}

	public FuncionarioDTO processarRelacao() {
		try {
			// Criando o objeto DAO para a recupera��o da lista
			Dao<Funcionario, String> tDao = DaoFactory.getFuncionarioDao();

			// Reuperando a lista de funcion�rios
			Vector<Funcionario> tLista = tDao.obterRelacaoGeral();

			// verificando se a lista tem funcion�rios ou est� vazia
			if (tLista.isEmpty())
				return new FuncionarioDTO(false, "N�o existem funcion�rios cadastrados");

			return new FuncionarioDTO(true, "Funcion�rios cadastrados", tLista);
		} catch (DaoException tExcept) {
			return new FuncionarioDTO(false, "Problemas na listagem de funcion�rios", tExcept);
		}
	}
}
