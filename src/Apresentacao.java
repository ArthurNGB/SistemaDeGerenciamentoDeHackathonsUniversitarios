import java.time.LocalDateTime;

public class Apresentacao implements Avaliavel {
    private Projeto projeto;
    private Banca banca;
    private Sala local;
    private LocalDateTime dataHora;

    public Apresentacao(Projeto projeto, Banca banca, Sala local, LocalDateTime dataHora) {
        this.projeto = projeto;
        this.banca = banca;
        this.local = local;
        this.dataHora = dataHora;
    }

    @Override
    public void avaliar() {
        System.out.println("Avaliando projeto '" + projeto.getNome() + "'...");
        banca.calcularNotaFinal();
        System.out.println("Avaliação concluída. Nota final calculada.");
    }
}