public class Aluno extends Pessoa {

	private int nroMatricula;

	private Tipo tipo;

	private String dataInicio;

	private int duracao;

	public Aluno(String nome, String cpf, String dataNasc, int nroMatricula, Tipo tipo, String dataInicio, int duracao) {
		super(nome, cpf, dataNasc);
		this.nroMatricula = nroMatricula;
		this.tipo = tipo;
		this.dataInicio = dataInicio;
		this.duracao = duracao;
	}


	public int getNroMatricula() {
		return 0;
	}

	public Tipo getTipo() {
		return null;
	}

	public String getDataInicio() {
		return null;
	}

	public int getDuracao() {
		return 0;
	}

	public String toString() {
		return null;
	}

	public void Aluno() {

	}

}
