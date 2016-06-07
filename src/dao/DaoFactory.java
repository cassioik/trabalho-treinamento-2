package dao;

import model.Usuario;

public class DaoFactory
{
    public static Dao<Usuario, String> getUsuarioDao()
    {
        return new TabelaUsuario();
    }
}
