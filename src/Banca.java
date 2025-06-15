import java.util.HashMap;
import java.util.Map;

public class Banca {
    private Projeto projetoAvaliado;
    private Map<Jurado, Integer> jurados;

    public Banca(Projeto projetoAvaliado) {
        this.projetoAvaliado = projetoAvaliado;
        this.jurados = new HashMap<>();
    }

    public void adicionarJurado(Jurado jurado, Integer nota) {
        this.jurados.put(jurado, nota);
    }

    public void calcularNotaFinal() {
        if (jurados.isEmpty()) {
            projetoAvaliado.setNotaFinal(0);
            return;
        }

        double somaDasNotas = 0;
        for (Integer nota : jurados.values()) {
            somaDasNotas += nota;
        }
        
        double media = somaDasNotas / jurados.size();
        projetoAvaliado.setNotaFinal(media);
    }
}