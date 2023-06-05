
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Telefonia telefonia = new Telefonia();

		boolean sair = false;
		
		System.out.println("========================");
		System.out.println("Bem Vindo ao Sistema de Telefonia");
		System.out.println("========================");
		
		while (!sair) {
			System.out.println("\n=== Menu ===\n");
			System.out.println("1. Cadastrar assinante");
			System.out.println("2. Listar assinantes");
			System.out.println("3. Fazer chamada");
			System.out.println("4. Fazer recarga");
			System.out.println("5. Imprimir faturas");
			System.out.println("6. Sair do programa");
			System.out.println("Digite a opção desejada: ");
			int opcao = sc.nextInt();
			sc.nextLine();
			switch (opcao) {
			case 1:
				telefonia.cadastrarAssinante();
				break;
			case 2:
				telefonia.listarAssinantes();
				break;
			case 3:
				telefonia.fazerChamada();
				break;
			case 4:
				telefonia.fazerRecarga();
				break;
			case 5:
				telefonia.imprimirFaturas();
				break;
			case 6:
				sair = true;
				break;
			default:
				System.out.println("Opção inválida. Digite novamente.");
				break;
			}
		}

		System.out.println("Programa encerrado.");
		sc.close();
	}
	
}
