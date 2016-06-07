package adt;

public class SenhaUsuarioADT
{
    private static final String MENSAGEM_CONTEUDO_INVALIDO = "Senha somente deve ter somente caracteres digitáveis";
    private static final String MENSAGEM_ERRO_TAMANHO      = "Senha deve ter entre 4 e 10 caracteres";
    private static final String MENSAGEM_INFORMACAO_NULA   = "Senha não pode ser nula";

    public static void validar(String pSenha)
    {
        if (pSenha == null)
            throw new IllegalArgumentException(MENSAGEM_INFORMACAO_NULA);
        if (pSenha.length() < 4 || pSenha.length() > 10)
            throw new IllegalArgumentException(MENSAGEM_ERRO_TAMANHO);
        for (int i = 0; i < pSenha.length(); i++)
        {
            char tCh = pSenha.charAt(i);
            if (tCh <= ' ' || tCh > '~')
                throw new IllegalArgumentException(MENSAGEM_CONTEUDO_INVALIDO);
        }
    }

    public static String consistir(String pSenha)
    {
        if (pSenha == null)
            return MENSAGEM_INFORMACAO_NULA;
        if (pSenha.length() < 4 || pSenha.length() > 10)
            return MENSAGEM_ERRO_TAMANHO;
        for (int i = 0; i < pSenha.length(); i++)
        {
            char tCh = pSenha.charAt(i);
            if (tCh <= ' ' || tCh > '~')
                return MENSAGEM_CONTEUDO_INVALIDO;
        }
        return "";
    }

}
