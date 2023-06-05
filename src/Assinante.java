
import java.util.GregorianCalendar;

public abstract class Assinante {
	private long cpf;
	private String nome;
	private long numeroTelefone;

	
	public Assinante(long cpf, String nome, long numeroTelefone2) {
		this.cpf = cpf;
		this.nome = nome;
		this.numeroTelefone = numeroTelefone2;
	}

	
	public long getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public long getNumeroTelefone() {
		return numeroTelefone;
	}

	public abstract void fazerChamada(GregorianCalendar data, int duracao);

	public abstract void imprimirFatura(int mes);
	
	
	@Override
	public String toString() {
		return "Assinante [cpf = " + cpf + ", nome = " + nome + ", numeroTelefone = " + numeroTelefone + "]";
	}
}
