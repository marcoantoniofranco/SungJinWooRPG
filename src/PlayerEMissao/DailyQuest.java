package PlayerEMissao;

import java.util.Date;

public class DailyQuest extends Quest {
    public boolean foiFeito;
    public Date resetarDaily;

    public DailyQuest(String titulo, int dificuldade, String descricao) {
        super(titulo, dificuldade, descricao, "diária");
        this.foiFeito = false;
        this.resetarDaily = new Date();
    }

    public boolean verificarReset() {
        Date dataAtual = new Date();
        return (dataAtual.getTime() - this.resetarDaily.getTime()) >= 24 * 60 * 60 * 1000;
    }

    public void completar() {
        if (!this.foiFeito) {
            this.foiFeito = true;
            this.resetarDaily = new Date();
        }
    }
}
