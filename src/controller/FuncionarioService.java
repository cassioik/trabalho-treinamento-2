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
			// Criando o objeto DAO para a inclusão
			Dao<Funcionario, String> tDao = DaoFactory.getFuncionarioDao();

			// Criando o objeto para persistência
			Funcionario tFuncionario = new Funcionario(pMatricula, pNome, pSetor, pTelefone, pDataNascimento);

			// Persistindo o objeto e verificando se deu OK
			if (tDao.gravar(tFuncionario))
				return new FuncionarioDTO(true, "Funcionário incluído com sucesso", tFuncionario);

			return new FuncionarioDTO(false, "Funcionário já existe no cadastro");
		} catch (DaoException tExcept) {
			return new FuncionarioDTO(false, "Problemas na inclusão do funcionário", tExcept);
		}
	}

	public FuncionarioDTO processarAlteracao(int pMatricula, String pNome, String pSetor, long pTelefone, LocalDate pDataNascimento) {
		try {
			// Criando o objeto DAO para a alteração
			Dao<Funcionario, String> tDao = DaoFactory.getFuncionarioDao();

			// Criando o objeto para persistência
			Funcionario tFuncionario = new Funcionario(pMatricula, pNome, pSetor, pTelefone, pDataNascimento);

			// Alterando o objeto e verificando se deu OK
			if (tDao.regravar(tFuncionario))
				return new FuncionarioDTO(true, "Funcionário atualizado com sucesso", tFuncionario);

			return new FuncionarioDTO(false, "Funcionário não existe no cadastro");
		} catch (DaoException tExcept) {
			return new FuncionarioDTO(false, "Problemas na atualização do funcionário", tExcept);
		}
	}

	public FuncionarioDTO processarExclusao(String pMatricula) {
		try {
			// Criando o objeto DAO para a exclusão
			Dao<Funcionario, String> tDao = DaoFactory.getFuncionarioDao();

			// Realizando a leitura do objeto
			Funcionario tFuncionario = tDao.ler(pMatricula);

			// Verificando se o funcionário foi lido
			if (tFuncionario == null)
				return new FuncionarioDTO(false, "Funcionário não existe no cadastro");

			// Excluindo o objeto e verificando se deu OK
			if (tDao.excluir(pMatricula))
				return new FuncionarioDTO(true, "Funcionário excluído com sucesso", tFuncionario);

			return new FuncionarioDTO(false, "Funcionário não existe no cadastro");
		} catch (DaoException tExcept) {
			return new FuncionarioDTO(false, "Problemas na exclusão do funcionário", tExcept);
		}
	}

	public FuncionarioDTO processarConsulta(String pMatricula) {
		try {
			// Criando o objeto DAO para a leitura
			Dao<Funcionario, String> tDao = DaoFactory.getFuncionarioDao();

			// Realizando a leitura do objeto
			Funcionario tFuncionario = tDao.ler(pMatricula);

			// Verificando se o funcionário foi lido
			if (tFuncionario == null)
				return new FuncionarioDTO(false, "Funcionário não existe no cadastro");

			return new FuncionarioDTO(true, "Funcionário recuperado com sucesso", tFuncionario);
		} catch (DaoException tExcept) {
			return new FuncionarioDTO(false, "Problemas na recuperação do funcionário", tExcept);
		}
	}

	public FuncionarioDTO processarRelacao() {
		try {
			// Criando o objeto DAO para a recuperação da lista
			Dao<Funcionario, String> tDao = DaoFactory.getFuncionarioDao();

			// Reuperando a lista de funcionários
			Vector<Funcionario> tLista = tDao.obterRelacaoGeral();

			// verificando se a lista tem funcionários ou está vazia
			if (tLista.isEmpty())
				return new FuncionarioDTO(false, "Não existem funcionários cadastrados");

			return new FuncionarioDTO(true, "Funcionários cadastrados", tLista);
		} catch (DaoException tExcept) {
			return new FuncionarioDTO(false, "Problemas na listagem de funcionários", tExcept);
		}
	}
}
