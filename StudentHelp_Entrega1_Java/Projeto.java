import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Representa um projeto social gerenciado pela ONG no sistema StudentHelp.
 *
 * A classe possui composicao com Recurso, pois um projeto organiza uma lista
 * de recursos alocados para executar suas acoes sociais.
 */
public class Projeto {
    private final int id;
    private final String nome;
    private final String descricao;
    private final LocalDate dataInicio;
    private final LocalDate dataFim;
    private final double orcamento;
    private final ArrayList<Recurso> recursos;

    /**
     * Construtor completo da classe Projeto.
     *
     * @param id identificador unico do projeto
     * @param nome nome do projeto social
     * @param descricao descricao do objetivo do projeto
     * @param dataInicio data de inicio do projeto
     * @param dataFim data de encerramento do projeto
     * @param orcamento orcamento previsto para o projeto
     */
    public Projeto(int id, String nome, String descricao, LocalDate dataInicio, LocalDate dataFim, double orcamento) {
        if (id <= 0) {
            throw new IllegalArgumentException("O id do projeto deve ser positivo.");
        }
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do projeto e obrigatorio.");
        }
        if (dataInicio == null || dataFim == null) {
            throw new IllegalArgumentException("As datas do projeto sao obrigatorias.");
        }
        if (dataFim.isBefore(dataInicio)) {
            throw new IllegalArgumentException("A data final nao pode ser anterior a data inicial.");
        }
        if (orcamento < 0) {
            throw new IllegalArgumentException("O orcamento nao pode ser negativo.");
        }

        this.id = id;
        this.nome = nome;
        this.descricao = descricao == null ? "" : descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.orcamento = orcamento;
        this.recursos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public double getOrcamento() {
        return orcamento;
    }

    /**
     * Retorna uma visualizacao protegida da lista de recursos.
     * Assim, a lista interna nao e alterada diretamente fora da classe.
     *
     * @return lista nao modificavel de recursos
     */
    public List<Recurso> getRecursos() {
        return Collections.unmodifiableList(recursos);
    }

    /**
     * Aloca um recurso ao projeto, demonstrando a composicao Projeto -> Recursos.
     *
     * @param recurso recurso a ser inserido no projeto
     */
    public void alocarRecurso(Recurso recurso) {
        if (recurso == null) {
            throw new IllegalArgumentException("O recurso nao pode ser nulo.");
        }
        recursos.add(recurso);
    }

    /**
     * Soma o valor total de todos os recursos alocados no projeto.
     *
     * @return valor total dos recursos do projeto
     */
    public double getTotalRecursosAlocados() {
        double total = 0.0;
        for (Recurso recurso : recursos) {
            total += recurso.getValorTotal();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Projeto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                ", orcamento=R$ " + String.format("%.2f", orcamento) +
                ", recursosAlocados=" + recursos.size() +
                '}';
    }
}
