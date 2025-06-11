import org.junit.jupiter.api.Test;
import projeto.entities.player.Player;
import projeto.entities.quest.NivelDificuldade;
import projeto.entities.quest.Quest;
import projeto.entities.quest.QuestFactory;
import projeto.entities.quest.calculoXp.XpMensal;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class SerialPlayerTest {

    @Test
    public void serializarPlayer() {
        Player player = new Player("teste", 20);
        Quest quest = QuestFactory.criarQuest("titulo teste", NivelDificuldade.FACIL, "descricao teste", "mensal");
        player.adicionarQuest(quest);
        player.finalizarMissao(player, 0);
        boolean teste = false;

        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("player.ser"))) {
            output.writeObject(player);
            System.out.println();
            System.out.println("player serializado");
            teste = true;
        } catch (Exception ex) {
            System.out.println("erro ao serializar: " + ex.getMessage());
        }

        assertTrue(teste);
    }

    @Test
    public void desserializarPlayer(){
        Player player = new Player("teste", 20);
        Quest quest = QuestFactory.criarQuest("titulo teste", NivelDificuldade.FACIL, "descricao teste", "diaria");

        player.adicionarQuest(quest);
        player.finalizarMissao(player, 0);
        boolean teste = false;

        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("player.ser"))) {
            output.writeObject(player);

            System.out.println(output.getClass());

            System.out.println();
            System.out.println("player serializado");
            teste = true;
        } catch (Exception ex) {
            System.out.println("erro ao serializar: " + ex.getMessage());
        }

        boolean testeDes = false;
        Player playerDesserializado = null;
        try(ObjectInputStream input = new ObjectInputStream(new FileInputStream("player.ser"))){
            playerDesserializado = (Player)input.readObject();
            System.out.println();
            System.out.println(playerDesserializado);
            testeDes = true;
        }catch (Exception ex) {
            System.out.println("erro ao desserializar: " + ex.getMessage());
        }

        assertEquals(player.getNome(), playerDesserializado.getNome());
        assertTrue(teste);
        assertTrue(testeDes);


    }
}
