import java.util.List;
import java.util.ArrayList;

public class Treino {
	private int idCont = 1;
	private int idTreino;
	private List<Exercicio> exercicios;
	private String data;
	private double horarioInicio;
	private Aluno aluno;
	private FuncionarioProfessor professor;

	public Treino(int idTreino, String descricao){
		this.idTreino = idCont++;
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

	public double gethorarioInicio() {
		return horarioInicio;
	}

	public Aluno getAluno() {
		return aluno;
	}
	public FuncionarioProfessor getProfessor() {
		return professor;
	}
	

	@Override
	public String toString() {
		String treino = "ID: " + this.idTreino + "\nExercicios: ";
		for (Exercicio e : this.exercicios) {
			treino += e.toString() + "\n";
		}
		return treino;
	}
}
