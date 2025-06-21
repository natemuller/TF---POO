public class Aluno extends Pessoa {

	private int nroMatricula;
	private Tipo tipo;
	private String dataInicio;
	private boolean emTreinamento;

	public Aluno(String nome, String cpf, String dataNasc, int nroMatricula, Tipo tipo, String dataInicio) {
		super(nome, cpf, dataNasc);
		this.nroMatricula = nroMatricula;
		this.tipo = tipo;
		this.dataInicio = dataInicio;
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

	public boolean getEmTreinamento() {
		return this.emTreinamento;
	}

	public void setEmTreinamento(boolean emTreinamento) {
		this.emTreinamento = emTreinamento;
	}

	public String toString() {
		return "Aluno " + this.getNome() + "[Matricula: " + this.nroMatricula + ", tipo: " + this.tipo + ". Aluno desde: " + this.dataInicio
				+ ", com plano de duracao: " +   "]";
	}
}
