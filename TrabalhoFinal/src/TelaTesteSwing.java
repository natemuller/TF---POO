import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class TelaTesteSwing {
    public static void main(String[] args){
 
       // Criando a janela principal
        JFrame janelaPrincipal = new JFrame("Sistema Academia");
        janelaPrincipal.setSize(400, 300); // largura, altura
        janelaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelaPrincipal.setLayout(null); // permite usar setBounds
        janelaPrincipal.setLocationRelativeTo(null); // centraliza na tela

        // Criando e posicionando os botões
        JButton botaoAluno = new JButton("Aluno");
        botaoAluno.setBounds(140, 50, 120, 30); // x, y, largura, altura
        janelaPrincipal.add(botaoAluno);

        JButton botaoProfessor = new JButton("Professor");
        botaoProfessor.setBounds(140, 100, 120, 30);
        janelaPrincipal.add(botaoProfessor);

        JButton botaoCaixa = new JButton("Caixa");
        botaoCaixa.setBounds(140, 150, 120, 30);
        janelaPrincipal.add(botaoCaixa);

        // Tornando a janela visível
        janelaPrincipal.setVisible(true);

        // Criando a nova janela para o aluno
        botaoAluno.addActionListener(new ActionListener() {
        
            public void actionPerformed(ActionEvent e) {
            JFrame janelaDoAluno = new JFrame("ALUNO");
            janelaDoAluno.setSize(300, 200);
            janelaDoAluno.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha só essa
            janelaDoAluno.setLayout(null);
            janelaDoAluno.setVisible(true);
                
            // Label (texto explicativo acima do campo)
            JLabel labelNome = new JLabel("Nome do Aluno:");
            labelNome.setBounds(50, 20, 200, 20); // posição do texto
            janelaDoAluno.add(labelNome);


            // Campo de texto dentro da nova janela
            JTextField campoTexto = new JTextField();
            campoTexto.setBounds(50, 50, 200, 30);
            janelaDoAluno.add(campoTexto);
        
            }
        
        });

  


        //criando a nova janela para o funcionario
        botaoProfessor.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            JFrame janelaDoFuncionario = new JFrame("Professor");
            janelaDoFuncionario.setSize(300, 200);
            janelaDoFuncionario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha só essa
            janelaDoFuncionario.setLayout(null);
            JLabel mensagem = new JLabel("Você abriu outra janela!");
            mensagem.setBounds(50, 50, 200, 30);
            janelaDoFuncionario.add(mensagem);
            janelaDoFuncionario.setVisible(true);
           
            // Label (texto explicativo acima do campo)
            JLabel labelNome = new JLabel("Nome do Professor:");
            labelNome.setBounds(50, 20, 200, 20); // posição do texto
            janelaDoFuncionario.add(labelNome);


            // Campo de texto dentro da nova janela
            JTextField campoTexto = new JTextField();
            campoTexto.setBounds(50, 50, 200, 30);
            janelaDoFuncionario.add(campoTexto);    
            

        
        
        
            }
        });

        janelaPrincipal.setVisible(true);


         //criando a nova janela para o caixa
        botaoCaixa.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            JFrame janelaDoCaixa = new JFrame("Professor");
            janelaDoCaixa.setSize(300, 200);
            janelaDoCaixa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha só essa
            janelaDoCaixa.setLayout(null);
            JLabel mensagem = new JLabel("Você abriu outra janela!");
            mensagem.setBounds(50, 50, 200, 30);
            janelaDoCaixa.add(mensagem);
            janelaDoCaixa.setVisible(true);
        
            }
        });

        janelaPrincipal.setVisible(true);
    }
    }




    
        
