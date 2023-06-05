
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Chamada {
	private GregorianCalendar data;
	private int duracao;

	public Chamada(GregorianCalendar data, int duracao) {
		this.data = data;
		this.duracao = duracao;
	}

	public GregorianCalendar getData() {
		return data;
	}

	public int getDuracao() {
		return duracao;
	}

	@Override
	public String toString() {
		SimpleDateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = formatadorData.format(data.getTime());

		return "Data: " + dataFormatada + "\nDuração: " + duracao + " minutos";
	}
}
