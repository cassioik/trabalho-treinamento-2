package dto;

import java.util.Vector;

import model.Sala;

public class SalaDTO extends AbstractDTO<Sala>{
	
	public SalaDTO()
    {
        super();
    }

    public SalaDTO(boolean pOk)
    {
        super(pOk);
    }

    public SalaDTO(boolean pOk, String pAviso)
    {
        super(pOk, pAviso);
    }

    public SalaDTO(boolean pOk, String pAviso, Sala pObjeto)
    {
        super(pOk, pAviso, pObjeto);
    }

    public SalaDTO(boolean pOk, String pAviso, Exception pExcecao)
    {
        super(pOk, pAviso, pExcecao);
    }

    public SalaDTO(boolean pOk, String pAviso, Vector<Sala> pRelacao)
    {
        super(pOk, pAviso, pRelacao);
    }

    public Sala getSala()
    {
        return getObjeto();
    }
}
