import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Map;
import java.util.Set;
import java.util.List;

public class InterfaceAdministrador extends JFrame {

    private Academia academia;
    private JFrame interfacePrincipal;

    public InterfaceAdministrador(Academia academia, JFrame interfacePrincipal) {
        this.academia = academia;
        this.interfacePrincipal = interfacePrincipal;
    }
    
    public static void exibirJanelaAdministrador (Academia academia, JFrame interfacePrincipal) {

        JFrame janelaAdministrador = new JFrame("Modo administrador.");
        janelaAdministrador.setSize(800, 700);
        janelaAdministrador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelaAdministrador.setLocationRelativeTo(null);
        janelaAdministrador.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 40)); 

        JLabel tituloInterno = new JLabel("Para acessar o modo administrador, digite a senha: "); 
        tituloInterno.setFont(new Font("Times New Roman", Font.BOLD, 22)); 
        tituloInterno.setForeground(new Color(0, 102, 204));
        janelaAdministrador.add(tituloInterno);

        JTextField campoSenha = new JPasswordField(20);

        JButton botaoBuscar = new JButton("Buscar"); 
        janelaAdministrador.add(botaoBuscar);

        botaoBuscar.addActionListener(e -> {
            try {
                int senhaCorreta = 123456;
                if (campoSenha.getText().equals(Integer.toString(senhaCorreta))) { 
                    exibirJanelaConsultas(academia, interfacePrincipal);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Senha incorreta. Tente novamente.");
                }
            }
            catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Formato de senha incorreto.");
            }
        });

        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.addActionListener(e -> {
            janelaAdministrador.setVisible(false);
            interfacePrincipal.setVisible(true);
        });

        janelaAdministrador.add(campoSenha);
        janelaAdministrador.add(botaoVoltar);
        janelaAdministrador.setVisible(true);
    }

    public static void exibirJanelaConsultas(Academia academia, JFrame interfacePrincipal) {
        JFrame janelaAdministrador = new JFrame("Janela de consultas.");
        janelaAdministrador.setSize(800, 700);
        janelaAdministrador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelaAdministrador.setLocationRelativeTo(null);
        janelaAdministrador.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 40));

        JLabel tituloInterno = new JLabel("Selecione uma opcao de consulta: "); 
        tituloInterno.setFont(new Font("Times New Roman", Font.BOLD, 22)); 
        tituloInterno.setForeground(new Color(0, 102, 204));
        janelaAdministrador.add(tituloInterno);

        janelaAdministrador.setVisible(true);

        JButton botaoFuncionarios = new JButton("Funcionarios");
        botaoFuncionarios.addActionListener(e -> {
            janelaConsultaFuncionarios(academia, interfacePrincipal);
        });
        janelaAdministrador.add(botaoFuncionarios);

        JButton botaoAlunos = new JButton("Alunos");
        botaoAlunos.addActionListener(e -> {
            janelaConsultaAlunos(academia, interfacePrincipal);
        });
        janelaAdministrador.add(botaoAlunos);

        JButton botaoTreinos = new JButton("Treinos");
        botaoTreinos.addActionListener(e -> {
            janelaConsultaTreinos(academia, interfacePrincipal);
        });
        janelaAdministrador.add(botaoTreinos);

        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.addActionListener(e -> {
            janelaAdministrador.setVisible(false);
            interfacePrincipal.setVisible(true);
        });

        janelaAdministrador.add(botaoVoltar);
    }

    public static void janelaConsultaFuncionarios(Academia academia, JFrame interfacePrincipal) {

        JFrame consultaFuncionarios = new JFrame("Consulta de funcionarios.");
        consultaFuncionarios.setSize(800, 700);
        consultaFuncionarios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        consultaFuncionarios.setLocationRelativeTo(null);
        consultaFuncionarios.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 40));

        JLabel tituloInterno = new JLabel("Abaixo estao os funcionarios cadastrados. Total de funcionarios: " + academia.getFuncionarios().size()); 
        tituloInterno.setFont(new Font("Times New Roman", Font.BOLD, 22)); 
        tituloInterno.setForeground(new Color(0, 102, 204));
        consultaFuncionarios.add(tituloInterno);

       Set<Funcionario> funcionarios = academia.getFuncionarios();

        for (Funcionario f : funcionarios) {
            JTextArea labelFuncionario = new JTextArea(f.toString());
            labelFuncionario.setEditable(false);
            consultaFuncionarios.add(labelFuncionario);
        }

        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.addActionListener(e -> {
            consultaFuncionarios.setVisible(false);
            interfacePrincipal.setVisible(true);
        });

        consultaFuncionarios.add(botaoVoltar);
        consultaFuncionarios.setVisible(true);
    }

    public static void janelaConsultaAlunos(Academia academia, JFrame interfacePrincipal) {

        JFrame consultaAlunos = new JFrame("Consulta de alunos.");
        consultaAlunos.setSize(800, 700);
        consultaAlunos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        consultaAlunos.setLocationRelativeTo(null);
        consultaAlunos.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 40));

        JLabel tituloInterno = new JLabel("Abaixo estao os alunos cadastrados. Total de alunos: " + academia.getAlunos().size()); 
        tituloInterno.setFont(new Font("Times New Roman", Font.BOLD, 22)); 
        tituloInterno.setForeground(new Color(0, 102, 204));
        consultaAlunos.add(tituloInterno);

        Set<Aluno> alunos = academia.getAlunos();

        for(Aluno a : alunos) {
            JTextArea labelAluno = new JTextArea(a.toString());
            labelAluno.setEditable(false);
            consultaAlunos.add(labelAluno);
        }
        
        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.addActionListener(e -> {
            consultaAlunos.setVisible(false);
            interfacePrincipal.setVisible(true);
        });

        consultaAlunos.add(botaoVoltar);
        consultaAlunos.setVisible(true);
    }

    public static void janelaConsultaTreinos(Academia academia, JFrame interfacePrincipal) {

        JFrame consultaTreinos = new JFrame("Consulta de treinos.");
        consultaTreinos.setSize(800, 700);
        consultaTreinos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        consultaTreinos.setLocationRelativeTo(null);
        consultaTreinos.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 40));

        JLabel tituloInterno = new JLabel("Abaixo estao os treinos cadastrados. Total de treinos: " + academia.getTreinosMap().size()); 
        tituloInterno.setFont(new Font("Times New Roman", Font.BOLD, 22)); 
        tituloInterno.setForeground(new Color(0, 102, 204));
        consultaTreinos.add(tituloInterno);

        Map<Integer, Treino> treinosMap = academia.getTreinosMap();

        for(Treino t : treinosMap.values()) {
            JTextArea labelTreino = new JTextArea(t.toString());
            labelTreino.setEditable(false);
            consultaTreinos.add(labelTreino);
        }

        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.addActionListener(e -> {
            consultaTreinos.setVisible(false);
            interfacePrincipal.setVisible(true);
        });

        consultaTreinos.add(botaoVoltar);
        consultaTreinos.setVisible(true);
    }
}
