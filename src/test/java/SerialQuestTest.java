import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Test;
import projeto.entities.quest.NivelDificuldade;
import projeto.entities.quest.Quest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SerialQuestTest {

    @Test
    void QuestParaJson() {
        Quest quest = new Quest("Corrida", NivelDificuldade.DIFICIL, "Correr de 5 a 10 km", "diaria");

        quest.finalizar();

        Gson gson = new GsonBuilder().create();

        String json = gson.toJson(quest);

        System.out.println(json);

        assertTrue(json.contains("Corrida"));
        assertTrue(json.contains("DIFICIL"));
    }

    @Test
    void JsonParaQuest() {
        String json = """
        {
            "id": 1,
            "titulo": "Corrida",
            "dificuldade": "DIFICIL",
            "descricao": "Correr de 5 a 10 km",
            "duracao": "diária",
            "finalizada": false,
            "dataFinalizacao": null
        }
        """;

        Gson gson = new GsonBuilder().create();

        Quest quest = gson.fromJson(json, Quest.class);

        assertTrue(quest.getTitulo().equals("Corrida"));
        assertTrue(quest.getDificuldade() == NivelDificuldade.DIFICIL);
        System.out.println("objeto Quest criado: " + quest);
    }



}
