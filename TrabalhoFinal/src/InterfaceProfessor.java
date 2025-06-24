import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InterfaceProfessor extends JFrame {

    private Academia academia;
    private JFrame interfacePrincipal;

    public InterfaceProfessor(Academia academia, JFrame interfacePrincipal) {
        this.academia = academia;
        this.interfacePrincipal = interfacePrincipal;
    }
    
    public static void exibirJanelaProfessor(Academia academia, JFrame interfacePrincipal) {

        JFrame janelaProfessor = new JFrame("Modo professor.");
        janelaProfessor.setSize(800, 700);
        janelaProfessor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelaProfessor.setLocationRelativeTo(null);
        janelaProfessor.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 40)); 

        janelaProfessor.setVisible(true);

        JLabel tituloInterno = new JLabel("Olá professor! Digite seu ID no campo abaixo: "); 
        tituloInterno.setFont(new Font("Times New Roman", Font.BOLD, 22)); 
        tituloInterno.setForeground(new Color(0, 102, 204));
        janelaProfessor.add(tituloInterno);

        JTextField campoId = new JTextField(20);

        JButton botaoBuscar = new JButton("Buscar"); 
        janelaProfessor.add(botaoBuscar);

        JButton botaoAtender = new JButton ("Atender.");
        botaoAtender.setVisible(false);
        janelaProfessor.add(botaoAtender);

        botaoBuscar.addActionListener(e -> {
            try {
                int id = Integer.parseInt(campoId.getText());
                Funcionario professor = academia.buscarFuncionario(id);
                if (professor == null) {
                    JOptionPane.showMessageDialog(null, "Funcionario nao encontrado. Tente novamente.");
                }
                else if (professor.getCargo() != Cargo.PROFESSOR) {
                    JOptionPane.showMessageDialog(null, "O ID informado pertence a um funcionario caixa.");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Professor encontrado: " + professor.getNome());
                    botaoAtender.setVisible(true);
                    professor.setEmAtendimento(true);
                }
            }
            catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Digite um ID valida. Somente números");
            }
        });

        botaoAtender.addActionListener(e -> {
            exibeTelaAtendimento(academia, interfacePrincipal);
        });

        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.addActionListener(e -> {
            janelaProfessor.setVisible(false);
            interfacePrincipal.setVisible(true);
        });

        janelaProfessor.add(campoId);
        janelaProfessor.add(botaoVoltar);
        janelaProfessor.setVisible(true);
    }

    public static void exibeTelaAtendimento(Academia academia, JFrame interfacePrincipal) {

        JFrame telaAtendimento = new JFrame("Tela de atendimento.");
        telaAtendimento.setSize(800, 700);
        telaAtendimento.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        telaAtendimento.setLocationRelativeTo(null);
        telaAtendimento.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 40)); 
        
        JLabel tituloInterno = new JLabel("Digite a matricula do aluno no campo abaixo: "); 
        tituloInterno.setFont(new Font("Times New Roman", Font.BOLD, 22)); 
        tituloInterno.setForeground(new Color(0, 102, 204));
        telaAtendimento.add(tituloInterno);

        JTextField campoMatricula = new JTextField(20);

        JButton botaoBuscar = new JButton("Buscar"); 
        telaAtendimento.add(botaoBuscar);

        botaoBuscar.addActionListener(e -> {
            try {
                int matricula = Integer.parseInt(campoMatricula.getText().trim());
                Aluno aluno = academia.buscarAluno(matricula);
                if (aluno == null) {
                    JOptionPane.showMessageDialog(null, "Aluno nao encontrado. Tente novamente.");
                } 
                else if (aluno.getEmTreinamento() == false) {
                    JOptionPane.showMessageDialog(null, "Aluno nao esta na academia.");
                } 
                else {
                    JOptionPane.showMessageDialog(null, "Aluno encontrado: " + aluno.getNome() + ". Atendimento realizado com sucesso.");           
                }
            }
            catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Digite um ID valida. Somente números");
            }
        });

        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.addActionListener(e -> {
            telaAtendimento.setVisible(false);
            interfacePrincipal.setVisible(true);
        });

        telaAtendimento.add(campoMatricula);
        telaAtendimento.add(botaoVoltar);
        telaAtendimento.setVisible(true);
    }

}
