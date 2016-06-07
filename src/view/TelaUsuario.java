package view;

import java.util.Vector;

import adt.ContaUsuarioADT;
import adt.SenhaUsuarioADT;
import controller.UsuarioService;
import dto.UsuarioDTO;
import model.Usuario;
import util.Leitor;

public class TelaUsuario
{
    private static String               sConta     = "";
    private static String               sSenha     = "";
    private static final UsuarioService sServico   = new UsuarioService();

    public static void processar()
    {
        while (true)
        {
            System.out.println();
            System.out.println("Manutenção de Usuários");
            System.out.println(" 1 - Incluir");
            System.out.println(" 2 - Alterar");
            System.out.println(" 3 - Excluir");
            System.out.println(" 4 - Consultar");
            System.out.println(" 5 - Listar");
            System.out.println(" 9 - Fim");
            System.out.println();

            int tOpcao = Leitor.readInt("Entre com a opção desejada : ");
            if (tOpcao == 9)
                break;

            limparDados();
            switch (tOpcao)
            {
                case 1:
                    processarInclusao();
                    break;
                case 2:
                    processarAlteracao();
                    break;
                case 3:
                    processarExclusao();
                    break;
                case 4:
                    processarConsulta();
                    break;
                case 5:
                    processarRelacao();
                    break;
                default:
                    System.out.println("Opção inválida. Reentre...");
                    break;
            }
        }
    }

    private static void processarInclusao()
    {
        System.out.println();
        System.out.println("Manutenção de Usuários");
        System.out.println("Inclusão de Usuário");
        System.out.println();

        sConta = lerConta();
        if (sConta == null || sConta.isEmpty())
            return;

        sSenha = lerSenha();
        if (sSenha == null || sSenha.isEmpty())
            return;

        System.out.println();
        char tConf = Leitor.readChar("Confirma (s/n)... : ");
        System.out.println();

        if (Character.toUpperCase(tConf) == 'S')
        {
            UsuarioDTO tDto = sServico.processarInclusao(sConta, sSenha);
            if (tDto.isOk())
            {
                System.out.println(tDto.getAviso());
                mostrarUsuario(tDto.getUsuario());
            }
            else
                System.out.println(tDto.getAviso());
        }
        else
            System.out.println("Operação não realizada...");
    }

    private static void processarAlteracao()
    {
        System.out.println();
        System.out.println("Manutenção de Usuários");
        System.out.println("Alteração de Usuário");
        System.out.println();

        sConta = lerConta();
        if (sConta == null || sConta.isEmpty())
            return;

        UsuarioDTO tDto = sServico.processarConsulta(sConta);
        if (!tDto.isOk())
        {
            System.out.println(tDto.getAviso());
            return;
        }

        System.out.println("Usuário a ser alterado");
        mostrarUsuario(tDto.getUsuario());

        System.out.println();
        sSenha = lerSenha();
        if (sSenha == null || sSenha.isEmpty())
            return;

        System.out.println();
        char tConf = Leitor.readChar("Confirma (s/n)... : ");
        System.out.println();

        if (Character.toUpperCase(tConf) == 'S')
        {
            tDto = sServico.processarAlteracao(sConta, sSenha);
            if (tDto.isOk())
            {
                System.out.println(tDto.getAviso());
                mostrarUsuario(tDto.getUsuario());
            }
            else
                System.out.println(tDto.getAviso());
        }
        else
            System.out.println("Operação não realizada...");
    }

    private static void processarExclusao()
    {
        System.out.println();
        System.out.println("Manutenção de Usuários");
        System.out.println("Exclusão de Usuário");
        System.out.println();

        sConta = lerConta();
        if (sConta == null || sConta.isEmpty())
            return;

        UsuarioDTO tDto = sServico.processarConsulta(sConta);
        if (!tDto.isOk())
        {
            System.out.println(tDto.getAviso());
            return;
        }

        System.out.println("Usuário a ser excluído");
        mostrarUsuario(tDto.getUsuario());

        System.out.println();
        char tConf = Leitor.readChar("Confirma (s/n)... : ");
        System.out.println();

        if (Character.toUpperCase(tConf) == 'S')
        {
            tDto = sServico.processarExclusao(sConta);
            if (tDto.isOk())
            {
                System.out.println(tDto.getAviso());
                mostrarUsuario(tDto.getUsuario());
            }
            else
                System.out.println(tDto.getAviso());
        }
        else
            System.out.println("Operação não realizada...");
    }

    private static void processarConsulta()
    {
        System.out.println();
        System.out.println("Manutenção de Usuários");
        System.out.println("Consulta de Usuário");
        System.out.println();

        sConta = lerConta();
        if (sConta == null || sConta.isEmpty())
            return;

        UsuarioDTO tDto = sServico.processarConsulta(sConta);
        if (tDto.isOk())
        {
            System.out.println(tDto.getAviso());
            mostrarUsuario(tDto.getUsuario());
        }
        else
            System.out.println(tDto.getAviso());
    }

    private static void processarRelacao()
    {
        System.out.println();
        System.out.println("Manutenção de Usuários");
        System.out.println("Relação de Usuários");
        System.out.println();

        UsuarioDTO tDto = sServico.processarRelacao();
        if (tDto.isOk())
        {
            System.out.println(tDto.getAviso());
            Vector<Usuario> tLista = tDto.getRelacao();
            for (Usuario tUsuario : tLista)
            {
                System.out.printf("%-10s - %-10s%n", tUsuario.getConta(), tUsuario.getSenha());
            }
        }
        else
            System.out.println(tDto.getAviso());
    }

    private static String lerConta()
    {
        while (true)
        {
            String tConta = Leitor.readString("Conta......... : ", sConta).trim();
            if (tConta.isEmpty())
                break;
            String tErro = ContaUsuarioADT.consistir(tConta);
            if (tErro.isEmpty())
                return tConta;
            else
            {
                System.out.println("Erro.......... : " + tErro);
                System.out.println();
            }
        }
        return null;
    }

    private static String lerSenha()
    {
        while (true)
        {
            String tSenha = Leitor.readString("Senha......... : ", sSenha).trim();
            if (tSenha.isEmpty())
                break;
            String tErro = SenhaUsuarioADT.consistir(tSenha);
            if (tErro.isEmpty())
                return tSenha;
            else
            {
                System.out.println("Erro.......... : " + tErro);
                System.out.println();
            }
        }
        return null;
    }

    private static void limparDados()
    {
        sConta = "";
        sSenha = "";
    }

    private static void mostrarUsuario(Usuario pUsuario)
    {
        sConta =  pUsuario.getConta();
        sSenha = pUsuario.getSenha();
        System.out.println();
        System.out.println("Conta......... : " + sConta);
        System.out.println("Senha......... : " + sSenha);
    }
}
