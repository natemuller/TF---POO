public class Treino {
	private int idTreino;
	private String descricao;
	private String data;
	private double duracao;
	private Aluno aluno;
	private FuncionarioProfessor professor;

	public Treino(int idTreino, String descricao, String data, double duracao, Aluno aluno, FuncionarioProfessor professor){
		this.idTreino = idTreino;
		this.descricao = descricao;
		this.data = data;
		this.duracao = duracao;
		this.aluno = aluno;
		this.professor = professor;
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

	public double getDuracao() {
		return duracao;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void atualizarDescricao(String novaDescricao){
		
	}

	public FuncionarioProfessor getProfessor() {
		return professor;
	}
	

	@Override
	public String toString(){
		return "[ Treino ID: " + idTreino + " | Descricao: " + descricao + " Data: " + data + " Duracao: " + duracao + " ]";
	}
}
