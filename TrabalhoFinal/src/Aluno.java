public class Aluno extends Pessoa implements Comparable<Aluno> {

	private int nroMatricula;
	private String dataInicio;
	private boolean emTreinamento;

	public Aluno(String nome, String cpf, String dataNasc, int nroMatricula, String dataInicio) {
		super(nome, cpf, dataNasc);
		this.nroMatricula = nroMatricula;
		this.dataInicio = dataInicio;
	}

	public int getNroMatricula() {
		return this.nroMatricula;
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
		return "Aluno " + this.getNome() + "[Matricula: " + this.nroMatricula +  ". Aluno desde: " + this.dataInicio
				+ ", com plano de duracao: " +   "]";
	}

	@Override
	public int compareTo(Aluno a) {
		return this.getNroMatricula() - a.getNroMatricula();
	}
}
