import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class TelaTesteSwing {

    public static void exibirJanelaPrincipal(Academia academia) {
        JFrame janelaPrincipal = new JFrame("Sistema Academia");
        janelaPrincipal.setSize(400, 300);
        janelaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelaPrincipal.setLocationRelativeTo(null);
        janelaPrincipal.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 40));

        JButton botaoAluno = new JButton("Aluno");
        JButton botaoProfessor = new JButton("Professor");
        JButton botaoCaixa = new JButton("Caixa");
        JButton botaoUsuario = new JButton("Usuario");

        janelaPrincipal.add(botaoAluno);
        janelaPrincipal.add(botaoProfessor);
        janelaPrincipal.add(botaoCaixa);
        janelaPrincipal.add(botaoUsuario);

        botaoAluno.addActionListener(e -> abrirJanelaAluno(academia));
        botaoProfessor.addActionListener(e -> abrirJanelaProfessor());
        botaoCaixa.addActionListener(e -> abrirJanelaCaixa());
        botaoUsuario.addActionListener(e -> abrirJanelaUsuario());

        janelaPrincipal.setVisible(true);
    }

    public static void abrirJanelaAluno(Academia academia) {
        JFrame janelaDoAluno = new JFrame("Buscar Aluno");
        janelaDoAluno.setSize(430, 150);
        janelaDoAluno.setLocationRelativeTo(null);
        janelaDoAluno.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel painel = new JPanel();
        painel.setLayout(null);
        janelaDoAluno.add(painel);

        JLabel labelNome = new JLabel("Digite o Nome:");
        labelNome.setBounds(20, 20, 120, 25);
        painel.add(labelNome);

        JTextField campoNome = new JTextField();
        campoNome.setBounds(140, 20, 180, 25);
        painel.add(campoNome);

        JButton botaoBuscar = new JButton("Buscar");
        botaoBuscar.setBounds(330, 20, 80, 25);
        painel.add(botaoBuscar);

        botaoBuscar.addActionListener(e -> {
            String nome = campoNome.getText().trim();
            if (nome.isEmpty()) {
                JOptionPane.showMessageDialog(janelaDoAluno, "Digite um nome válido.");
                return;
            }

            Aluno aluno = academia.buscarAluno(nome);
            if (aluno != null) {
                abrirJanelaDetalhesAluno(aluno, academia);
            } else {
                JOptionPane.showMessageDialog(janelaDoAluno, "Aluno não encontrado.");
            }
        });

        janelaDoAluno.setVisible(true);
    }

    public static void abrirJanelaDetalhesAluno(Aluno aluno, Academia academia) {
        JFrame janelaDetalhes = new JFrame("Detalhes do Aluno");
        janelaDetalhes.setSize(520, 450);
        janelaDetalhes.setLocationRelativeTo(null);
        janelaDetalhes.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        janelaDetalhes.setLayout(new BorderLayout());

        JTextArea detalhes = new JTextArea();
        detalhes.setEditable(false);
        detalhes.setLineWrap(true);
        detalhes.setWrapStyleWord(true);
        detalhes.setText(
            "Nome: " + aluno.getNome() + "\n" +
            "CPF: " + aluno.getCpf() + "\n" +
            "Data de Nascimento: " + aluno.getDataNasc() + "\n" +
            "Número da Matrícula: " + aluno.getNroMatricula() + "\n" +
            "Data de Início: " + aluno.getDataInicio() + "\n\n" +
            "Treinos atuais: " + (aluno.getTreinos().isEmpty() ? "Nenhum treino cadastrado." :
                String.join(", ", aluno.getTreinos().stream()
                    .map(t -> t.getDescricao())
                    .toList()))
        );
        JScrollPane scrollDetalhes = new JScrollPane(detalhes);
        scrollDetalhes.setPreferredSize(new Dimension(500, 150));
        janelaDetalhes.add(scrollDetalhes, BorderLayout.NORTH);

        JPanel painelTreinos = new JPanel();
        painelTreinos.setLayout(new BoxLayout(painelTreinos, BoxLayout.Y_AXIS));
        janelaDetalhes.add(new JScrollPane(painelTreinos), BorderLayout.CENTER);

        List<Treino> listaTreinosAcademia = new ArrayList<>(academia.getTreinosMap().values());

        Map<Treino, JCheckBox> checkboxes = new HashMap<>();
        Map<Treino, JButton> botoesEditar = new HashMap<>();

        for (Treino treino : listaTreinosAcademia) {
            JPanel linha = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JCheckBox cb = new JCheckBox(treino.getDescricao());
            boolean temTreino = aluno.getTreinos().stream()
                .anyMatch(t -> t.getDescricao().equals(treino.getDescricao()));
            cb.setSelected(temTreino);

            checkboxes.put(treino, cb);
            linha.add(cb);

            JButton btnEditar = new JButton("Editar Exercícios");
            botoesEditar.put(treino, btnEditar);
            btnEditar.setEnabled(cb.isSelected());
            linha.add(btnEditar);

            cb.addActionListener(e -> btnEditar.setEnabled(cb.isSelected()));
            btnEditar.addActionListener(e -> abrirJanelaEditarExercicios(treino));

            painelTreinos.add(linha);
        }

        JButton botaoSalvar = new JButton("Salvar treinos");
        janelaDetalhes.add(botaoSalvar, BorderLayout.SOUTH);

        botaoSalvar.addActionListener(e -> {
            aluno.getTreinos().clear();
            for (Treino treino : listaTreinosAcademia) {
                JCheckBox cb = checkboxes.get(treino);
                if (cb.isSelected()) {
                    Treino treinoClone = clonarTreino(treino);
                    aluno.adicionarTreino(treinoClone);
                }
            }
            JOptionPane.showMessageDialog(janelaDetalhes, "Treinos atualizados para o aluno " + aluno.getNome());
            janelaDetalhes.dispose();
        });

        janelaDetalhes.setVisible(true);
    }

    private static Treino clonarTreino(Treino treinoOriginal) {
        Treino clone = new Treino(treinoOriginal.getDescricao());
        for (Exercicio ex : treinoOriginal.getExercicios()) {
            Exercicio exClone = new Exercicio(
                ex.getNome(),
                ex.getSeries(),
                ex.getRepeticoes(),
                ex.getCarga()
            );
            clone.adicionarExercicio(exClone);
        }
        return clone;
    }

    public static void abrirJanelaEditarExercicios(Treino treino) {
        JFrame janelaExercicios = new JFrame("Editar Exercícios: " + treino.getDescricao());
        janelaExercicios.setSize(400, 300);
        janelaExercicios.setLocationRelativeTo(null);
        janelaExercicios.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
        janelaExercicios.add(new JScrollPane(painel));

        for (Exercicio ex : treino.getExercicios()) {
            JPanel linha = new JPanel(new FlowLayout(FlowLayout.LEFT));

            JLabel labelNome = new JLabel(ex.getNome() + " (" + ex.getSeries() + "x" + ex.getRepeticoes() + ")");
            linha.add(labelNome);

            JTextField campoCarga = new JTextField(String.valueOf(ex.getCarga()), 5);
            linha.add(new JLabel("Carga (kg): "));
            linha.add(campoCarga);

            campoCarga.addFocusListener(new FocusAdapter() {
                public void focusLost(FocusEvent e) {
                    try {
                        double novaCarga = Double.parseDouble(campoCarga.getText());
                        if (novaCarga < 0) throw new NumberFormatException();
                        ex.setCarga(novaCarga);
                    } catch (NumberFormatException excep) {
                        JOptionPane.showMessageDialog(janelaExercicios, "Carga inválida. Use um número >= 0.");
                        campoCarga.setText(String.valueOf(ex.getCarga()));
                    }
                }
            });

            painel.add(linha);
        }

        janelaExercicios.setVisible(true);
    }

    public static void abrirJanelaProfessor() {
        JFrame janelaDoProfessor = new JFrame("PROFESSOR");
        janelaDoProfessor.setSize(300, 200);
        janelaDoProfessor.setLocationRelativeTo(null);
        janelaDoProfessor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        janelaDoProfessor.setLayout(new FlowLayout());

        JLabel labelNome = new JLabel("Nome do Professor:");
        JTextField campoTexto = new JTextField(20);

        janelaDoProfessor.add(labelNome);
        janelaDoProfessor.add(campoTexto);

        janelaDoProfessor.setVisible(true);
    }

    public static void abrirJanelaCaixa() {
        JFrame janelaDoCaixa = new JFrame("CAIXA");
        janelaDoCaixa.setSize(300, 200);
        janelaDoCaixa.setLocationRelativeTo(null);
        janelaDoCaixa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        janelaDoCaixa.setLayout(new FlowLayout());

        JLabel labelMensagem = new JLabel("Janela do Caixa aberta!");
        janelaDoCaixa.add(labelMensagem);

        janelaDoCaixa.setVisible(true);
    }

    public static void abrirJanelaUsuario() {
        JFrame janelaDoUsuario = new JFrame("USUÁRIO");
        janelaDoUsuario.setSize(300, 200);
        janelaDoUsuario.setLocationRelativeTo(null);
        janelaDoUsuario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        janelaDoUsuario.setLayout(new FlowLayout());

        JLabel labelMensagem = new JLabel("Janela do Usuário aberta!");
        janelaDoUsuario.add(labelMensagem);

        janelaDoUsuario.setVisible(true);
    }
}
