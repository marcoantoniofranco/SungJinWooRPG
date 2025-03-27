package PlayerEMissao;

/**
 * Classe que define os níveis de dificuldade para as missões.
 * Contém constantes e métodos utilitários para manipulação dos níveis de dificuldade.
 */
public class NivelDificuldade {
  public static final int FACIL = 1;
  public static final int MEDIO = 2;
  public static final int DIFICIL = 3;

  /**
   * Retorna o nome do nível de dificuldade com base no valor numérico.
   * 
   * @param valor Valor numérico do nível de dificuldade
   * @return Nome do nível de dificuldade (Fácil, Médio ou Difícil)
   */
  public static String getNome(int valor) {
    if (valor == MEDIO)
      return "Médio";
    if (valor == DIFICIL)
      return "Difícil";
    return "Fácil";
  }

  /**
   * Verifica se o valor do nível de dificuldade é válido.
   * 
   * @param valor Valor a ser verificado
   * @return true se o valor estiver dentro do intervalo válido, false caso contrário
   */
  public static boolean valorValido(int valor) {
    return valor >= FACIL && valor <= DIFICIL;
  }
}