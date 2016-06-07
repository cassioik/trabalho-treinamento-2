package dto;

import java.util.Vector;

import model.Usuario;

public class UsuarioDTO extends AbstractDTO<Usuario>
{
    public UsuarioDTO()
    {
        super();
    }

    public UsuarioDTO(boolean pOk)
    {
        super(pOk);
    }

    public UsuarioDTO(boolean pOk, String pAviso)
    {
        super(pOk, pAviso);
    }

    public UsuarioDTO(boolean pOk, String pAviso, Usuario pObjeto)
    {
        super(pOk, pAviso, pObjeto);
    }

    public UsuarioDTO(boolean pOk, String pAviso, Exception pExcecao)
    {
        super(pOk, pAviso, pExcecao);
    }

    public UsuarioDTO(boolean pOk, String pAviso, Vector<Usuario> pRelacao)
    {
        super(pOk, pAviso, pRelacao);
    }

    public Usuario getUsuario()
    {
        return getObjeto();
    }
}
