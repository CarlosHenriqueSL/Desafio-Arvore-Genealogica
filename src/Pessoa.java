public class Pessoa {

    private String nome;
    private Pessoa pai;

    public Pessoa(String nome, Pessoa pai) {
        this.nome = nome;
        this.pai = pai;
    }

    public String getNome() {
        return nome;
    }

    // Metodo necessario para acessar o antecessor do objeto atual
    public Pessoa getPai() {
        return pai;
    }
}
