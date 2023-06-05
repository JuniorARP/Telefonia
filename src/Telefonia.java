
import java.util.Scanner;

public class Telefonia {
	private PrePago[] prePagos;
	private int numPrePagos;
	private PosPago[] posPagos;
	private int numPosPagos;
	private static final int MAX_PREPAGOS = 100;
	private static final int MAX_POSPAGOS = 100;

	Scanner sc = new Scanner(System.in);

	public Telefonia() {
		prePagos = new PrePago[MAX_PREPAGOS];
		numPrePagos = 0;
		posPagos = new PosPago[MAX_POSPAGOS];
		numPosPagos = 0;
		sc = new Scanner(System.in);
	}

	public void cadastrarAssinante() {
		System.out.println("Cadastrar Assinante");
		System.out.println("Digite o CPF do assinante: ");
		long cpf = sc.nextLong();
		sc.nextLine();
		System.out.println("Digite o nome do assinante: ");
		String nome = sc.nextLine();
		sc.nextLine();
		System.out.println("Digite o número do telefone do assinante: ");
		long numeroTelefone = sc.nextLong();
		sc.nextLine();
		System.out.println("Digite o tipo de assinante (1 - Pré-Pago, 2 - Pós-Pago): ");
		int tipoAssinante = sc.nextInt();
		sc.nextLine();

		if (tipoAssinante == 1) {
			System.out.println("Digite o crédito inicial do assinante pré-pago: ");
			float creditos = sc.nextFloat();
			PrePago prePago = new PrePago(cpf, nome, numeroTelefone, creditos);
			prePagos[numPrePagos] = prePago;
			numPrePagos++;
			System.out.println("Assinante pré-pago cadastrado com sucesso!");
		} else if (tipoAssinante == 2) {
			System.out.println("Digite o valor da assinatura do assinante pós-pago: ");
			float assinatura = sc.nextFloat();
			PosPago posPago = new PosPago(cpf, nome, numeroTelefone, assinatura);
			posPagos[numPosPagos] = posPago;
			numPosPagos++;
			System.out.println("Assinante pós-pago cadastrado com sucesso!");
		} else {
			System.out.println("Opção inválida. Não foi possível cadastrar o assinante.");
		}
	}

	public void listarAssinantes() {
		System.out.println("Lista de Assinantes Pré-Pagos:");
		for (int i = 0; i < numPrePagos; i++) {
			System.out.println(prePagos[i]);
		}

		System.out.println("Lista de Assinantes Pós-Pagos:");
		for (int i = 0; i < numPosPagos; i++) {
			System.out.println(posPagos[i]);
		}
	}

	public void fazerChamada() {
		System.out.println("Fazer Chamada");
		System.out.println("Digite o tipo de assinante (1 para Pré-pago, 2 para Pós-pago): ");
		int tipoAssinante = sc.nextInt();
		System.out.println("Digite o CPF do assinante: ");
		long cpf = sc.nextLong();

		if (tipoAssinante == 1) {
			PrePago prePago = localizarPrePago(cpf);
			if (prePago != null) {
				System.out.println("Digite a duração da chamada em minutos: ");
				int duracao = sc.nextInt();
				prePago.fazerChamada(null, duracao);
				System.out.println("Chamada realizada com sucesso para o assinante pré-pago!");
			} else {
				System.out.println("Assinante pré-pago não encontrado.");
			}
		} else if (tipoAssinante == 2) {
			PosPago posPago = localizarPosPago(cpf);
			if (posPago != null) {
				System.out.println("Digite a duração da chamada em minutos: ");
				int duracao = sc.nextInt();
				posPago.fazerChamada(null, duracao);
				System.out.println("Chamada realizada com sucesso para o assinante pós-pago!");
			} else {
				System.out.println("Assinante pós-pago não encontrado.");
			}
		} else {
			System.out.println("Opção inválida. Não foi possível fazer a chamada.");
		}
	}

	public void fazerRecarga() {
		System.out.println("Fazer Recarga");
		System.out.println("Digite o CPF do assinante pré-pago: ");
		long cpf = sc.nextLong();
		PrePago prePago = localizarPrePago(cpf);

		if (prePago != null) {
			System.out.println("Digite o valor da recarga: ");
			float valor = sc.nextFloat();
			prePago.recarregar(null, valor);
			System.out.println("Recarga realizada com sucesso para o assinante pré-pago!");
		} else {
			System.out.println("Assinante pré-pago não encontrado.");
		}
	}

	public PrePago localizarPrePago(long cpf) {
		for (int i = 0; i < numPrePagos; i++) {
			if (prePagos[i].getCpf() == cpf) {
				return prePagos[i];
			}
		}
		return null;
	}

	public PosPago localizarPosPago(long cpf) {
		for (int i = 0; i < numPosPagos; i++) {
			if (posPagos[i].getCpf() == cpf) {
				return posPagos[i];
			}
		}
		return null;
	}

	public void imprimirFaturas() {
		System.out.println("Imprimir Faturas");
		System.out.println("Digite o mês para imprimir as faturas: ");
		int mes = sc.nextInt();

		System.out.println("Faturas dos Assinantes Pré-Pagos:");
		for (int i = 0; i < numPrePagos; i++) {
			prePagos[i].imprimirFatura(mes);
		}

		System.out.println("Faturas dos Assinantes Pós-Pagos:");
		for (int i = 0; i < numPosPagos; i++) {
			posPagos[i].imprimirFatura(mes);
		}

	}
}
