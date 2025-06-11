package projeto.entities.quest.calculoXp;

import projeto.entities.quest.EstrategiaXp;

import java.io.Serializable;

public class XpDiaria implements EstrategiaXp, Serializable {
    public int calcularXP() {
        return 100 * 2;
    }

    public String toString(){
        return "diaria";
    }
}