import javax.swing.*;

public class TelaTesteSwing {

    public static void main(String[] args) {
        Academia academia = new Academia();
        // Adicione alunos, funcionários, etc. se quiser

        exibirJanelaPrincipal(academia);
    }

    public static void exibirJanelaPrincipal(Academia academia) {
        JFrame janelaPrincipal = new JFrame("Sistema Academia");
        janelaPrincipal.setSize(400, 300);
        janelaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelaPrincipal.setLayout(null);
        janelaPrincipal.setLocationRelativeTo(null);

        JButton botaoAluno = new JButton("Aluno");
        botaoAluno.setBounds(140, 50, 120, 30);
        janelaPrincipal.add(botaoAluno);

        JButton botaoProfessor = new JButton("Professor");
        botaoProfessor.setBounds(140, 100, 120, 30);
        janelaPrincipal.add(botaoProfessor);

        JButton botaoCaixa = new JButton("Caixa");
        botaoCaixa.setBounds(140, 150, 120, 30);
        janelaPrincipal.add(botaoCaixa);

        JButton botaoUsuario = new JButton("Usuario");
        botaoUsuario.setBounds(140, 200, 120, 30);
        janelaPrincipal.add(botaoUsuario);

        botaoAluno.addActionListener(e -> abrirJanelaAluno(academia));
        botaoProfessor.addActionListener(e -> abrirJanelaProfessor());
        botaoCaixa.addActionListener(e -> abrirJanelaCaixa());
        botaoUsuario.addActionListener(e -> abrirJanelaUsuario());

        janelaPrincipal.setVisible(true);
    }

    public static void abrirJanelaAluno(Academia academia) {
        JFrame janelaDoAluno = new JFrame("Buscar Aluno");
        janelaDoAluno.setSize(400, 300);
        janelaDoAluno.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        janelaDoAluno.setLayout(null);

        JLabel labelNome = new JLabel("Digite o Nome:");
        labelNome.setBounds(50, 20, 200, 20);
        janelaDoAluno.add(labelNome);

        JTextField campoNome = new JTextField();
        campoNome.setBounds(50, 50, 200, 30);
        janelaDoAluno.add(campoNome);

        JButton botaoBuscar = new JButton("Buscar");
        botaoBuscar.setBounds(260, 50, 80, 30);
        janelaDoAluno.add(botaoBuscar);

        JTextArea resultado = new JTextArea();
        resultado.setEditable(false);
        resultado.setBounds(50, 100, 290, 120);
        janelaDoAluno.add(resultado);

        botaoBuscar.addActionListener(e -> {
            String nome = campoNome.getText().trim();
            if (nome.isEmpty()) {
                resultado.setText("Digite um nome válido.");
                return;
            }

            Aluno aluno = academia.buscarAluno(nome);
            if (aluno != null) {
                resultado.setText(aluno.toString());
            } else {
                resultado.setText("Aluno não encontrado.");
            }
        });

        janelaDoAluno.setLocationRelativeTo(null);
        janelaDoAluno.setVisible(true);
    }

    public static void abrirJanelaProfessor() {
        JFrame janelaDoProfessor = new JFrame("PROFESSOR");
        janelaDoProfessor.setSize(300, 200);
        janelaDoProfessor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        janelaDoProfessor.setLayout(null);

        JLabel labelNome = new JLabel("Nome do Professor:");
        labelNome.setBounds(50, 20, 200, 20);
        janelaDoProfessor.add(labelNome);

        JTextField campoTexto = new JTextField();
        campoTexto.setBounds(50, 50, 200, 30);
        janelaDoProfessor.add(campoTexto);

        janelaDoProfessor.setLocationRelativeTo(null);
        janelaDoProfessor.setVisible(true);
    }

    public static void abrirJanelaCaixa() {
        JFrame janelaDoCaixa = new JFrame("CAIXA");
        janelaDoCaixa.setSize(300, 200);
        janelaDoCaixa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        janelaDoCaixa.setLayout(null);

        JLabel labelMensagem = new JLabel("Janela do Caixa aberta!");
        labelMensagem.setBounds(50, 50, 200, 30);
        janelaDoCaixa.add(labelMensagem);

        janelaDoCaixa.setLocationRelativeTo(null);
        janelaDoCaixa.setVisible(true);
    }

    public static void abrirJanelaUsuario() {
        JFrame janelaDoUsuario = new JFrame("USUARIO");
        janelaDoUsuario.setSize(300, 200);
        janelaDoUsuario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        janelaDoUsuario.setLayout(null);

        JLabel labelMensagem = new JLabel("Janela do Usuario aberta!");
        labelMensagem.setBounds(50, 50, 200, 30);
        janelaDoUsuario.add(labelMensagem);

        janelaDoUsuario.setLocationRelativeTo(null);
        janelaDoUsuario.setVisible(true);
    }
}
