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
        Treino t1 = new Treino("Peitoral");

            Exercicio supinoReto = new Exercicio("Supino reto", 3, 12, 0);
            Exercicio supinoInclinado = new Exercicio("Supino inclinado", 3, 12, 0);
            Exercicio crucifixo = new Exercicio("Crucifixo", 3, 12, 0); 
            Exercicio pullOver = new Exercicio("PullOver", 3, 12, 0);
            Exercicio crossOver = new Exercicio("CrossOver", 3, 12, 0);

            t1.adicionarExercicio(supinoReto);
            t1.adicionarExercicio(supinoInclinado);
            t1.adicionarExercicio(crucifixo);
            t1.adicionarExercicio(pullOver);
            t1.adicionarExercicio(crossOver);

        Treino t2 = new Treino("Costas");

            Exercicio remadaCurvada = new Exercicio("Remada curvada", 3, 12, 0);
            Exercicio puxadaAlta = new Exercicio("Puxada alta", 3, 12, 0);
            Exercicio remadaBaixa = new Exercicio("Remada baixa", 3, 12, 0);
            Exercicio puxadaTriangulo = new Exercicio("Puxada triangulo", 3, 12, 0);
            Exercicio levantamentoTerra = new Exercicio("Levantamento terra", 5, 5, 0);

            t2.adicionarExercicio(remadaCurvada);
            t2.adicionarExercicio(puxadaAlta);
            t2.adicionarExercicio(remadaBaixa);
            t2.adicionarExercicio(puxadaTriangulo);
            t2.adicionarExercicio(levantamentoTerra);

        Treino t3 = new Treino("Perna");

            Exercicio agachamento = new Exercicio("Agachamento", 5, 5, 0);
            Exercicio cadeiraExtensora = new Exercicio("Cadeira extensora", 3, 12, 0);
            Exercicio legPress = new Exercicio("Leg press", 3, 12, 0);
            Exercicio elevacaoPelvica = new Exercicio("Elevacao pelvica", 3, 12, 0);
            Exercicio mesaFlexora = new Exercicio("Mesa flexora", 3, 12, 0);

            t3.adicionarExercicio(agachamento);
            t3.adicionarExercicio(cadeiraExtensora);
            t3.adicionarExercicio(legPress);
            t3.adicionarExercicio(elevacaoPelvica);
            t3.adicionarExercicio(mesaFlexora);

        Treino t4 = new Treino("Ombro");

            Exercicio desenvolvimento = new Exercicio("Desenvolvimento", 3, 12, 0);
            Exercicio elevacaoLateral = new Exercicio("Elevacao lateral", 3, 12, 0);
            Exercicio pullFace = new Exercicio("Pull face", 3, 12, 0);
            Exercicio remadaAlta = new Exercicio("Remada alta", 3, 12, 0);

            t4.adicionarExercicio(desenvolvimento);
            t4.adicionarExercicio(elevacaoLateral);
            t4.adicionarExercicio(pullFace);
            t4.adicionarExercicio(remadaAlta);

        Treino t5 = new Treino("Braco");

            Exercicio tricepsCorda = new Exercicio("Triceps corda", 3, 12, 0);
            Exercicio tricepsFrances = new Exercicio("Triceps frances", 3, 12, 0);
            Exercicio tricepsTesta = new Exercicio("Triceps testa", 3, 12, 0);
            Exercicio roscaDireta = new Exercicio("Rosca direta", 3, 12, 0);
            Exercicio roscaMartelo = new Exercicio("Rosca martelo", 3, 12, 0);
            Exercicio roscaScott = new Exercicio("Rosca Scott", 3, 12, 0);

            t5.adicionarExercicio(tricepsCorda);
            t5.adicionarExercicio(tricepsFrances);
            t5.adicionarExercicio(tricepsTesta);
            t5.adicionarExercicio(roscaDireta);
            t5.adicionarExercicio(roscaMartelo);
            t5.adicionarExercicio(roscaScott);

        System.out.println("Tipos de treinos");
        System.out.println(t1);        
        System.out.println(t2);
        System.out.println(t3);
        System.out.println(t4);
        System.out.println(t5);
      
        //Java swing
         //  chama o método que cria a janela principal, passando a academia
        TelaTesteSwing.exibirJanelaPrincipal(academia);
    }
    }
