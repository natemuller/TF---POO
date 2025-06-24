public class Exercicio {
    private static int idCont = 1;
    private int id;
    private String nome;
    private int series;
    private int repeticoes;
    private double carga;

    public Exercicio(String nome, int series, int repeticoes, double carga) {
        this.id = idCont++;
        this.nome = nome;
        this.series = series;
        this.repeticoes = repeticoes;
        this.carga = carga;
    }

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public int getSeries() {
        return this.series;
    }

    public int getRepeticoes() {
        return this.repeticoes;
    }

    public double getCarga() {
        return this.carga;
    }

    public void setCarga(double carga) {
        this.carga = carga;
    }
    @Override
    public String toString() {
        return "Exercício: " + nome + " | Séries: " + series + " | Repetições: " + repeticoes + ". ";
    }
}
