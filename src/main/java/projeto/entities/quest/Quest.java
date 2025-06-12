package projeto.entities.quest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import projeto.entities.player.Player;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.Instant;
import java.util.*;

//super classe das quests
public class Quest implements Serializable {
    protected static int contadorId;
    protected int id;
    protected String titulo;

    // ASSOCIAÇÃO
    protected NivelDificuldade dificuldade; // 1 = Fácil, 2 = Médio, 3 = Difícil

    protected String descricao;
    protected String duracao;
    protected boolean finalizada;

    protected Date dataFinalizacao;

    // AGREGAÇÃO 
    protected EstrategiaXp estrategiaXp;

    protected int questXp;

    // Criar missão com título, dificuldade, descrição e duração
    public Quest(String titulo, NivelDificuldade dificuldade, String descricao, EstrategiaXp extrategiaXp) {
        contadorId++;
        id = contadorId;
        this.titulo = titulo;
        this.dificuldade = dificuldade;
        this.descricao = descricao;
        this.estrategiaXp = extrategiaXp;
        this.duracao = extrategiaXp.toString();
        this.finalizada = false;
        this.questXp = extrategiaXp.calcularXP() * dificuldade.getValor();
    }

    public Quest() {
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

    public EstrategiaXp getEstrategiaXp() {
        return estrategiaXp;
    }

    public void setEstrategiaXp(EstrategiaXp estrategiaXp) {
        this.estrategiaXp = estrategiaXp;
    }

    @Override
    public String toString() {
        return "Quest #"
                + id
                + " - " + titulo + " (" + getDificuldadeNome()
                + ")"
                + " - xp quest: " + (dificuldade.getValor() * estrategiaXp.calcularXP());
    }

}