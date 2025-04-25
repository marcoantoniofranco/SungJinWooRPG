package entities.player;

import entities.inventario.Inventario;
import entities.quest.Quest;

import java.util.ArrayList;

/**
 * CLASSE PRINCIPAL.
 * Classe que representa o jogador no sistema RPG.
 * Contém atributos do personagem, status e gerencia as missões do jogador.
 */
public class Player {

    private static int contadorId;
    private int id;

    private String nome;
    private int idade;
    private int xp;
    private int lvl;
    private int mana;
    private int forca;
    private int inteligencia;
    private int constituicao;
    private boolean ofensiva;

    // COMPOSIÇÃO
    private ArrayList<Quest> listaQuests;

    // AGREGAÇÃO
    private Inventario inventario;

    // construtor padrão
    public Player(String nome, int idade) {
        contadorId++;
        id = contadorId;
        this.nome = nome;
        this.idade = idade;
        this.xp = 0;
        this.lvl = 1;
        this.mana = 100;
        this.forca = 0;
        this.inteligencia = 0;
        this.constituicao = 0;
        this.ofensiva = false;
        this.listaQuests = new ArrayList<>();
        this.inventario = new Inventario();
    }

    /**
     * Adiciona uma nova missão à lista de missões do jogador com try-catch-finally.
     * 
     * @param quest Missão a ser adicionada
     */
    public void adicionarQuest(Quest quest) {
        try {
            if (quest == null) {
                throw new IllegalArgumentException("Missão inválida");
            }
            listaQuests.add(quest);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            System.out.println("Operação de missão finalizada");
        }
    }

    /**
     * Adiciona pontos de experiência ao jogador e verifica se subiu de nível.
     * 
     * @param xp Quantidade de XP a ser adicionada
     */
    public void adicionarXP(int xp) {
        this.xp += xp;
        verificarSubirNivel();
    }

    /**
     * Calcula a quantidade de XP necessária para subir de nível.
     * A quantidade aumenta conforme o nível do jogador.
     * 
     * @param lvl Nível atual do jogador
     * @return Quantidade de XP necessária para o próximo nível
     */
    public double xpProximoNivel(int lvl) {
        if (lvl < 30) {
            return lvl * 100;
        }

        if (lvl >= 30 && lvl < 60) {
            return lvl * 120;
        }

        return lvl * 140;
    }

    /**
     * Verifica se o jogador tem XP suficiente para subir de nível.
     * Se tiver, aumenta o nível e ajusta o XP.
     */
    private void verificarSubirNivel() {
        while (this.xp >= xpProximoNivel(lvl)) {
            subirNivel();
            System.out.println("\nPARABÉNS! Você subiu para o nível " + this.lvl + "!");
        }
    }

    /**
     * Aumenta o nível do jogador diretamente e reseta o xp para o xp atual menos o gap para o proximo nivel.
     */
    public void subirNivel() {
        xp = (int) (xp - xpProximoNivel(lvl));
        lvl++;
    }

    /**
     * Alterna o modo ofensivo do jogador entre ativado e desativado.
     * 
     * @return O novo estado do modo ofensivo
     */
    public boolean alternarModoOfensivo() {
        return this.ofensiva = !this.ofensiva;
    }

    /**
     * Remove uma missão da lista de missões do jogador pelo índice.
     * 
     * @param indice Índice da missão a ser removida
     * @return true se a missão foi removida com sucesso, false caso contrário
     */
    public boolean removerQuest(int indice) {
        if (indice < 0 || indice >= listaQuests.size()) {
            return false;
        }

        listaQuests.remove(indice);
        return true;
    }

    // Getters e Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
        verificarSubirNivel();
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public int getConstituicao() {
        return constituicao;
    }

    public void setConstituicao(int constituicao) {
        this.constituicao = constituicao;
    }

    public boolean isOfensiva() {
        return ofensiva;
    }

    public void setOfensiva(boolean ofensiva) {
        this.ofensiva = ofensiva;
    }

    public ArrayList<Quest> getListaQuests() {
        return listaQuests;
    }

    public void setListaQuests(ArrayList<Quest> listaQuests) {
        this.listaQuests = listaQuests;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidadeQuests() {
        return listaQuests.size();
    }

    public String toString(){
        return "\n=== Status do Jogador ==="
                + "\nId: " + id
                + "\nNome: " + nome
                + "\nIdade: " + idade + " anos"
                + "\nNível: " + lvl
                + "\nXP: " + xp + " / " + xpProximoNivel(lvl)
                + "\nMana: " + mana
                + "\nForça: " + forca
                + "\nInteligência: " + inteligencia
                + "\nConstituição: " + constituicao
                + "\nModo Ofensivo: " + (ofensiva ? "Ativado" : "Desativado");
    }
}
