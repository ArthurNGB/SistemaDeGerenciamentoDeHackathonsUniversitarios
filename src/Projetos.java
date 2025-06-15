import java.util.ArrayList;
import java.util.List;

public class Projetos {
    private static final Projetos instance = new Projetos();
    private List<Projeto> listaProjetos;

    private Projetos() {
        listaProjetos = new ArrayList<>();
    }

    public static Projetos getInstance() {
        return instance;
    }

    public void incluir(Projeto projeto) {
        this.listaProjetos.add(projeto);
    }

    public List<Projeto> getListaProjetos() {
        return this.listaProjetos;
    }
}