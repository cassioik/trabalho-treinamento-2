package dao;

import model.Curso;
import model.Instrutor;
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
}
