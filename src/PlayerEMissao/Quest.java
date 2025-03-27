package PlayerEMissao;

public class Quest {
    public String titulo;
    public int dificuldade; // 1 = Fácil, 2 = Médio, 3 = Difícil
    public String descricao;
    public String duracao;

    public Quest(String titulo, int dificuldade, String descricao, String duracao) {
        this.titulo = titulo;
        this.dificuldade = dificuldade;
        this.descricao = descricao;
        this.duracao = duracao;
    }

    public int calcularXP() {
        // XP base = 100
        int multiplicadorDificuldade = switch (dificuldade) {
            case 2 -> 2; // Médio
            case 3 -> 3; // Difícil
            default -> 1; // Fácil
        };

        int multiplicadorDuracao = switch (duracao) {
            case "semanal" -> 2;
            case "mensal" -> 3;
            default -> 1; // diária
        };

        return 100 * multiplicadorDificuldade * multiplicadorDuracao;
    }

    public String getDificuldadeNome() {
        return switch (dificuldade) {
            case 2 -> "Médio";
            case 3 -> "Difícil";
            default -> "Fácil";
        };
    }
}