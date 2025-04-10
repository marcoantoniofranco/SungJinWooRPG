package PlayerEMissao;

import java.util.ArrayList;

/**
 * Classe que representa o jogador no sistema RPG.
 * Contém atributos do personagem, status e gerencia as missões do jogador.
 */
public class Player {
    private String nome;
    private int idade;
    private int xp;
    private int lvl;
    private int mana;
    private int forca;
    private int inteligencia;
    private int constituicao;
    private boolean ofensiva;
    private ArrayList<Quest> listaQuests;

    /**
     * Construtor da classe Player.
     * Inicializa um novo jogador com valores padrão.
     * 
     * @param nome  Nome do jogador
     * @param idade Idade do jogador
     */
    public Player(String nome, int idade) {
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

    public int xpProximoNivel(int lvl){

        if(lvl <= 30){
            return lvl * 150;
        }
        if(lvl > 30 && lvl <= 60){
            return lvl * 140;
        }

        return lvl * 130;

    }

    private void verificarSubirNivel() {
        while (this.xp >= xpProximoNivel(lvl)) {
            subirNivel();
            System.out.println("\nPARABÉNS! Você subiu para o nível " + this.lvl + "!");
        }
    }

    public void subirNivel() {
        xp = xp - xpProximoNivel(lvl);
        lvl++;
    }


//    public double xpProximoNivel(int lvl) {
//        if (lvl < 50) {
//            return lvl * 100;
//        }
//
//        if (lvl >= 50 && lvl < 70) {
//            return lvl * 150;
//        }
//
//        if (lvl >= 70) {
//            return lvl * 200;
//        }
//
//        return 0;
//    }
//
//
//    private void verificarSubirNivel() {
//        while (this.xp >= xpProximoNivel(this.lvl)) {
//            this.lvl++;
//            this.xp -= xpProximoNivel(this.lvl);
//            System.out.println("\n PARABÉNS! Você subiu para o nível " + this.lvl + "! ");
//        }
//    }
//
//
//
//    public void subirNivel() {
//        this.lvl++;
//        this.xp = 100;
//    }

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

    public int getQuantidadeQuests() {
        return listaQuests.size();
    }
}
