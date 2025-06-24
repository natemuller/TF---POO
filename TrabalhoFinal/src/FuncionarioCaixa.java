public class FuncionarioCaixa extends Funcionario {

	public FuncionarioCaixa(String nome, String cpf, String dataNasc, int idFuncionario, String dataContratacao, Cargo cargo) {
    	super(nome, cpf, dataNasc, idFuncionario, dataContratacao, cargo);
	}

	public void liberarEntrada(Aluno a) {
		System.out.println("Aluno: " + a.getNome() + " liberado para entrada.");
		a.setEmTreinamento(true);
	}

	public void consultarCadastro(Aluno a) {
		System.out.println(a.toString());
	}

	@Override
	public String toString() {
		return "Funcionario Caixa: " + this.getNome() + "[CPF: " + this.getCpf() + ", Data de Nascimento: " + this.getDataNasc() + ". ID: " + this.getIdFuncionario() + ", Contratacao: " + this.getDataContratacao() + ", Cargo: " + this.getCargo() + "]";
	}
}
