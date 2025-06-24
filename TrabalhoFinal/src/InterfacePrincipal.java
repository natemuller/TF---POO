import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


//A ideia da classe é ser uma janela principal para acessar os diferentes modos que o programa pode ir, sendo eles: Aluno, Professor, Caixa e Administrador.
public class InterfacePrincipal extends JFrame {

    public static void exibirJanelaPrincipal(Academia academia) {
        
        JFrame janelaPrincipal = new JFrame("Sistema gerenciador de academia.");
        janelaPrincipal.setSize(800, 700);
        janelaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelaPrincipal.setLocationRelativeTo(null);
        janelaPrincipal.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 40));        
        //Trecho acima cria a janela principal e, centraliza ela na tela.

        JLabel tituloInterno = new JLabel("Seja bem-vindo a nossa Academia! Selecione o modo:"); 
        tituloInterno.setFont(new Font("Times New Roman", Font.BOLD, 22)); 
        tituloInterno.setForeground(new Color(0, 102, 204));
        janelaPrincipal.add(tituloInterno);
        //Trecho acima cria um título interno e adiciona ele na janela principal.

        JButton botaoModoAluno = new JButton ("Modo Aluno");
        janelaPrincipal.add(botaoModoAluno);

        botaoModoAluno.addActionListener(e -> {
            janelaPrincipal.setVisible(false);
            InterfaceAluno.exibirJanelaAluno(academia, janelaPrincipal);
        });

        JButton botaoModoProfessor = new JButton ("Modo Professor");
        janelaPrincipal.add(botaoModoProfessor);

        botaoModoProfessor.addActionListener(e -> {
            janelaPrincipal.setVisible(false);
            InterfaceProfessor.exibirJanelaProfessor(academia, janelaPrincipal);
        });

        JButton botaoModoCaixa = new JButton ("Modo Caixa");
        janelaPrincipal.add(botaoModoCaixa);

        botaoModoCaixa.addActionListener(e -> {
            janelaPrincipal.setVisible(false);
            InterfaceCaixa.exibirJanelaCaixa(academia, janelaPrincipal);
        });

        JButton botaoModoAdministrador = new JButton ("Modo Administrador");
        janelaPrincipal.add(botaoModoAdministrador);

        botaoModoAdministrador.addActionListener(e -> {
            janelaPrincipal.setVisible(false);
            InterfaceAdministrador.exibirJanelaAdministrador(academia, janelaPrincipal);
        });

        //Acima, adicionei os botões e, chamei respectivos métodos para cada um deles. Quando a janela nova é acionada, a principal some.
        //Para isso, precisei passar a janela principal como parâmetro para os métodos.

        janelaPrincipal.setVisible(true);
    }
    
}
