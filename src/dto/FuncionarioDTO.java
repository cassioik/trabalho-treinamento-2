package dto;

import java.util.Vector;

import model.Funcionario;

public class FuncionarioDTO extends AbstractDTO<Funcionario>{
	public FuncionarioDTO()
    {
        super();
    }

    public FuncionarioDTO(boolean pOk)
    {
        super(pOk);
    }

    public FuncionarioDTO(boolean pOk, String pAviso)
    {
        super(pOk, pAviso);
    }

    public FuncionarioDTO(boolean pOk, String pAviso, Funcionario pObjeto)
    {
        super(pOk, pAviso, pObjeto);
    }

    public FuncionarioDTO(boolean pOk, String pAviso, Exception pExcecao)
    {
        super(pOk, pAviso, pExcecao);
    }

    public FuncionarioDTO(boolean pOk, String pAviso, Vector<Funcionario> pRelacao)
    {
        super(pOk, pAviso, pRelacao);
    }

    public Funcionario getFuncionario()
    {
        return getObjeto();
    }
}
