package entities.quest;

// Define níveis de dificuldade das missões
public class NivelDificuldade {
  public static final int FACIL = 1;
  public static final int MEDIO = 2;
  public static final int DIFICIL = 3;

  // Obter nome do nível de dificuldade
  public static String getNome(int valor) {
    if (valor == MEDIO)
      return "Médio";
    if (valor == DIFICIL)
      return "Difícil";
    return "Fácil";
  }

  // Verificar valor de dificuldade válido
  public static boolean valorValido(int valor) {
    return valor >= FACIL && valor <= DIFICIL;
  }
}