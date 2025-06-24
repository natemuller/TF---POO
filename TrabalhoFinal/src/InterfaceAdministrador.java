import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InterfaceAdministrador extends JFrame {

    private Academia academia;
    private JFrame interfacePrincipal;

    public InterfaceAdministrador(Academia academia, JFrame interfacePrincipal) {
        this.academia = academia;
        this.interfacePrincipal = interfacePrincipal;
    }
    
    public static void exibirJanelaAdministrador (Academia academia, JFrame interfacePrincipal) {

        JFrame janelaAdministrador = new JFrame("Modo administrador.");
        janelaAdministrador.setSize(600, 500);
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
                JOptionPane.showMessageDialog(null, "Senha incorreta. Tente novamente.");
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
        janelaAdministrador.setSize(600, 500);
        janelaAdministrador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelaAdministrador.setLocationRelativeTo(null);
        janelaAdministrador.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 40));

        JLabel tituloInterno = new JLabel("Selecione uma opcao: "); 
        tituloInterno.setFont(new Font("Times New Roman", Font.BOLD, 22)); 
        tituloInterno.setForeground(new Color(0, 102, 204));
        janelaAdministrador.add(tituloInterno);

        janelaAdministrador.setVisible(true);
    }
}
