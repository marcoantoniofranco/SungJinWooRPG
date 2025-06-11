package projeto.entities.quest;

import projeto.entities.quest.calculoXp.XpDiaria;
import projeto.entities.quest.calculoXp.XpMensal;
import projeto.entities.quest.calculoXp.XpSemanal;

//DESIGN PATTERN: METHOD FACTORY
public class QuestFactory {
    public static Quest criarQuest(String titulo, NivelDificuldade dificuldade, String descricao, String tipo) {
        return switch (tipo.toLowerCase()) {
            case "diaria" -> new QuestDiaria(titulo, dificuldade, descricao, new XpDiaria());
            case "semanal" -> new QuestSemanal(titulo, dificuldade, descricao, new XpSemanal());
            case "mensal" -> new QuestMensal(titulo, dificuldade, descricao, new XpMensal());
            default -> throw new IllegalArgumentException("Tipo de quest inválido");
        };
    }
}
