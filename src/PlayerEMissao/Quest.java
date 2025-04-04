package PlayerEMissao;

public class Quest {
    private String titulo;
    private int dificuldade; // 1 = Fácil, 2 = Médio, 3 = Difícil
    private String descricao;
    private String duracao;
    private boolean finalizada;

    /**
     * Construtor da classe Quest.
     * 
     * @param titulo      Título da missão
     * @param dificuldade Nível de dificuldade
     * @param descricao   Descrição da missão
     * @param duracao     Duração da missão
     */
    public Quest(String titulo, int dificuldade, String descricao, String duracao) {
        this.titulo = titulo;
        this.dificuldade = dificuldade;
        this.descricao = descricao;
        this.duracao = duracao;
        this.finalizada = false;
    }

    /**
     * Finaliza a missão.
     */
    public void finalizar() {
        finalizada = true;
    }

    /**
     * Calcula a quantidade de XP baseado na dificuldade e duração da missão.
     * 
     * @return Quantidade de XP calculada
     */
    public int calcularXP() {
        // XP base = 100
        int multiplicadorDificuldade = switch (dificuldade) {
            case NivelDificuldade.MEDIO -> 2;
            case NivelDificuldade.DIFICIL -> 3;
            default -> 1;
        };

        int multiplicadorDuracao = switch (duracao) {
            case "semanal" -> 2;
            case "mensal" -> 3;
            default -> 1; // diária
        };

        return 100 * multiplicadorDificuldade * multiplicadorDuracao;
    }

    /**
     * Retorna o nome da dificuldade da missão.
     * 
     * @return Nome da dificuldade
     */
    public String getDificuldadeNome() {
        return NivelDificuldade.getNome(dificuldade);
    }

    // Getters e Setters

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(int dificuldade) {
        this.dificuldade = dificuldade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public boolean isFinalizada() {
        return finalizada;
    }

    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
    }
}