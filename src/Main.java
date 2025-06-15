import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        System.out.println("### Gerenciador de Hackathon Universitário ###\n");

        Universidade uniPrincipal = new Universidade("Universidade Federal de Tecnologia");
        Empresa empApoiadora = new Empresa("Tech Solutions Inc.");

        Profissional orientador1 = new Profissional("Dr. Carlos", "carlos.orientador@uni.com", uniPrincipal, "Inteligência Artificial");
        Profissional orientador2 = new Profissional("Dra. Beatriz", "beatriz.orientadora@uni.com", uniPrincipal, "Sistemas Distribuídos");

        System.out.println("1. Criando equipes e alunos...");
        Equipe equipeA = new Equipe("Devs Alpha");
        for (int i = 1; i <= 5; i++) {
            equipeA.adicionarMembro(new Estudante("Aluno A" + i, "aluno.a" + i + "@uni.com", uniPrincipal));
        }

        Equipe equipeB = new Equipe("Cyber Punks");
        for (int i = 1; i <= 5; i++) {
            equipeB.adicionarMembro(new Estudante("Aluno B" + i, "aluno.b" + i + "@uni.com", uniPrincipal));
        }
        
        Equipes.getInstance().incluir(equipeA);
        Equipes.getInstance().incluir(equipeB);
        System.out.println("Equipes '" + equipeA.getNome() + "' e '" + equipeB.getNome() + "' criadas.\n");

        System.out.println("2. Criando e associando projetos...");
        Projeto projetoA = new Projeto("Sistema de Gestão de Biblioteca", orientador1, equipeA);
        Projeto projetoB = new Projeto("App de Caronas Universitárias", orientador2, equipeB);
        
        Projetos.getInstance().incluir(projetoA);
        Projetos.getInstance().incluir(projetoB);
        System.out.println("Projetos criados e associados às equipes.\n");

        System.out.println("3. Montando as bancas avaliadoras...");
        Banca bancaA = new Banca(projetoA);
        Banca bancaB = new Banca(projetoB);

        List<Jurado> jurados = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            jurados.add(new Jurado("Jurado " + i, "jurado" + i + "@tech.com", empApoiadora, "Desenvolvimento de Software"));
        }
        
        bancaA.adicionarJurado(jurados.get(0), 8);
        bancaA.adicionarJurado(jurados.get(1), 9);
        bancaA.adicionarJurado(jurados.get(2), 7);
        bancaA.adicionarJurado(jurados.get(3), 8);

        bancaB.adicionarJurado(jurados.get(0), 5);
        bancaB.adicionarJurado(jurados.get(1), 6);
        bancaB.adicionarJurado(jurados.get(2), 7);
        bancaB.adicionarJurado(jurados.get(3), 6);
        System.out.println("Bancas montadas e notas preliminares atribuídas.\n");
        
        System.out.println("4. Realizando as apresentações e calculando notas finais...");
        Sala sala1 = new Sala("Auditório Principal");
        Apresentacao apresentacaoA = new Apresentacao(projetoA, bancaA, sala1, LocalDateTime.now());
        Apresentacao apresentacaoB = new Apresentacao(projetoB, bancaB, sala1, LocalDateTime.now().plusHours(1));

        apresentacaoA.avaliar();
        apresentacaoB.avaliar();
        System.out.println();

        System.out.println("5. Listando projetos aprovados (Nota Final >= 7.0):");
        List<Projeto> todosOsProjetos = Projetos.getInstance().getListaProjetos();
        
        List<Projeto> projetosAprovados = todosOsProjetos.stream()
                .filter(p -> p.getNotaFinal() >= 7)
                .collect(Collectors.toList());

        if (projetosAprovados.isEmpty()) {
            System.out.println("Nenhum projeto foi aprovado.");
        } else {
            projetosAprovados.forEach(System.out::println);
        }
        
        System.out.println("\n### Execução finalizada. ###");
    }
}