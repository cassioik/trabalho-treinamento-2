package dto;

import java.util.Vector;

import model.Curso;

public class CursoDTO extends AbstractDTO<Curso>{
	
	public CursoDTO()
    {
        super();
    }

    public CursoDTO(boolean pOk)
    {
        super(pOk);
    }

    public CursoDTO(boolean pOk, String pAviso)
    {
        super(pOk, pAviso);
    }

    public CursoDTO(boolean pOk, String pAviso, Curso pObjeto)
    {
        super(pOk, pAviso, pObjeto);
    }

    public CursoDTO(boolean pOk, String pAviso, Exception pExcecao)
    {
        super(pOk, pAviso, pExcecao);
    }

    public CursoDTO(boolean pOk, String pAviso, Vector<Curso> pRelacao)
    {
        super(pOk, pAviso, pRelacao);
    }

    public Curso getCurso()
    {
        return getObjeto();
    }
}
