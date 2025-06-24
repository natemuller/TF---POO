import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InterfaceCaixa extends JFrame {
    
    private Academia academia;
    private JFrame interfacePrincipal;

    public InterfaceCaixa (Academia academia, JFrame interfacePrincipal) {
        this.academia = academia;
        this.interfacePrincipal = interfacePrincipal;
    }
    
    public static void exibirJanelaCaixa (Academia academia, JFrame interfacePrincipal) {

        JFrame janelaCaixa = new JFrame("Modo caixa.");
        janelaCaixa.setSize(800, 700);
        janelaCaixa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelaCaixa.setLocationRelativeTo(null);
        janelaCaixa.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 40)); 

        janelaCaixa.setVisible(true);

        JLabel tituloInterno = new JLabel("Olá caixa! Digite seu ID no campo abaixo: "); 
        tituloInterno.setFont(new Font("Times New Roman", Font.BOLD, 22)); 
        tituloInterno.setForeground(new Color(0, 102, 204));
        janelaCaixa.add(tituloInterno);

        JTextField campoId = new JTextField(20);

        JButton botaoBuscar = new JButton("Buscar"); 
        janelaCaixa.add(botaoBuscar);

        JButton botaoCheckIn = new JButton ("Check-in.");
        botaoCheckIn.setVisible(false);
        janelaCaixa.add(botaoCheckIn);

        botaoBuscar.addActionListener(e -> {
            try {
                int id = Integer.parseInt(campoId.getText());
                Funcionario caixa = academia.buscarFuncionario(id);
                if (caixa == null) {
                    JOptionPane.showMessageDialog(null, "Funcionario nao encontrado. Tente novamente.");
                }
                else if (caixa.getCargo() != Cargo.CAIXA) {
                    JOptionPane.showMessageDialog(null, "O ID informado pertence a um funcionario professor.");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Caixa encontrado: " + caixa.getNome());
                    botaoCheckIn.setVisible(true);
                    caixa.setEmAtendimento(true);
                }
            }
            catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Digite uma matricula valida. Somente números");
            }
        });

        botaoCheckIn.addActionListener(e -> {
            exibeTelaCheckIn(academia, interfacePrincipal);
        });

        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.addActionListener(e -> {
            janelaCaixa.setVisible(false);
            interfacePrincipal.setVisible(true);
        });

        janelaCaixa.add(campoId);
        janelaCaixa.add(botaoVoltar);
        janelaCaixa.setVisible(true);
    }

    public static void exibeTelaCheckIn(Academia academia, JFrame interfacePrincipal) {

        JFrame telaCheckIn = new JFrame("Tela de Check-in.");
        telaCheckIn.setSize(800, 700);
        telaCheckIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        telaCheckIn.setLocationRelativeTo(null);
        telaCheckIn.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 40)); 
        
        JLabel tituloInterno = new JLabel("Digite a matricula do aluno no campo abaixo: "); 
        tituloInterno.setFont(new Font("Times New Roman", Font.BOLD, 22)); 
        tituloInterno.setForeground(new Color(0, 102, 204));
        telaCheckIn.add(tituloInterno);

        JTextField campoMatricula = new JTextField(20);

        JButton botaoBuscar = new JButton("Buscar"); 
        telaCheckIn.add(botaoBuscar);

        botaoBuscar.addActionListener(e -> {
            try {
                int matricula = Integer.parseInt(campoMatricula.getText().trim());
                Aluno aluno = academia.buscarAluno(matricula);
                if (aluno == null) {
                    JOptionPane.showMessageDialog(null, "Aluno nao encontrado. Tente novamente.");
                } 
                else if (aluno.getEmTreinamento() == true) {
                    JOptionPane.showMessageDialog(null, "Aluno ja realizou Check-In.");
                } 
                else {
                    JOptionPane.showMessageDialog(null, "Aluno encontrado: " + aluno.getNome() + ". Check-in realizado com sucesso.");
                    aluno.setEmTreinamento(true);
                }
            }
            catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Digite um ID valida. Somente números");
            }
        });

        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.addActionListener(e -> {
            telaCheckIn.setVisible(false);
            interfacePrincipal.setVisible(true);
        });

        telaCheckIn.add(campoMatricula);
        telaCheckIn.add(botaoVoltar);
        telaCheckIn.setVisible(true);
    }
}
