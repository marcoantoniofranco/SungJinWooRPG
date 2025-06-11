package projeto.entities.quest;

import java.util.Date;

// Missão diária com reset após 24h
public class QuestDiaria extends Quest {
    public boolean foiFeito;
    public Date resetarDaily;

    // Criar missão diária com nome, dificuldade e descrição
    public QuestDiaria(String titulo, NivelDificuldade dificuldade, String descricao, EstrategiaXp estrategiaXp) {
        super(titulo, dificuldade, descricao, estrategiaXp);
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


    // método calcularXP herdado, para que missoes do tipo QuestDiaria recebam menos xp
    // POLIMORFISMO aplicado
    @Override
    public int calcularXP() {
        return estrategiaXp.calcularXP();
    }


    // uma quest diária sempre tem multiplicador 1
    // POLIMORFISMO aplicado
    @Override
    protected int calcularMultiplicadorDuracao() {
        return 1;
    }
}
