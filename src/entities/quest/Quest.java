package entities.quest;

import entities.player.Player;

import java.time.Instant;
import java.util.*;

public class Quest {
    private static int contadorId;
    private int id;
    private static int quantidade;
    private String titulo;

    // ASSOCIAÇÃO
    private NivelDificuldade dificuldade; // 1 = Fácil, 2 = Médio, 3 = Difícil

    private String descricao;
    private String duracao;
    private boolean finalizada;

    private Date dataFinalizacao;

    // Criar missão com título, dificuldade, descrição e duração
    public Quest(String titulo, NivelDificuldade dificuldade, String descricao, String duracao) {
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
        Date dataAtual =  new Date();
        this.dataFinalizacao = dataAtual;
        this.finalizada = true;
    }

    // Calcular XP com base na dificuldade e duração
    public int calcularXP() {
        int multiplicadorDificuldade = switch (dificuldade) {
            case MEDIO -> 2;
            case DIFICIL -> 3;
            case FACIL -> 1;
        };

        int multiplicadorDuracao = calcularMultiplicadorDuracao();

        return 100 * multiplicadorDificuldade * multiplicadorDuracao;
    }

    protected int calcularMultiplicadorDuracao() {
        return switch (duracao) {
            case "semanal" -> 2;
            case "mensal" -> 3;
            default -> 1; // diária
        };
    }

    // Obter nome da dificuldade
    public String getDificuldadeNome() {
        return dificuldade.getNome();
    }

    // Getters e Setters

    public Date getDataFinalizacao(){
        return this.dataFinalizacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public NivelDificuldade getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(NivelDificuldade dificuldade) {
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

    @Override
    public String toString() {
        return "Quest #" + id + " - " + titulo + " (" + getDificuldadeNome() + ")";
    }

}