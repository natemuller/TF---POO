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
		return this.nroMatricula;
	}

	public Tipo getTipo() {
		return this.tipo;
	}

	public String getDataInicio() {
		return this.dataInicio;
	}

	public int getDuracao() {
		return this.duracao;
	}

	public String toString() {
		return "Aluno " + this.getNome() + "[Matricula: " + this.nroMatricula + ", tipo: " + this.tipo + ". Aluno desde: " + this.dataInicio
				+ ", com plano de duracao: " + this.duracao + "]";
	}
}
