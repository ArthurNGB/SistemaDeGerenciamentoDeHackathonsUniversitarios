public class Projeto {
    private String nome;
    private Profissional orientador;
    private Equipe equipe;
    private double notaFinal; // Usando double para média

    public Projeto(String nome, Profissional orientador, Equipe equipe) {
        this.nome = nome;
        this.orientador = orientador;
        this.equipe = equipe;
        this.notaFinal = 0.0;
    }

    public String getNome() {
        return nome;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }

    @Override
    public String toString() {
        return "Projeto '" + nome + "' da equipe '" + equipe.getNome() + "' - Nota Final: " + String.format("%.2f", notaFinal);
    }
}