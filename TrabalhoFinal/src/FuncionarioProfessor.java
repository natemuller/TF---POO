public class FuncionarioProfessor extends Funcionario {

	public FuncionarioProfessor(String nome, String cpf, String dataNasc, int idFuncionario, String dataContratacao, Cargo cargo) {
    	super(nome, cpf, dataNasc, idFuncionario, dataContratacao, cargo);
	}

	public void consultarTreino(Treino t) {
		System.out.println(t.toString());
	}

	public void atender(Funcionario f, Aluno a) {
		System.out.println("Funcionario: " + f.getNome() + " esta atendendo o aluno: " + a.getNome());
		f.setEmAtendimento(true);
	}
	
	@Override
	public String toString() {
		return "Funcionario Professor: " + this.getNome() + "[CPF: " + this.getCpf() + ", Data de Nascimento: " + this.getDataNasc() + ". ID: " + this.getIdFuncionario() + ", Contratacao: " + this.getDataContratacao() + ", Cargo: " + this.getCargo() + "]";
	}
}
