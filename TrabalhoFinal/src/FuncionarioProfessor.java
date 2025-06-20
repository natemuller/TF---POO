public class FuncionarioProfessor extends Funcionario {

	public FuncionarioProfessor(String nome, String cpf, String dataNasc, int idFuncionario, String dataContratacao, Cargo cargo, boolean emAtendimento) {
    	super(nome, cpf, dataNasc, idFuncionario, dataContratacao, cargo, emAtendimento);
	}

	public void consultarTreino(Treino t) {
		System.out.println(t.toString());
	}

	public void atender() {

	}
}
