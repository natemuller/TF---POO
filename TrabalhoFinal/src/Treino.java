public class Treino {
	private int idCont = 1;
	private int idTreino;
	private String descricao;
	private String data;
	private double horarioInicio;
	private Aluno aluno;
	private FuncionarioProfessor professor;

	public Treino(int idTreino, String descricao){
		this.idTreino = idCont++;
		this.descricao = descricao;
	}

	public int getIdTreino() {
		return idTreino;
	}

	public String getDescricao() {
		return descricao;
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

	public void atualizarDescricao(String novaDescricao){
		this.descricao = novaDescricao;
	}

	public FuncionarioProfessor getProfessor() {
		return professor;
	}
	

	@Override
	public String toString(){
		return "[ Treino ID: " + idTreino + " | Descricao: " + descricao + " ]";
	}
}
