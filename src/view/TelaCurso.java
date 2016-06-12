package view;

import java.util.Vector;

import adt.CargaHorariaADT;
import adt.CodigoADT;
import adt.DescricaoADT;
import adt.NomeADT;
import controller.CursoService;
import dto.CursoDTO;
import model.Curso;
import util.Leitor;

public class TelaCurso {
	private static String               sCodigo    		= "";
    private static String               sNome      		= "";
    private static String               sDescricao 		= "";
    private static int               	sCargaHoraria 	= 0;
    private static final CursoService 	sServico   = new CursoService();

    public static void processar()
    {
        while (true)
        {
            System.out.println();
            System.out.println("Manutenção de Cursos");
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
        System.out.println("Manutenção de Cursos");
        System.out.println("Inclusão de Curso");
        System.out.println();

        sCodigo = lerCodigo();
		if (sCodigo == null || sCodigo.isEmpty())
			return;

		sNome = lerNome();
		if (sNome == null || sNome.isEmpty())
			return;

		sDescricao = lerDescricao();
		if (sDescricao == null || sDescricao.isEmpty())
			return;

		sCargaHoraria = lerCargaHoraria();
		if (sCargaHoraria == 0)
			return;

        System.out.println();
        char tConf = Leitor.readChar("Confirma (s/n)... : ");
        System.out.println();

        if (Character.toUpperCase(tConf) == 'S')
        {
            CursoDTO tDto = sServico.processarInclusao(sCodigo, sNome, sDescricao, sCargaHoraria);
            if (tDto.isOk())
            {
                System.out.println(tDto.getAviso());
                mostrarCurso(tDto.getCurso());
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
        System.out.println("Manutenção de Cursos");
        System.out.println("Alteração de Curso");
        System.out.println();

        sCodigo = lerCodigo();
		if (sCodigo == null || sCodigo.isEmpty())
			return;

		CursoDTO tDto = sServico.processarConsulta(sCodigo);
        if (!tDto.isOk())
        {
            System.out.println(tDto.getAviso());
            return;
        }

        System.out.println("Usuário a ser alterado");
        mostrarCurso(tDto.getCurso());

        System.out.println();
        
        sNome = lerNome();
		if (sNome == null || sNome.isEmpty())
			return;

		sDescricao = lerDescricao();
		if (sDescricao == null || sDescricao.isEmpty())
			return;

		sCargaHoraria = lerCargaHoraria();
		if (sCargaHoraria == 0)
			return;

        System.out.println();
        char tConf = Leitor.readChar("Confirma (s/n)... : ");
        System.out.println();

        if (Character.toUpperCase(tConf) == 'S')
        {
            tDto = sServico.processarAlteracao(sCodigo, sNome, sDescricao, sCargaHoraria);
            if (tDto.isOk())
            {
                System.out.println(tDto.getAviso());
                mostrarCurso(tDto.getCurso());
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

        sCodigo = lerCodigo();
		if (sCodigo == null || sCodigo.isEmpty())
			return;

        CursoDTO tDto = sServico.processarConsulta(sCodigo);
        if (!tDto.isOk())
        {
            System.out.println(tDto.getAviso());
            return;
        }

        System.out.println("Curso a ser excluído");
        mostrarCurso(tDto.getCurso());

        System.out.println();
        char tConf = Leitor.readChar("Confirma (s/n)... : ");
        System.out.println();

        if (Character.toUpperCase(tConf) == 'S')
        {
            tDto = sServico.processarExclusao(sCodigo);
            if (tDto.isOk())
            {
                System.out.println(tDto.getAviso());
                mostrarCurso(tDto.getCurso());
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

        sCodigo = lerCodigo();
		if (sCodigo == null || sCodigo.isEmpty())
			return;

        CursoDTO tDto = sServico.processarConsulta(sCodigo);
        if (tDto.isOk())
        {
            System.out.println(tDto.getAviso());
            mostrarCurso(tDto.getCurso());
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

        CursoDTO tDto = sServico.processarRelacao();
        if (tDto.isOk())
        {
            System.out.println(tDto.getAviso());
            Vector<Curso> tLista = tDto.getRelacao();
            for (Curso tCurso : tLista)
            {
            	System.out.printf("%-10s - %-10s - %-10s - %10d%n", tCurso.getCodigo(), tCurso.getNome(), tCurso.getDescricao(), tCurso.getCargaHoraria());
            }
        }
        else
            System.out.println(tDto.getAviso());
    }

    /**
	 * @return Retorna código digitado pelo usuario
	 */
	private static String lerCodigo() {
		while (true) {
			String tCodigo = Leitor.readString("Código............... : ", sCodigo);
			if (tCodigo.isEmpty())
				break;
			String tErro = CodigoADT.consistirCurso(tCodigo);
			if (tErro.isEmpty())
				return tCodigo;
			else {
				System.out.println("Erro................. : " + tErro);
				System.out.println();
			}
		}
		return null;
	}
	
	/**
	 * @return Retorna nome digitado pelo usuario
	 */
	private static String lerNome() {
		while (true) {
			String tNome = Leitor.readString("Nome................. : ", sNome);
			if (tNome.isEmpty())
				break;
			String tErro = NomeADT.consistir(tNome);
			if (tErro.isEmpty())
				return tNome;
			else {
				System.out.println("Erro................. : " + tErro);
				System.out.println();
			}
		}
		return null;
	}
	
	/**
	 * @return Retorna descrição digitado pelo usuario
	 */
	private static String lerDescricao() {
		while (true) {
			String tDescricao = Leitor.readString("Descrição............ : ", sDescricao);
			if (tDescricao.isEmpty())
				break;
			String tErro = DescricaoADT.consistir(tDescricao);
			if (tErro.isEmpty())
				return tDescricao;
			else {
				System.out.println("Erro................. : " + tErro);
				System.out.println();
			}
		}
		return null;
	}
	
	/**
	 * @return Retorna carga horaria digitada pelo usuario
	 */
	private static int lerCargaHoraria() {
		while (true) {
			int tCargaHoraria = Leitor.readInt("Carga Horaria........ : ", sCargaHoraria);
			if (tCargaHoraria == 0)
				break;
			String tErro = CargaHorariaADT.consistir(tCargaHoraria);
			if (tErro.isEmpty())
				return tCargaHoraria;
			else {
				System.out.println("Erro................. : " + tErro);
				System.out.println();
			}
		}
		return 0;
	}

    private static void limparDados()
    {
    	sCodigo = "";
		sNome = "";
		sDescricao = "";
		sCargaHoraria = 0;
    }

    private static void mostrarCurso(Curso pCurso)
    {
        sCodigo =  pCurso.getCodigo();
        sNome = pCurso.getNome();
        sDescricao = pCurso.getDescricao();
        sCargaHoraria = pCurso.getCargaHoraria();
        System.out.println();
        System.out.println("Código......... : " + sCodigo);
        System.out.println("Nome........... : " + sNome);
        System.out.println("Descrição...... : " + sDescricao);
        System.out.println("Carga horaria.. : " + sCargaHoraria);
    }
}
