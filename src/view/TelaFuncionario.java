package view;

import java.time.LocalDate;
import java.util.Vector;

import adt.DataADT;
import adt.MatriculaADT;
import adt.NomeADT;
import adt.SetorADT;
import adt.TelefoneADT;
import controller.FuncionarioService;
import dto.FuncionarioDTO;
import model.Funcionario;
import util.Leitor;

public class TelaFuncionario {
	private static int sMatricula = 0;
	private static String sNome = "";
	private static String sSetor = "";
	private static long sTelefone;
	private static LocalDate sDataNascimento;
	private static final FuncionarioService sServico = new FuncionarioService();

	public static void processar() {
		while (true) {
			System.out.println();
			System.out.println("Manutenção de Funcionários");
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
			switch (tOpcao) {
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

	private static void processarInclusao() {
		System.out.println();
		System.out.println("Manutenção de Funcionários");
		System.out.println("Inclusão de Funcionário");
		System.out.println();

		sMatricula = lerMatricula();
		if (sMatricula == 0)
			return;

		sNome = lerNome();
		if (sNome == null || sNome.isEmpty())
			return;

		sSetor = lerSetor();
		if (sSetor == null || sSetor.isEmpty())
			return;

		sTelefone = lerTelefone();
		if (sTelefone == 0)
			return;

		sDataNascimento = lerDataNascimento();
		if (sDataNascimento == null)
			return;

		System.out.println();
		char tConf = Leitor.readChar("Confirma (s/n)... : ");
		System.out.println();

		if (Character.toUpperCase(tConf) == 'S') {
			FuncionarioDTO tDto = sServico.processarInclusao(sMatricula, sNome, sSetor, sTelefone, sDataNascimento);
			if (tDto.isOk()) {
				System.out.println(tDto.getAviso());
				mostrarFuncionario(tDto.getFuncionario());
			} else
				System.out.println(tDto.getAviso());
		} else
			System.out.println("Operação não realizada...");
	}

	private static void processarAlteracao() {
		System.out.println();
		System.out.println("Manutenção de Funcionários");
		System.out.println("Alteração de Funcionário");
		System.out.println();

		sMatricula = lerMatricula();
		if (sMatricula == 0)
			return;

		FuncionarioDTO tDto = sServico.processarConsulta(String.valueOf(sMatricula));
		if (!tDto.isOk()) {
			System.out.println(tDto.getAviso());
			return;
		}

		System.out.println("Funcionário a ser alterado");
		mostrarFuncionario(tDto.getFuncionario());

		System.out.println();

		sNome = lerNome();
		if (sNome == null || sNome.isEmpty())
			return;

		sSetor = lerSetor();
		if (sSetor == null || sSetor.isEmpty())
			return;

		sTelefone = lerTelefone();
		if (sTelefone == 0)
			return;

		sDataNascimento = lerDataNascimento();
		if (sDataNascimento == null)
			return;

		System.out.println();
		char tConf = Leitor.readChar("Confirma (s/n)... : ");
		System.out.println();

		if (Character.toUpperCase(tConf) == 'S') {
			tDto = sServico.processarAlteracao(sMatricula, sNome, sSetor, sTelefone, sDataNascimento);
			if (tDto.isOk()) {
				System.out.println(tDto.getAviso());
				mostrarFuncionario(tDto.getFuncionario());
			} else
				System.out.println(tDto.getAviso());
		} else
			System.out.println("Operação não realizada...");
	}

	private static void processarExclusao() {
		System.out.println();
		System.out.println("Manutenção de Funcionários");
		System.out.println("Exclusão de Funcionário");
		System.out.println();

		sMatricula = lerMatricula();
		if (sMatricula == 0)
			return;

		FuncionarioDTO tDto = sServico.processarConsulta(String.valueOf(sMatricula));
		if (!tDto.isOk()) {
			System.out.println(tDto.getAviso());
			return;
		}

		System.out.println("Funcionário a ser excluído");
		mostrarFuncionario(tDto.getFuncionario());

		System.out.println();
		char tConf = Leitor.readChar("Confirma (s/n)... : ");
		System.out.println();

		if (Character.toUpperCase(tConf) == 'S') {
			tDto = sServico.processarExclusao(String.valueOf(sMatricula));
			if (tDto.isOk()) {
				System.out.println(tDto.getAviso());
				mostrarFuncionario(tDto.getFuncionario());
			} else
				System.out.println(tDto.getAviso());
		} else
			System.out.println("Operação não realizada...");
	}

	private static void processarConsulta() {
		System.out.println();
		System.out.println("Manutenção de Funcionários");
		System.out.println("Consulta de Funcionário");
		System.out.println();

		sMatricula = lerMatricula();
		if (sMatricula == 0)
			return;

		FuncionarioDTO tDto = sServico.processarConsulta(String.valueOf(sMatricula));
		if (tDto.isOk()) {
			System.out.println(tDto.getAviso());
			mostrarFuncionario(tDto.getFuncionario());
		} else
			System.out.println(tDto.getAviso());
	}

	private static void processarRelacao() {
		System.out.println();
		System.out.println("Manutenção de Funcionários");
		System.out.println("Relação de Funcionário");
		System.out.println();

		FuncionarioDTO tDto = sServico.processarRelacao();
		if (tDto.isOk()) {
			System.out.println(tDto.getAviso());
			Vector<Funcionario> tLista = tDto.getRelacao();
			for (Funcionario tFuncionario : tLista) {
				System.out.printf("%-10s - %-10s - %-10s - %-10s - %10s%n", tFuncionario.getMatricula(),
						tFuncionario.getNome(), tFuncionario.getSetor(), tFuncionario.getTelefone(),
						tFuncionario.getDataNascimento().format(DataADT.FORMATO_DATA));
			}
		} else
			System.out.println(tDto.getAviso());
	}

	/**
	 * @return Retorna numero de matricula digitada pelo usuario
	 */
	private static int lerMatricula() {
		while (true) {
			int tMatricula = Leitor.readInt("Matrícula............ : ", sMatricula);
			if (tMatricula == 0)
				break;
			String tErro = MatriculaADT.consistir(tMatricula);
			if (tErro.isEmpty())
				return tMatricula;
			else {
				System.out.println("Erro................. : " + tErro);
				System.out.println();
			}
		}
		return 0;
	}

	/**
	 * @return Retorna nome digitado pelo usuario
	 */
	private static String lerNome() {
		while (true) {
			String tNome = Leitor.readString("Nome................. : ", sNome).trim();
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
	 * @return Retorna setor digitado pelo usuario
	 */
	private static String lerSetor() {
		while (true) {
			String tSetor = Leitor.readString("Setor................ : ", sSetor).trim();
			if (tSetor.isEmpty())
				break;
			String tErro = SetorADT.consistir(tSetor);
			if (tErro.isEmpty())
				return tSetor;
			else {
				System.out.println("Erro................. : " + tErro);
				System.out.println();
			}
		}
		return null;
	}

	/**
	 * @return Retorna telefone digitado pelo usuario
	 */
	private static Long lerTelefone() {
		while (true) {
			Long tTelefone = Leitor.readLong("Telefone............. : ", sTelefone);
			if (tTelefone == 0)
				break;
			String tErro = TelefoneADT.consistir(tTelefone);
			if (tErro.isEmpty())
				return tTelefone;
			else {
				System.out.println("Erro................. : " + tErro);
				System.out.println();
			}
		}
		return null;
	}

	/**
	 * @return Retorna data de nascimento digitada pelo usuario
	 */
	private static LocalDate lerDataNascimento() {
		while (true) {
			String tDataNascimento = Leitor.readString("Data de Nascimento... : ", String.valueOf(sDataNascimento));
			if (tDataNascimento.isEmpty())
				break;
			String tErro = DataADT.consistir(tDataNascimento);
			if (tErro.isEmpty())
				return LocalDate.parse(tDataNascimento, DataADT.FORMATO_DATA);
			else {
				System.out.println("Erro................. : " + tErro);
				System.out.println();
			}
		}
		return null;
	}

	private static void limparDados() {
		sMatricula = 0;
		sNome = "";
		sSetor = "";
		sTelefone = 0;
		sDataNascimento = null;
	}

	private static void mostrarFuncionario(Funcionario pFuncionario) {
		sMatricula = pFuncionario.getMatricula();
		sNome = pFuncionario.getNome();
		sSetor = pFuncionario.getSetor();
		sTelefone = pFuncionario.getTelefone();
		sDataNascimento = pFuncionario.getDataNascimento();
		System.out.println();
		System.out.println("Matricula.......... : " + sMatricula);
		System.out.println("Nome............... : " + sNome);
		System.out.println("Setor.............. : " + sSetor);
		System.out.println("Telefone........... : " + sTelefone);
		System.out.println("Data de Nascimento. : " + sDataNascimento);
	}
}
