package projeto.entities.quest.calculoXp;

import projeto.entities.quest.EstrategiaXp;

import java.io.Serializable;

public class XpMensal implements EstrategiaXp, Serializable {
    public int calcularXP() {
        return 100 * 4;
    }

    public String toString(){
        return "mensal";
    }
}