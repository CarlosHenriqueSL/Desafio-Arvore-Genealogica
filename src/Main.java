public class Main {
    public static void main(String[] args) {

        // Objetos criados para representar a arvore genealogica
        // Cada objeto referencia o seu antecessor pelo atributo "pai"
        // Eles estao ordenados por niveis: nivel 0 = filho, nivel 1 = pai, nivel 2 = avo... e assim por diante
        // O ultimo objeto, nesse caso, o tataravo, nao referencia ninguem, por ser o ultimo da arvore
        Pessoa tataravo = new Pessoa("Antonio", null);
        Pessoa bisavo = new Pessoa("Sergio", tataravo);
        Pessoa avo = new Pessoa("Daniel", bisavo);
        Pessoa pai = new Pessoa("Luis", avo);
        Pessoa filho = new Pessoa("Carlos", pai);

        // Variavel de nivel criada para teste
        int nivel = 1;

        Pessoa resultado = buscarAntepassado(nivel, filho);

        if (resultado != null) {
            System.out.println("Pessoa encontrada para o nivel " + nivel + " = " + resultado.getNome());
        }
        else {
            System.out.println("Pessoa nao encontrada para o nivel " + nivel);
        }
    }

    // Metodo criado para buscar um antepassado, dado um nivel e uma pessoa como base
    public static Pessoa buscarAntepassado(int nivel, Pessoa pessoa) {
        validarEntradas(nivel, pessoa);

        for (int i = 0; i < nivel; i++) {
            // Verificacao para evitar erros caso a arvore acabe antes do nivel desejado
            if (pessoa.getPai() == null) {
                return null;
            }

            // Logica para encontrar o antecessor desejado
            pessoa = pessoa.getPai();
        }

        return pessoa;
    }

    // Metodo criado para validar as entradas nivel e pessoa
    // Verifica se o nivel e maior ou igual do que zero
    // Verifica se a pessoa existe (diferente de null)
    public static void validarEntradas(int nivel, Pessoa pessoa) {
        if (nivel < 0) {
            throw new IllegalArgumentException("O nivel informado e menor do que zero!");
        }
        if (pessoa == null) {
            throw new IllegalArgumentException("A pessoa informada nao existe!");
        }
    }
}