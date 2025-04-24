package entities.quest;

import java.util.Date;

// Missão diária com reset após 24h
public class DailyQuest extends Quest {
    public boolean foiFeito;
    public Date resetarDaily;

    // Criar missão diária com nome, dificuldade e descrição
    public DailyQuest(String titulo, int dificuldade, String descricao) {
        super(titulo, dificuldade, descricao, "diária");
        this.foiFeito = false;
        this.resetarDaily = new Date();
    }

    // Checar se pode resetar missão diária
    public boolean verificarReset() {
        Date dataAtual = new Date();
        return (dataAtual.getTime() - this.resetarDaily.getTime()) >= 24 * 60 * 60 * 1000;
    }

    // Marcar missão diária como feita e resetar data
    public void completar() {
        if (!this.foiFeito) {
            this.foiFeito = true;
            this.resetarDaily = new Date();
        }
    }

    @Override
    public int calcularXP() {
        int xpBase = super.calcularXP();
        return xpBase + 20;
    }
}
