package PlayerEMissao;

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

  public static NivelDificuldade getPorValor(int valor) {
    for (NivelDificuldade nivel : values()) {
      if (nivel.valor == valor) {
        return nivel;
      }
    }

    return FACIL;
  }
}