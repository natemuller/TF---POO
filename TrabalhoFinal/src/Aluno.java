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

	public Exercicio getExercicioMaisPesado() {
		List<Exercicio> todosExerciciosFeitos = new ArrayList<>();
		for(Treino treino : treinos) {
			todosExerciciosFeitos.addAll(treino.getExercicios());
		}
		return todosExerciciosFeitos.stream()
				.max((e1, e2) -> {
					if (e1.getCarga() > e2.getCarga()) {
						return 1;
					} else if (e1.getCarga() < e2.getCarga()) {
						return -1;
					} else {
						return 0;
					}
				})
				.orElse(null);
	}

	@Override
	public int compareTo(Aluno a) {
    	return this.getNome().compareTo(a.getNome());
	}
	public String toString() {
		return "Aluno " + this.getNome() + "[CPF: " + this.getCpf() + ", Data de Nascimento: " + this.getDataNasc() + " . Matricula: " + this.nroMatricula +  ". Aluno desde: " + this.dataInicio +   "]";
	}
}
