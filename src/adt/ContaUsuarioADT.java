package adt;

public class ContaUsuarioADT
{

    private static final String MENSAGEM_CONTEUDO_INVALIDO = "Conta somente deve ter letras e dígitos";
    private static final String MENSAGEM_ERRO_TAMANHO      = "Conta deve ter entre 4 e 10 caracteres";
    private static final String MENSAGEM_INFORMACAO_NULA   = "Conta não pode ser nula";

    public static void validar(String pConta)
    {
        if (pConta == null)
            throw new IllegalArgumentException(MENSAGEM_INFORMACAO_NULA);
        if (pConta.length() < 4 || pConta.length() > 10)
            throw new IllegalArgumentException(MENSAGEM_ERRO_TAMANHO);
        for (int i = 0; i < pConta.length(); i++)
        {
            char tCh = pConta.charAt(i);
            if (!Character.isLetterOrDigit(tCh))
                throw new IllegalArgumentException(MENSAGEM_CONTEUDO_INVALIDO);
        }
    }

    public static String consistir(String pConta)
    {
        if (pConta == null)
            return MENSAGEM_INFORMACAO_NULA;
        if (pConta.length() < 4 || pConta.length() > 10)
            return MENSAGEM_ERRO_TAMANHO;
        for (int i = 0; i < pConta.length(); i++)
        {
            char tCh = pConta.charAt(i);
            if (!Character.isLetterOrDigit(tCh))
                return MENSAGEM_CONTEUDO_INVALIDO;
        }
        return "";
    }
}
