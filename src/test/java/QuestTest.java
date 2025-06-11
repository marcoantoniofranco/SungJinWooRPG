import org.junit.jupiter.api.Test;
import projeto.entities.player.Player;
import projeto.entities.quest.NivelDificuldade;
import projeto.entities.quest.Quest;
import projeto.entities.quest.QuestFactory;

public class QuestTest {

    @Test
    void criarMissao(){
        Quest quest = QuestFactory.criarQuest("titulo teste", NivelDificuldade.MEDIO, "descricao teste", "mensal");

        System.out.println(quest);
    }

    @Test
    void criarEFinalizar(){
        Player player = new Player("nome",10 );

        Quest quest = QuestFactory.criarQuest("titulo", NivelDificuldade.FACIL, "descricao", "mensal");

        System.out.println(quest.getClass());

        System.out.println(quest.getEstrategiaXp().calcularXP());

        player.adicionarQuest(quest);

        player.finalizarMissao(player, 0);

    }
}
