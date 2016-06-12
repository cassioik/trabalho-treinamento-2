package controller;

import java.util.Vector;

import dao.Dao;
import dao.DaoFactory;
import dto.InstrutorDTO;
import model.Instrutor;
import util.DaoException;

public class InstrutorService {
    public InstrutorDTO processarInclusao(int pCodigo, String pNome, String pEmpresa, long pTelefone, String pDocumento, String pTipoDocumento)
    {
        try
        {
            // Criando o objeto DAO para a inclusão
            Dao<Instrutor, String> tDao = DaoFactory.getInstrutorDao();

            // Criando o objeto para persistência
            Instrutor tInstrutor = new Instrutor(pCodigo, pNome, pEmpresa, pTelefone, pDocumento, pTipoDocumento);

            // Persistindo o objeto e verificando se deu OK
            if (tDao.gravar(tInstrutor))
                return new InstrutorDTO(true, "Instrutor incluído com sucesso", tInstrutor);

            return new InstrutorDTO(false, "Instrutor já existe no cadastro");
        }
        catch (DaoException tExcept)
        {
            return new InstrutorDTO(false, "Problemas na inclusão do instrutor", tExcept);
        }
    }

    public InstrutorDTO processarAlteracao(int pCodigo, String pNome, String pEmpresa, long pTelefone, String pDocumento, String pTipoDocumento)
    {
        try
        {
            // Criando o objeto DAO para a alteração
            Dao<Instrutor, String> tDao = DaoFactory.getInstrutorDao();

            // Criando o objeto para persistência
            Instrutor tInstrutor = new Instrutor(pCodigo, pNome, pEmpresa, pTelefone, pDocumento, pTipoDocumento);

            // Alterando o objeto e verificando se deu OK
            if (tDao.regravar(tInstrutor))
                return new InstrutorDTO(true, "Instrutor atualizado com sucesso", tInstrutor);

            return new InstrutorDTO(false, "Instrutor não existe no cadastro");
        }
        catch (DaoException tExcept)
        {
            return new InstrutorDTO(false, "Problemas na atualização do usuário", tExcept);
        }
    }

    public InstrutorDTO processarExclusao(String pCodigo)
    {
        try
        {
            // Criando o objeto DAO para a exclusão
            Dao<Instrutor, String> tDao = DaoFactory.getInstrutorDao();

            // Realizando a leitura do objeto
            Instrutor tInstrutor = tDao.ler(pCodigo);

            // Verificando se o Instrutor foi lido
            if (tInstrutor == null)
                return new InstrutorDTO(false, "Instrutor não existe no cadastro");

            // Excluindo o objeto e verificando se deu OK
            if (tDao.excluir(pCodigo))
                return new InstrutorDTO(true, "Instrutor excluído com sucesso", tInstrutor);

            return new InstrutorDTO(false, "Instrutor não existe no cadastro");
        }
        catch (DaoException tExcept)
        {
            return new InstrutorDTO(false, "Problemas na exclusão do instrutor", tExcept);
        }
    }

    public InstrutorDTO processarConsulta(String pCodigo)
    {
        try
        {
            // Criando o objeto DAO para a leitura
            Dao<Instrutor, String> tDao = DaoFactory.getInstrutorDao();

            // Realizando a leitura do objeto
            Instrutor tInstrutor = tDao.ler(pCodigo);

            // Verificando se o usuário foi lido
            if (tInstrutor == null)
                return new InstrutorDTO(false, "Instrutor não existe no cadastro");

            return new InstrutorDTO(true, "Instrutor recuperado com sucesso", tInstrutor);
        }
        catch (DaoException tExcept)
        {
            return new InstrutorDTO(false, "Problemas na recuperação do instrutor", tExcept);
        }
    }

    public InstrutorDTO processarRelacao()
    {
        try
        {
            // Criando o objeto DAO para a recuperação da lista
            Dao<Instrutor, String> tDao = DaoFactory.getInstrutorDao();

            // Reuperando a lista de Instrutores
            Vector<Instrutor> tLista = tDao.obterRelacaoGeral();

            // verificando se a lista tem Instrutores ou está vazia
            if (tLista.isEmpty())
                return new InstrutorDTO(false, "Não existem instrutores cadastrados");

            return new InstrutorDTO(true, "Instrutores cadastrados", tLista);
        }
        catch (DaoException tExcept)
        {
            return new InstrutorDTO(false, "Problemas na listagem de instrutores", tExcept);
        }
    }
}
