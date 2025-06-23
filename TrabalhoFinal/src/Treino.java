import java.util.List;
import java.util.ArrayList;

public class Treino {
	private static int idCont = 1;
	private int idTreino;
	private List<Exercicio> exercicios;
	private String descricao;
	private String data;
	private String horarioInicio;
	private Aluno aluno;
	private FuncionarioProfessor professor;

	public Treino(String descricao) {
		this.idTreino = idCont++;
		this.descricao = descricao;
		this.exercicios = new ArrayList<>();
	}

	public int getIdTreino() {
		return idTreino;
	}

	public List<Exercicio> getExercicios() {
		return exercicios;
	}

	public void adicionarExercicio(Exercicio exercicio) {
		exercicios.add(exercicio);
	}

	public String getData() {
		return data;
	}

	public String gethorarioInicio() {
		return horarioInicio;
	}

	public Aluno getAluno() {
		return aluno;
	}
	public FuncionarioProfessor getProfessor() {
		return professor;
	}

	public String getDescricao() {
		return descricao;
	}

	public double calculoMediaCarga() {
		return exercicios.stream()
				.mapToDouble(Exercicio::getCarga)
				.average()
				.orElse(0.0);
	}

	public double calculoCargaTotalDoTreino() {
		// Nesse caso, seria a carga total que o aluno ergueu no treino, contando cada repetição e série realizada.
		return exercicios.stream()
				.mapToDouble(Exercicio::getCarga)
				.sum();
	}

	@Override
	public String toString() {
		String treino = "ID: " + this.idTreino + "\nDescricao: " + this.descricao + "\nExercicios: ";
		for (Exercicio e : this.exercicios) {
			treino += e.toString() + "\n";
		}
		return treino;
	}
}
