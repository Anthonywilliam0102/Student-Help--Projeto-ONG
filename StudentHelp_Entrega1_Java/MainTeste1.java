import java.time.LocalDate;

/**
 * Teste unitario basico da Entrega 1.
 *
 * Este teste demonstra as classes Pessoa, Recurso e Projeto, conforme a
 * primeira entrega solicitada pelo professor. Os dados usados seguem o tema
 * da apresentacao StudentHelp: ONGs, projetos sociais e recursos.
 */
public class MainTeste1 {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa(
                1,
                "Maria Eduarda Santos",
                "maria.santos@email.com",
                "(81) 99999-0000"
        );

        Recurso recurso1 = new Recurso(
                1,
                "Cestas basicas",
                "Material",
                25,
                85.50
        );

        Recurso recurso2 = new Recurso(
                2,
                "Kits escolares",
                "Material",
                40,
                32.75
        );

        Projeto projeto = new Projeto(
                1,
                "StudentHelp - Apoio Educacional",
                "Projeto social para auxiliar estudantes em situacao de vulnerabilidade.",
                LocalDate.of(2026, 5, 4),
                LocalDate.of(2026, 8, 4),
                10000.00
        );

        projeto.alocarRecurso(recurso1);
        projeto.alocarRecurso(recurso2);

        System.out.println("===== ENTREGA 1 - STUDENTHELP =====");
        System.out.println("Pessoa cadastrada:");
        System.out.println(pessoa);

        System.out.println("\nProjeto cadastrado:");
        System.out.println(projeto);

        System.out.println("\nRecursos alocados no projeto:");
        for (Recurso recurso : projeto.getRecursos()) {
            System.out.println("- " + recurso);
        }

        System.out.println("\nTotal de recursos alocados: R$ "
                + String.format("%.2f", projeto.getTotalRecursosAlocados()));
        System.out.println("Teste da Entrega 1 executado com sucesso.");
    }
}
