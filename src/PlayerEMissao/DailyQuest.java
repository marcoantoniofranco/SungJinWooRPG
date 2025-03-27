package PlayerEMissao;

import java.util.Date;
public class DailyQuest extends Quest {
    public boolean foiFeito;
    public Date resetarDaily;

    /**
     * Construtor da classe DailyQuest.
     * Inicializa uma missão diária com valores padrão.
     * 
     * @param titulo Título da missão
     * @param dificuldade Dificuldade da missão
     * @param descricao Descrição da missão
     */
    public DailyQuest(String titulo, int dificuldade, String descricao) {
        super(titulo, dificuldade, descricao, "diária");
        this.foiFeito = false;
        this.resetarDaily = new Date();
    }

    /**
     * Verifica se a missão diária pode ser resetada.
     * 
     * @return true se a missão pode ser resetada, false caso contrário
     */
    public boolean verificarReset() {
        Date dataAtual = new Date();
        return (dataAtual.getTime() - this.resetarDaily.getTime()) >= 24 * 60 * 60 * 1000;
    }

    /**
     * Marca a missão como concluída e reseta a data de reset.
     * 
     * @return true se a missão foi concluída, false caso contrário
     */
    public void completar() {
        if (!this.foiFeito) {
            this.foiFeito = true;
            this.resetarDaily = new Date();
        }
    }
}
