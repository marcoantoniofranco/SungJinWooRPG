package projeto.entities.quest;

import java.util.Date;

public class QuestMensal extends Quest {

    private boolean foiFeito;
    private Date resetarQuest;


    public QuestMensal(String titulo, NivelDificuldade dificuldade, String descricao, EstrategiaXp estrategiaXp) {
        super(titulo, dificuldade, descricao, estrategiaXp);
        this.foiFeito = false;
        this.resetarQuest = new Date();
    }

    // método calcularXP herdado, para que missoes do tipo QuestDiaria recebam menos xp
    // POLIMORFISMO aplicado
    @Override
    public int calcularXP() {
        return estrategiaXp.calcularXP();
    }

}
