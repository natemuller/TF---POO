public class Teste {
    public static void main(String[] args) {
        System.out.println("Olá, mundo!");
        Academia academia = new Academia();
        Funcionario funcionario = new FuncionarioCaixa("Joaquim", "123.456.789-00", "01/01/2000", 1, "01/01/2021", Cargo.CAIXA, true);
        Funcionario funcionario2 = new FuncionarioProfessor("Adamastor", "123.456.789-00", "01/01/2000", 2, "01/01/2021", Cargo.PROFESSOR, true);
        academia.adicionarFuncionario(funcionario);
        academia.adicionarFuncionario(funcionario2);

        System.out.println(academia.buscarFuncionario(1).toString() + "\n");
        System.out.println(academia.buscarFuncionario(2).toString() + "\n");
        
        
    
    
    }
}
