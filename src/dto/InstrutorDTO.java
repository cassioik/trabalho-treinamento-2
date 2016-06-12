package dto;

import java.util.Vector;

import model.Instrutor;

public class InstrutorDTO extends AbstractDTO<Instrutor>{
	public InstrutorDTO()
    {
        super();
    }

    public InstrutorDTO(boolean pOk)
    {
        super(pOk);
    }

    public InstrutorDTO(boolean pOk, String pAviso)
    {
        super(pOk, pAviso);
    }

    public InstrutorDTO(boolean pOk, String pAviso, Instrutor pObjeto)
    {
        super(pOk, pAviso, pObjeto);
    }

    public InstrutorDTO(boolean pOk, String pAviso, Exception pExcecao)
    {
        super(pOk, pAviso, pExcecao);
    }

    public InstrutorDTO(boolean pOk, String pAviso, Vector<Instrutor> pRelacao)
    {
        super(pOk, pAviso, pRelacao);
    }

    public Instrutor getInstrutor()
    {
        return getObjeto();
    }
}
