package util;

public class DaoException extends Exception
{
    private static final long serialVersionUID = -2532161750212131847L;

    public DaoException()
    {
        super();
    }

    public DaoException(String pMessage)
    {
        super(pMessage);
    }

    public DaoException(Throwable pCause)
    {
        super(pCause);
    }

    public DaoException(String pMessage, Throwable pCause)
    {
        super(pMessage, pCause);
    }
}
