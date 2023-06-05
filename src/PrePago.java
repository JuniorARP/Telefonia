
import java.util.GregorianCalendar;

public class PrePago extends Assinante {
	private Recarga[] recargas;
	private int numRecargas;
	private float creditos;

	public PrePago(long cpf, String nome, long numeroTelefone, float creditos) {
		super(cpf, nome, numeroTelefone);
		this.creditos = creditos;
	}

	public Recarga[] getRecargas() {
		return recargas;
	}

	public void setRecargas(Recarga[] recargas) {
		this.recargas = recargas;
	}

	public int getNumRecargas() {
		return numRecargas;
	}

	public void setNumRecargas(int numRecargas) {
		this.numRecargas = numRecargas;
	}

	public float getCreditos() {
		return creditos;
	}

	public void setCreditos(float creditos) {
		this.creditos = creditos;
	}
	
	public void fazerChamada(GregorianCalendar data, int duracao) {
		float custoChamada = 1.45f * duracao;
		if (numRecargas > 0 && creditos >= custoChamada) {
			creditos -= custoChamada;
			System.out.println("Chamada realizada com sucesso.");
		} else {
			System.out.println("Não foi possível realizar a chamada. Créditos insuficientes.");
		}
	}

	public void recarregar(GregorianCalendar data, float valor) {
		if (numRecargas < 100) {
			Recarga recarga = new Recarga(data, valor);
			recargas[numRecargas] = recarga;
			numRecargas++;
			creditos += valor;
			System.out.println("Recarga realizada com sucesso.");
		} else {
			System.out.println("Não é possível realizar mais recargas. Limite máximo atingido.");
		}
	}

	public void imprimirFatura(int mes) {
		System.out.println("Fatura do assinante pré-pago:");
		System.out.println("CPF: " + getCpf());
		System.out.println("Nome: " + getNome());
		System.out.println("Número de telefone: " + getNumeroTelefone());
		
	}
}
