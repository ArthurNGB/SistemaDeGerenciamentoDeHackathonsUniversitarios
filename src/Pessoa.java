public abstract class Pessoa {
    private String nome;
    private String email;
    private Instituicao instituicao;

    public Pessoa(String nome, String email, Instituicao instituicao) {
        this.nome = nome;
        this.instituicao = instituicao;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }
}