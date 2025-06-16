public class Funcionario extends Pessoa {

	private int idFuncionario;

	private String dataContratacao;

	private Cargo cargo;

	private boolean emAtendimento;

	public Funcionario(String nome, String cpf, String dataNasc, int idFuncionario, String dataContratacao, Cargo cargo, boolean emAtendimento) {
		super(nome, cpf, dataNasc);
		this.idFuncionario = idFuncionario;
		this.dataContratacao = dataContratacao;
		this.cargo = cargo;
		this.emAtendimento = emAtendimento;
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
}
