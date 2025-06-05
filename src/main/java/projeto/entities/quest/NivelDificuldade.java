package projeto.entities.quest;

public enum NivelDificuldade {
    FACIL(1, "Fácil"),
    MEDIO(2, "Médio"),
    DIFICIL(3, "Difícil");

    private final int valor;
    private final String nome;

    NivelDificuldade(int valor, String nome) {
        this.valor = valor;
        this.nome = nome;
    }

    public int getValor() {
        return valor;
    }

    public String getNome() {
        return nome;
    }

    // Busca o valor do enum por um int. ex: 1 == facil
    public static NivelDificuldade intParaValor(int valor) {
        for (NivelDificuldade nivel : values()) {
            if (nivel.valor == valor) {
                return nivel;
            }
        }
        return null;
    }

    // Verifica se valor passado é válido
    public static boolean valorValido(int valor) {
        return intParaValor(valor) != null;
    }
}
