package entities.quest;

import java.util.Date;

public class WeeklyQuest extends Quest {

    private boolean foiFeito;
    private Date resetarQuest;

    public WeeklyQuest(String titulo, NivelDificuldade dificuldade, String descricao) {
        super(titulo, dificuldade, descricao, "semanal");
        this.foiFeito = false;
        this.resetarQuest = new Date();
    }

    // método calcularXP herdado, para que missoes do tipo DailyQuest recebam menos xp
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
        return 2;
    }
}
