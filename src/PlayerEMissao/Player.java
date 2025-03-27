package PlayerEMissao;

import java.util.Date;

/**
 * Classe que representa o jogador no sistema RPG.
 * Contém atributos do personagem, status e gerencia as missões do jogador.
 */
public class Player {
    public String nome;
    public Date idade;
    public int xp;
    public int lvl;
    public int mana;
    public int forca;
    public int inteligencia;
    public int constituicao;
    public boolean ofensiva;
    public Quest[] listaQuests;
    public int quantidadeQuests;

    /**
     * Construtor da classe Player.
     * Inicializa um novo jogador com valores padrão.
     * 
     * @param nome Nome do jogador
     * @param idade Idade do jogador
     */
    public Player(String nome, Date idade) {
        this.nome = nome;
        this.idade = idade;
        this.xp = 100;
        this.lvl = 1;
        this.mana = 100;
        this.forca = 0;
        this.inteligencia = 0;
        this.constituicao = 0;
        this.ofensiva = false;
        this.listaQuests = new Quest[10];
        this.quantidadeQuests = 0;
    }

    /**
     * Adiciona uma nova missão à lista de missões do jogador.
     * Verifica se a missão é válida e se há espaço disponível.
     * 
     * @param quest Missão a ser adicionada
     */
    public void adicionarQuest(Quest quest) {
        if (quest != null && quantidadeQuests < 10) {
            listaQuests[quantidadeQuests++] = quest;
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
    public double nivelGap(int lvl){
        if(lvl < 50){
            return lvl * 100;
        }

        if(lvl >= 50 && lvl < 70){
            return lvl * 150; 
        }

        if(lvl >= 70){
            return lvl * 200;
        }

        return 0;
    }

    /**
     * Verifica se o jogador tem XP suficiente para subir de nível.
     * Se tiver, aumenta o nível e ajusta o XP.
     */
    private void verificarSubirNivel() {
        while (this.xp >= nivelGap(this.lvl)) {
            this.lvl++;
            this.xp -= nivelGap(this.lvl);
            System.out.println("\n PARABÉNS! Você subiu para o nível " + this.lvl + "! ");
        }
    }

    /**
     * Aumenta o nível do jogador diretamente e reseta o XP para 100.
     */
    public void subirNivel() {
        this.lvl++;
        this.xp = 100;
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
        if (indice < 0 || indice >= quantidadeQuests) {
            return false;
        }
        
        // Desloca todas as missões após o índice removido
        for (int i = indice; i < quantidadeQuests - 1; i++) {
            listaQuests[i] = listaQuests[i + 1];
        }
        
        // Limpa a última posição e decrementa a quantidade
        listaQuests[quantidadeQuests - 1] = null;
        quantidadeQuests--;
        
        return true;
    }
}
