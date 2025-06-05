package projeto.entities.quest;

import java.util.Date;

public class QuestMensal extends Quest {

    private boolean foiFeito;
    private Date resetarQuest;


    public QuestMensal(String titulo, NivelDificuldade dificuldade, String descricao) {
        super(titulo, dificuldade, descricao, "mensal");
        this.foiFeito = false;
        this.resetarQuest = new Date();
    }

    // método calcularXP herdado, para que missoes do tipo QuestDiaria recebam menos xp
    // POLIMORFISMO aplicado
    @Override
    public int calcularXP() {
        int xpBase = super.calcularXP();
        return xpBase * 2;
    }

    // uma quest diária sempre tem multiplicador 1
    // POLIMORFISMO aplicado
    @Override
    protected int calcularMultiplicadorDuracao() {
        return 3;
    }
}
