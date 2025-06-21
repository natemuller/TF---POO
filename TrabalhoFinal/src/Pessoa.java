public abstract class Pessoa {

	private String nome;
	private String cpf;
	private String dataNasc;

	public Pessoa(String nome, String cpf, String dataNasc) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNasc = dataNasc;
	}

	public String getNome() {
		return this.nome;
	}

	public String getCpf() {
		return this.cpf;
	}

	public String getDataNasc() {
		return this.dataNasc;
	}

}
