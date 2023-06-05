
import java.util.GregorianCalendar;

public class PosPago extends Assinante {
	private Chamada[] chamadas;
	private int numChamadas;
	private float assinatura;

	public PosPago(long cpf, String nome, long numeroTelefone, float assinatura) {
		super(cpf, nome, numeroTelefone);
		chamadas = new Chamada[100];
		numChamadas = 0;
		this.assinatura = assinatura;
	}

	public Chamada[] getChamadas() {
		return chamadas;
	}

	public void setChamadas(Chamada[] chamadas) {
		this.chamadas = chamadas;
	}

	public int getNumChamadas() {
		return numChamadas;
	}

	public void setNumChamadas(int numChamadas) {
		this.numChamadas = numChamadas;
	}

	public float getAssinatura() {
		return assinatura;
	}

	public void setAssinatura(float assinatura) {
		this.assinatura = assinatura;
	}
	
	public void fazerChamada(GregorianCalendar data, int duracao) {
		float custoChamada = 1.04f * duracao;
		if (numChamadas < 100) {
			Chamada chamada = new Chamada(data, duracao);
			chamadas[numChamadas] = chamada;
			numChamadas++;
			System.out.println("Chamada realizada com sucesso. Custo da chamada: R$" + custoChamada);
		} else {
			System.out.println("Não é possível realizar mais chamadas. Limite máximo atingido.");
		}
	}

	public void imprimirFatura(int mes) {
		System.out.println("Fatura do assinante pós-pago:");
		System.out.println("CPF: " + getCpf());
		System.out.println("Nome: " + getNome());
		System.out.println("Número de telefone: " + getNumeroTelefone());
		
	}
}
