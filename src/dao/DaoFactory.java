package dao;

import model.Curso;
import model.Funcionario;
import model.Instrutor;
import model.Sala;
import model.Usuario;

public class DaoFactory
{
    public static Dao<Usuario, String> getUsuarioDao()
    {
        return new TabelaUsuario();
    }
    
    public static Dao<Instrutor, String> getInstrutorDao()
    {
        return new TabelaInstrutor();
    }
    
    public static Dao<Curso, String> getCursoDao()
    {
        return new TabelaCurso();
    }
    
    public static Dao<Funcionario, String> getFuncionarioDao()
    {
        return new TabelaFuncionario();
    }
    
    public static Dao<Sala, String> getSalaDao()
    {
        return new TabelaSala();
    }
}
