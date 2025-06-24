import java.util.*;

public class Academia {
    private Map<Integer, Treino> treinosMap;
    private Set<Funcionario> funcionarios = new TreeSet<>();
    private Set<Aluno> alunos = new TreeSet<>();

    public Academia() {
        treinosMap = new HashMap<>();
    }

    public void adicionarAluno(Aluno a) {
        alunos.add(a);
    }

    public Set<Aluno> getAlunos() {
        return alunos;
    }

    public Set<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void removerAluno(String nome) {
        boolean removido = alunos.removeIf(a -> a.getNome().equals(nome));
        if (removido) {
            System.out.println("Aluno removido com sucesso: " + nome);
        } else {
            System.out.println("Aluno não encontrado nos dados da academia.");
        }
    }

    public Aluno buscarAluno(int nroMatricula) {
        return alunos.stream()
            .filter(a -> a.getNroMatricula() == nroMatricula) 
            .findFirst()
            .orElse(null);
    }

    public void adicionarFuncionario(Funcionario f) {
        funcionarios.add(f);
    }

    public void removerFuncionario(String nome) {
        boolean removido = funcionarios.removeIf(f -> f.getNome().equalsIgnoreCase(nome));
        if (removido) {
            System.out.println("Funcionário removido com sucesso: " + nome);
        }
    }

    public Funcionario buscarFuncionario(int idFuncionario) {
        return funcionarios.stream()
            .filter(f -> f.getIdFuncionario() == idFuncionario)
            .findFirst()
            .orElse(null);
    }

    public Map<Integer, Treino> getTreinosMap() {
        return treinosMap;
    }

    public void adicionarTreino(Treino treino) {
        treinosMap.put(treino.getIdTreino(), treino);
    }

    public void removerTreinos(int idTreino) {
        treinosMap.remove(idTreino);
    }

    public Treino buscarTreino(int id) {
        return treinosMap.get(id);
    }

    // Novo método auxiliar, se quiser
    public List<Treino> getListaTreinosAcademia() {
        return new ArrayList<>(treinosMap.values());
    }
}
