import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Academia {

    private Map<Integer, Treino> treinosMap;
	private Set<Funcionario> funcionarios = new TreeSet<>();
	private Set<Aluno> alunos = new TreeSet<>();

	public Academia(){
		treinosMap = new HashMap<>();
	}

	public void adicionarAluno(Aluno a){
		alunos.add(a);
	}
	
	public void removerAluno(String nome){
		boolean removido = alunos.removeIf(a -> a.getNome().equals(nome));
		if(removido){
			System.out.println("Aluno Removido com Sucesso: " + nome);
		} else{
			System.out.println("Aluno não encontrado nos dados da academia;");
		}
	}

	public Aluno buscarAluno(String nomeString){
		return alunos.stream()
				.filter(a -> a.getNome().equalsIgnoreCase(nomeString))
				.findFirst()
				.orElse(null);
	}

	public void adicionarFuncionario(Funcionario f){
		funcionarios.add(f);
	}

	public void removerFuncionario(String nome){
		boolean funcionarioRemovido = funcionarios.removeIf(a -> a.getNome().equalsIgnoreCase(nome));
		if(funcionarioRemovido){
			System.out.println("Funcionario removido com Sucesso: " + nome);
		}
	}

	public Funcionario buscarFuncionario(int idFuncionario ){
		return funcionarios.stream()
				.filter(a -> a.getIdFuncionario() == idFuncionario)
				.findFirst()
				.orElse(null);
	}

	public void adicionarTreino(Treino treino) {
    	treinosMap.put(treino.getIdTreino(), treino);
	}

	public void removerTreinos(int idTreino){
		treinosMap.remove(idTreino);
	}

	public Treino buscarTreino(int id) {
    	return treinosMap.get(id); 
	}
	
	}

