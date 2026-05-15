/**
 * Representa um recurso utilizado em um projeto social do StudentHelp.
 *
 * O MER da apresentacao considera recurso como item financeiro, material,
 * humano ou servico usado em projetos sociais. Esta classe implementa os
 * atributos pedidos pelo professor e o metodo getValorTotal().
 */
public class Recurso {
    private final int id;
    private final String nome;
    private final String tipo;
    private final int quantidade;
    private final double valorUnitario;

    /**
     * Construtor completo da classe Recurso.
     *
     * @param id identificador unico do recurso
     * @param nome nome do recurso
     * @param tipo tipo do recurso: material, financeiro, humano ou servico
     * @param quantidade quantidade disponivel ou alocada
     * @param valorUnitario valor unitario do recurso
     */
    public Recurso(int id, String nome, String tipo, int quantidade, double valorUnitario) {
        if (id <= 0) {
            throw new IllegalArgumentException("O id do recurso deve ser positivo.");
        }
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do recurso e obrigatorio.");
        }
        if (tipo == null || tipo.isBlank()) {
            throw new IllegalArgumentException("O tipo do recurso e obrigatorio.");
        }
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
        }
        if (valorUnitario < 0) {
            throw new IllegalArgumentException("O valor unitario nao pode ser negativo.");
        }

        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    /**
     * Calcula o valor total do recurso.
     *
     * @return quantidade multiplicada pelo valor unitario
     */
    public double getValorTotal() {
        return quantidade * valorUnitario;
    }

    @Override
    public String toString() {
        return "Recurso{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", tipo='" + tipo + '\'' +
                ", quantidade=" + quantidade +
                ", valorUnitario=R$ " + String.format("%.2f", valorUnitario) +
                ", valorTotal=R$ " + String.format("%.2f", getValorTotal()) +
                '}';
    }
}
