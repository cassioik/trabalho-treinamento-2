package controller;

import java.util.Vector;

import dao.Dao;
import dao.DaoFactory;
import dto.UsuarioDTO;
import model.Usuario;
import util.DaoException;

public class UsuarioService
{

    public UsuarioDTO validarUsuario(String pConta, String pSenha)
    {
        try
        {
            // Criando o objeto DAO para a leitura
            Dao<Usuario, String> tDao = DaoFactory.getUsuarioDao();

            // Realizando a leitura do objeto
            Usuario tUsuario = tDao.ler(pConta);

            // Verificando se o usuário foi lido
            if (tUsuario == null)
                return new UsuarioDTO(false, "Usuário não existe no cadastro");

            // Validando a senha
            if (tUsuario.getSenha().equals(pSenha))
                return new UsuarioDTO(true, "Usuário validado com sucesso", tUsuario);

            return new UsuarioDTO(false, "Senha do usuário inválida");
        }
        catch (DaoException tExcept)
        {
            return new UsuarioDTO(false, "Problemas na recuperação do usuário", tExcept);
        }
    }

    public UsuarioDTO processarInclusao(String tConta, String tSenha)
    {
        try
        {
            // Criando o objeto DAO para a inclusão
            Dao<Usuario, String> tDao = DaoFactory.getUsuarioDao();

            // Criando o objeto para persistência
            Usuario tUsuario = new Usuario(tConta, tSenha);

            // Persistindo o objeto e verificando se deu OK
            if (tDao.gravar(tUsuario))
                return new UsuarioDTO(true, "Usuário incluído com sucesso", tUsuario);

            return new UsuarioDTO(false, "Usuário já existe no cadastro");
        }
        catch (DaoException tExcept)
        {
            return new UsuarioDTO(false, "Problemas na inclusão do usuário", tExcept);
        }
    }

    public UsuarioDTO processarAlteracao(String pConta, String pSenha)
    {
        try
        {
            // Criando o objeto DAO para a alteração
            Dao<Usuario, String> tDao = DaoFactory.getUsuarioDao();

            // Criando o objeto para persistência
            Usuario tUsuario = new Usuario(pConta, pSenha);

            // Alterando o objeto e verificando se deu OK
            if (tDao.regravar(tUsuario))
                return new UsuarioDTO(true, "Usuário atualizado com sucesso", tUsuario);

            return new UsuarioDTO(false, "Usuário não existe no cadastro");
        }
        catch (DaoException tExcept)
        {
            return new UsuarioDTO(false, "Problemas na atualização do usuário", tExcept);
        }
    }

    public UsuarioDTO processarExclusao(String pConta)
    {
        try
        {
            // Criando o objeto DAO para a exclusão
            Dao<Usuario, String> tDao = DaoFactory.getUsuarioDao();

            // Realizando a leitura do objeto
            Usuario tUsuario = tDao.ler(pConta);

            // Verificando se o usuário foi lido
            if (tUsuario == null)
                return new UsuarioDTO(false, "Usuário não existe no cadastro");

            // Excluindo o objeto e verificando se deu OK
            if (tDao.excluir(pConta))
                return new UsuarioDTO(true, "Usuário excluído com sucesso", tUsuario);

            return new UsuarioDTO(false, "Usuário não existe no cadastro");
        }
        catch (DaoException tExcept)
        {
            return new UsuarioDTO(false, "Problemas na exclusão do usuário", tExcept);
        }
    }

    public UsuarioDTO processarConsulta(String pConta)
    {
        try
        {
            // Criando o objeto DAO para a leitura
            Dao<Usuario, String> tDao = DaoFactory.getUsuarioDao();

            // Realizando a leitura do objeto
            Usuario tUsuario = tDao.ler(pConta);

            // Verificando se o usuário foi lido
            if (tUsuario == null)
                return new UsuarioDTO(false, "Usuário não existe no cadastro");

            return new UsuarioDTO(true, "Usuário recuperado com sucesso", tUsuario);
        }
        catch (DaoException tExcept)
        {
            return new UsuarioDTO(false, "Problemas na recuperação do usuário", tExcept);
        }
    }

    public UsuarioDTO processarRelacao()
    {
        try
        {
            // Criando o objeto DAO para a recuperação da lista
            Dao<Usuario, String> tDao = DaoFactory.getUsuarioDao();

            // Reuperando a lista de usuários
            Vector<Usuario> tLista = tDao.obterRelacaoGeral();

            // verificando se a lista tem usuários ou está vazia
            if (tLista.isEmpty())
                return new UsuarioDTO(false, "Não existem usuários cadastrados");

            return new UsuarioDTO(true, "Usuários cadastrados", tLista);
        }
        catch (DaoException tExcept)
        {
            return new UsuarioDTO(false, "Problemas na inclusão do usuário", tExcept);
        }
    }

}
