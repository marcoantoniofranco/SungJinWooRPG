package PlayerEMissao;

public class Quest {
    public String titulo;
    public int dificuldade; // 1 = Fácil, 2 = Médio, 3 = Difícil
    public String descricao;
    public String duracao;
    public boolean finalizada;

    public Quest(String titulo, int dificuldade, String descricao, String duracao) {
        this.titulo = titulo;
        this.dificuldade = dificuldade;
        this.descricao = descricao;
        this.duracao = duracao;
        this.finalizada = false;
    }

    public void finalizar() {
        finalizada = true;
    }

    public int calcularXP() {
        if (!finalizada)
            return 0;

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

    public String getDificuldadeNome() {
        return NivelDificuldade.getNome(dificuldade);
    }
}