public class Teste {
    public static void main(String[] args) {
        
        Academia academia = new Academia();


        Funcionario funcionario = new FuncionarioCaixa("Joaquim", "123.456.789-00", "01/01/2000", 1, "01/01/2021", Cargo.CAIXA, true);
        Funcionario funcionario2 = new FuncionarioProfessor("Adamastor", "123.456.789-00", "01/01/2000", 2, "01/01/2021", Cargo.PROFESSOR, true);
        academia.adicionarFuncionario(funcionario);
        academia.adicionarFuncionario(funcionario2);
        System.out.println(academia.buscarFuncionario(1).toString() + "\n");
        System.out.println(academia.buscarFuncionario(2).toString() + "\n");
        

        //TestandoPessoa

        //TestandoAluno
        Aluno aluno1 = new Aluno("Natan", "879.953.959-04", "20/08/2004", 2002502, "25/02/2020");
        academia.adicionarAluno(aluno1);

        //Testando treino...
        Treino t1 = new Treino(1, "Peito");
        Treino t2 = new Treino(2, "Bíceps");
        Treino t3 = new Treino(3, "Costas");
        Treino t4 = new Treino(4, "Perna");
        Treino t5 = new Treino(5, "Ombro");
        Treino t6 = new Treino(1, "Gluteos");

        System.out.println("Tipos de treinos");
        System.out.println(t1);        
        System.out.println(t2);
        System.out.println(t3);
        System.out.println(t4);
        System.out.println(t5);
        System.out.println(t6);
        
      
        //Java swing
         //  chama o método que cria a janela principal, passando a academia
        TelaTesteSwing.exibirJanelaPrincipal(academia);
    }
    }
