import java.util.ArrayList;
import java.util.List;

public class Apresentacoes {
    private static final Apresentacoes instance = new Apresentacoes();
    private List<Apresentacao> listaApresentacoes;

    private Apresentacoes() {
        listaApresentacoes = new ArrayList<>();
    }

    public static Apresentacoes getInstance() {
        return instance;
    }

    public void incluir(Apresentacao apresentacao) {
        this.listaApresentacoes.add(apresentacao);
    }

    public List<Apresentacao> getListaApresentacoes() {
        return this.listaApresentacoes;
    }
}