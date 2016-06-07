package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import util.DaoException;

public abstract class ArquivoTextoDao
{
    protected static final String   DIRETORIO = "BancoDados/";
    protected static final String SEPARADOR = "\b";

    static
    {
        // Caso o diretório não exista, o mesmo será criado
        File tDir = new File(DIRETORIO);
        if (!tDir.exists())
            if (!tDir.mkdirs())
                throw new IllegalArgumentException("Erro na criação do diretório " + DIRETORIO);
    }

    public String lerObjeto(String pChave) throws DaoException
    {
        try
        {
            File tArq1 = new File(DIRETORIO + this.getClass().getSimpleName() +
                            "/" + pChave + ".txt");

            if (!tArq1.exists())
                return null;

            FileReader tArq2 = new FileReader(tArq1);
            BufferedReader tArq3 = new BufferedReader(tArq2);

            String tLinha = tArq3.readLine();

            tArq3.close();

            return tLinha;
        }
        catch (IOException tExcept)
        {
            throw new DaoException("Problemas na leitura da chave" + pChave, tExcept);
        }
    }

    public boolean gravarObjeto(String pChave, String pLinha) throws DaoException
    {
        try
        {
            File tArq1 = new File(DIRETORIO + this.getClass().getSimpleName() +
                            "/" + pChave + ".txt");

            if (tArq1.exists())
                return false;

            FileWriter tArq2 = new FileWriter(tArq1);
            PrintWriter tArq3 = new PrintWriter(tArq2);

            tArq3.println(pLinha);

            tArq3.close();

            return true;
        }
        catch (IOException tExcept)
        {
            throw new DaoException("Problemas na gravação da chave" + pChave, tExcept);
        }
    }

    public boolean regravarObjeto(String pChave, String pLinha) throws DaoException
    {
        try
        {
            File tArq1 = new File(DIRETORIO + this.getClass().getSimpleName() +
                            "/" + pChave + ".txt");

            if (!tArq1.exists())
                return false;

            FileWriter tArq2 = new FileWriter(tArq1);
            PrintWriter tArq3 = new PrintWriter(tArq2);

            tArq3.println(pLinha);

            tArq3.close();

            return true;
        }
        catch (IOException tExcept)
        {
            throw new DaoException("Problemas na regravação da chave" + pChave, tExcept);
        }
    }

    public boolean excluirObjeto(String pChave) throws DaoException
    {
        File tArq1 = new File(DIRETORIO + this.getClass().getSimpleName() +
                        "/" + pChave + ".txt");

        if (!tArq1.exists())
            return false;

        if (!tArq1.delete())
            throw new DaoException("Problemas na exclusão da chave" + pChave);

        return true;
    }

    public String[] obterListaObjetos() throws DaoException
    {
        try
        {
            File tDiretorio = new File(DIRETORIO + this.getClass().getSimpleName());

            if (!tDiretorio.exists())
                return new String[0];

            File[] tArquivos = tDiretorio.listFiles(f -> f.getName().endsWith(".txt"));
            String[] tLinhas = new String[tArquivos.length];
            int i = 0;
            for (File tArquivo : tArquivos)
            {
                FileReader tArq1 = new FileReader(tArquivo);
                BufferedReader tArq2 = new BufferedReader(tArq1);

                tLinhas[i++] = tArq2.readLine();

                tArq2.close();
            }

            return tLinhas;
        }
        catch (IOException tExcept)
        {
            throw new DaoException("Problemas na recuperação da lista de objetos", tExcept);
        }
    }
}
