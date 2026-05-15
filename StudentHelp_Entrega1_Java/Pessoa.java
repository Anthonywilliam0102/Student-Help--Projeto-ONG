/**
 * Classe base que representa uma pessoa vinculada ao contexto do StudentHelp.
 *
 * Na primeira entrega, esta classe serve como base para os futuros cadastros
 * de doadores e voluntarios apresentados no MER. Todos os atributos sao
 * privados e acessados por getters, garantindo o encapsulamento solicitado.
 */
public class Pessoa {
    private final int id;
    private final String nome;
    private final String email;
    private final String telefone;

    /**
     * Construtor completo da classe Pessoa.
     *
     * @param id identificador unico da pessoa
     * @param nome nome completo da pessoa
     * @param email email de contato
     * @param telefone telefone de contato
     */
    public Pessoa(int id, String nome, String email, String telefone) {
        if (id <= 0) {
            throw new IllegalArgumentException("O id da pessoa deve ser positivo.");
        }
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome da pessoa e obrigatorio.");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("O e-mail da pessoa e obrigatorio.");
        }

        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone == null ? "" : telefone;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
