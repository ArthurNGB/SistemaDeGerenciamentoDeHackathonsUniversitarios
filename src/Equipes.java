import java.util.ArrayList;
import java.util.List;

public class Equipes {
    private static final Equipes instance = new Equipes();
    private List<Equipe> listaEquipes;

    private Equipes() {
        listaEquipes = new ArrayList<>();
    }

    public static Equipes getInstance() {
        return instance;
    }

    public void incluir(Equipe equipe) {
        this.listaEquipes.add(equipe);
    }

    public List<Equipe> getListaEquipes() {
        return this.listaEquipes;
    }
}