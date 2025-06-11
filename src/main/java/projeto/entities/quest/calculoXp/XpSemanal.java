package projeto.entities.quest.calculoXp;

import projeto.entities.quest.EstrategiaXp;

import java.io.Serializable;

public class XpSemanal implements EstrategiaXp, Serializable {
    public int calcularXP() {

        return 100 * 3;
    }

    public String toString(){
        return "semanal";
    }
}