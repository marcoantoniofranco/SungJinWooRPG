package PlayerEMissao;

import java.util.Date;

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

    public void adicionarQuest(Quest quest) {
        if (quest != null && quantidadeQuests < 10) {
            listaQuests[quantidadeQuests++] = quest;
        }
    }

    public void subirNivel() {
        this.lvl++;
        this.xp = 100;
    }

    public boolean alternarModoOfensivo() {
        return this.ofensiva = !this.ofensiva;
    }
}
