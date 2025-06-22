import java.util.List;
import java.util.ArrayList;

public class Aluno extends Pessoa implements Comparable<Aluno> {

	private int nroMatricula;
	private String dataInicio;
	private boolean emTreinamento;
	private List<Treino> treinos = new ArrayList<>();

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

	public List<Treino> getTreinos() {
		return this.treinos;
	}

	public void adicionarTreino(Treino treino) {
		this.treinos.add(treino);
	}

	public String toString() {
		return "Aluno " + this.getNome() + "[Matricula: " + this.nroMatricula +  ". Aluno desde: " + this.dataInicio
				+ ", com plano de duracao: " +   "]";
	}

	public Exercicio getExercicioMaisPesado() {
		return null;
	}

	@Override
	public int compareTo(Aluno a) {
		return this.getNroMatricula() - a.getNroMatricula();
	}
}
