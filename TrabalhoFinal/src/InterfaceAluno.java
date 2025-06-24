import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class InterfaceAluno extends JFrame {

    private Academia academia;
    private JFrame interfacePrincipal;

    public InterfaceAluno(Academia academia, JFrame interfacePrincipal) {
        this.academia = academia;
        this.interfacePrincipal = interfacePrincipal;
    }

    public static void exibirJanelaAluno(Academia academia, JFrame interfacePrincipal) {
        
        JFrame janelaAluno = new JFrame ("Modo aluno");
        janelaAluno.setSize(800, 700);
        janelaAluno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelaAluno.setLocationRelativeTo(null);
        janelaAluno.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 40));  

        JLabel tituloInterno = new JLabel("Olá aluno! Digite a sua matrícula no campo abaixo: "); 
        tituloInterno.setFont(new Font("Times New Roman", Font.BOLD, 22)); 
        tituloInterno.setForeground(new Color(0, 102, 204));
        janelaAluno.add(tituloInterno);

        JTextField campoMatricula = new JTextField(20);

        JButton botaoBuscar = new JButton("Buscar"); 
        janelaAluno.add(botaoBuscar);

        JButton botaoTreinar = new JButton ("Treinar.");
        botaoTreinar.setVisible(false);
        janelaAluno.add(botaoTreinar);

        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.addActionListener(e -> {
            janelaAluno.setVisible(false);
            interfacePrincipal.setVisible(true);
        });

        final Aluno[] alunoAtual = new Aluno[1]; //Precisei adicionar esse trecho para que o botaoTreinar fosse visivel apenas quando o aluno fosse encontrado
        
        botaoBuscar.addActionListener(e -> {
            try {
                int matricula = Integer.parseInt(campoMatricula.getText().trim());
                Aluno aluno = academia.buscarAluno(matricula);
                if (aluno == null) {
                    JOptionPane.showMessageDialog(null, "Aluno nao encontrado. Tente novamente.");
                    botaoTreinar.setVisible(false);
                } 
                else if (aluno.getEmTreinamento() == false) {
                    JOptionPane.showMessageDialog(null, "Aluno não teve sua entrada liberada. Tente novamente.");
                    botaoTreinar.setVisible(false);
                } 
                else {
                    JOptionPane.showMessageDialog(null, "Aluno encontrado: " + aluno.getNome());
                    alunoAtual[0] = aluno;
                    botaoTreinar.setVisible(true);
                }
            }
            catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Digite uma matricula valida. Somente números");
                botaoTreinar.setVisible(false);
            }
        });     
 
        botaoTreinar.addActionListener (ev -> {
            if (alunoAtual[0] != null) {
                exibirJanelaTreino(academia, alunoAtual[0], interfacePrincipal);
            }
        });

        janelaAluno.add(campoMatricula);
        janelaAluno.add(botaoBuscar);
        janelaAluno.add(botaoVoltar);

        janelaAluno.setVisible(true);
    }

    public static void exibirJanelaTreino(Academia academia, Aluno aluno, JFrame interfacePrincipal) {

        JFrame janelaTreino = new JFrame ("Aba de treinos.");
        janelaTreino.setSize(800, 700);
        janelaTreino.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelaTreino.setLocationRelativeTo(null);
        janelaTreino.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 40));

        JLabel tituloInterno = new JLabel("Bem-vindo a nossa área de treinamento, " + aluno.getNome() + "!");
        tituloInterno.setFont(new Font("Times New Roman", Font.BOLD, 22)); 
        tituloInterno.setForeground(new Color(0, 102, 204));
        janelaTreino.add(tituloInterno);

        JLabel mensagem = new JLabel("Selecione o treino que deseja realizar: ");
        mensagem.setFont(new Font("Times New Roman", Font.BOLD, 16)); 
        mensagem.setForeground(new Color(0, 102, 204));
        janelaTreino.add(mensagem);

        ButtonGroup grupoTreinos = new ButtonGroup();
        List<Treino> treinos = aluno.getTreinos();

        for(Treino treino : treinos) {
            JRadioButton botaoTreino = new JRadioButton(treino.getDescricao());
            grupoTreinos.add(botaoTreino);
            janelaTreino.add(botaoTreino);
        }
        //Trecho acima cria um grupo de botões e, adiciona a desrição de cada treino neles, ao marcar um, desmarca os outros.

        JButton botaoComecarTreino = new JButton("Treinar");
        botaoComecarTreino.setVisible(true);

        botaoComecarTreino.addActionListener(e -> {
            
        });


        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.addActionListener(e -> {
            janelaTreino.setVisible(false);
            interfacePrincipal.setVisible(true);
        });

        janelaTreino.add(botaoVoltar);
        janelaTreino.add(botaoComecarTreino);
        janelaTreino.setVisible(true);

    }

    public static void exibirJanelaExercicios(Academia academia, Treino treino, JFrame interfacePrincipal) {
        //Neste método, preciso que o aluno selecione o treino que deseja fazer em uma lista, em seguida, vai solicitar para ele
        //o peso que será utilizado em qualquer um, logo após, abrir um painel de estatística.

        JFrame janelaExercicios = new JFrame ("Exercicios do treino de " + treino.getDescricao() + ".");
        janelaExercicios.setSize(800, 700);
        janelaExercicios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelaExercicios.setLocationRelativeTo(null);
        janelaExercicios.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 40)); 

        JLabel tituloInterno = new JLabel("Selecione a carga para cada exercicio: ");
        tituloInterno.setFont(new Font("Times New Roman", Font.BOLD, 22)); 
        tituloInterno.setForeground(new Color(0, 102, 204));
        janelaExercicios.add(tituloInterno);
    }
}
