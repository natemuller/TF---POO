public class Funcionario extends Pessoa implements Comparable<Funcionario> {

	private int idFuncionario;

	private String dataContratacao;

	private Cargo cargo;

	private boolean emAtendimento;

	public Funcionario(String nome, String cpf, String dataNasc, int idFuncionario, String dataContratacao, Cargo cargo) {
		super(nome, cpf, dataNasc);
		this.idFuncionario = idFuncionario;
		this.dataContratacao = dataContratacao;
		this.cargo = cargo;
	}

	public int getIdFuncionario() {
		return this.idFuncionario;
	}

	public String getDataContratacao() {
		return this.dataContratacao;
	}

	public Cargo getCargo() {
		return this.cargo;
	}

	public boolean getEmAtendimento() {
		return this.emAtendimento;
	}	

	public void setEmAtendimento(boolean emAtendimento) {
		this.emAtendimento = emAtendimento;
	}

	@Override
	public int compareTo(Funcionario o) {
		return this.getNome().compareTo(o.getNome());
	}
}
