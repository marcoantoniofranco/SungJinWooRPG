package entities.quest;

import java.util.ArrayList;

public class Quest {
    private static int contadorId;
    private int id;

    private static int quantidade;
    private String titulo;
    private int dificuldade; // 1 = Fácil, 2 = Médio, 3 = Difícil
    private String descricao;
    private String duracao;
    private boolean finalizada;

    // Criar missão com título, dificuldade, descrição e duração
    public Quest(String titulo, int dificuldade, String descricao, String duracao) {
        quantidade++;
        contadorId++;
        id = contadorId;
        this.titulo = titulo;
        this.dificuldade = dificuldade;
        this.descricao = descricao;
        this.duracao = duracao;
        this.finalizada = false;
    }

    // Marcar missão como finalizada
    public void finalizar() {
        finalizada = true;
    }

    // Calcular XP com base na dificuldade e duração
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

    // Obter nome da dificuldade
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public String toString(){
//        if(quantidade == 0){
//            return "\n=== Suas Missões ==="
//                   +"\nVocê ainda não tem missões!";
//        }
//        for (int i = 0; i < quantidade)
//
//        return "\n=== Suas Missões ==="
//
//    }
}