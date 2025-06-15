public class Profissional extends Pessoa {
    private String especialidade;

    public Profissional(String nome, String email, Instituicao instituicao, String especialidade) {
        super(nome, email, instituicao);
        this.especialidade = especialidade;
    }
}