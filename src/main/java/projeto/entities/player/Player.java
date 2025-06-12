package projeto.entities.player;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import projeto.entities.quest.NivelDificuldade;
import projeto.entities.quest.Quest;
import projeto.entities.quest.QuestFactory;

import java.io.*;
import java.util.*;

public class Player implements Serializable {

    private static final long serialUID = 1L;

    private static int contadorId;
    private final int id;

    private String nome;
    private int idade;
    private int xp;
    private int lvl;
    private int mana;
    private int forca;
    private int inteligencia;
    private int constituicao;
    private boolean ofensiva;

    // COMPOSIÇÃO E COLEÇÃO USANDO ARRAYLIST
    private ArrayList<Quest> listaQuests;

    // COMPOSIÇÃO
    private final Inventario inventario;

    // COLEÇÃO USANDO MAP E INSTANCIANDO HASHMAP
    private final Map<Quest, Date> questsFinalizadas;

    // construtor padrão
    public Player(String nome, int idade) {
        contadorId++;
        id = contadorId;
        this.nome = nome;
        this.idade = idade;
        this.xp = 0;
        this.lvl = 1;
        this.mana = 100;
        this.forca = 0;
        this.inteligencia = 0;
        this.constituicao = 0;
        this.ofensiva = false;
        this.listaQuests = new ArrayList<>();
        this.inventario = new Inventario();
        this.questsFinalizadas =  new HashMap<Quest, Date>();
    }

    // adiciona nova quest à listaQuest
    public void adicionarQuest(Quest quest) {
        try {
            if (quest == null) {
                throw new IllegalArgumentException("Missão inválida");
            }
            listaQuests.add(quest);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            System.out.println("Operação de missão finalizada");
        }
    }

    // cria missao com dados inputados utilizando um construtor ao final
    public void criarMissaoUsuario(String titulo, String descricao, NivelDificuldade dificuldade, int duracaoOpcao, Player player) {
        String duracao;

        switch (duracaoOpcao) {
            case 1:
                duracao = "diaria";
                break;
            case 2:
                duracao = "semanal";
                break;
            case 3:
                duracao = "mensal";
                break;
            default:
                duracao = "diaria";
        }

        Quest novaQuest = QuestFactory.criarQuest(titulo, dificuldade, descricao, duracao);
        player.adicionarQuest(novaQuest);
        System.out.println("Missão " + duracao + " criada com sucesso!");
    }


    // finaliza a quest com base no indice da quest, ao final adiciona ao historico
    public void finalizarMissao(Player player, int numeroMissao) {

        if (numeroMissao >= 0 && numeroMissao < player.getListaQuests().size()) {
            Quest quest = player.getListaQuests().get(numeroMissao);
            if (!quest.isFinalizada()) {
                int xpGanho = quest.getEstrategiaXp().calcularXP() * quest.getDificuldade().getValor();
                quest.finalizar();
                player.adicionarXP(xpGanho);
                System.out.println("Missão finalizada! Você ganhou " + xpGanho + " XP!");
                System.out.println("XP atual: " + player.getXp() + " / " + (int) player.xpProximoNivel(player.getLvl()));
                player.addQuestAoHistorico(quest, player);
            } else {
                System.out.println("Esta missão já foi finalizada!");
            }
        } else {
            System.out.println("Número de missão inválido!");
        }
    }

    // faz um for percorrendo a listaQuests do player
    public void mostrarMissoes(Player player) {
        System.out.println("\n=== Suas Missões ===");

        for (int i = 0; i < player.getListaQuests().size(); i++) {
            Quest quest = player.getListaQuests().get(i);
            if(!quest.isFinalizada()) {
                System.out.println(quest.getId() + " - " + quest.getTitulo() +
                        " (XP: " + quest.getEstrategiaXp().calcularXP() +
                        ", Dificuldade: " + quest.getDificuldadeNome() +
                        ", Duração: " + quest.getDuracao() + ")");
            }
        }
    }

    //Adiciona xp ao Player e verifica se subiu de nivel
    public void adicionarXP(int xp) {
        this.xp += xp;
        verificarSubirNivel();
    }

    //Calcula a quantidade de XP necessária para subir de nível.
    //A quantidade aumenta conforme o nível do jogador.
    public double xpProximoNivel(int lvl) {
        if (lvl < 30) {
            return lvl * 100;
        }

        if (lvl >= 30 && lvl < 60) {
            return lvl * 120;
        }

        return lvl * 140;
    }


    //verifica se pode subir de nivel e chama funcao para upar
    private void verificarSubirNivel() {
        if(this.xp >= xpProximoNivel(lvl)) {
            subirNivel();
            System.out.println("\nPARABÉNS! Você subiu para o nível " + this.lvl + "!");
        }
    }

    // sobe de nivel, reseta o xp e chama funcao para aumentar inventario
    private void subirNivel() {
        xp = (int) (xp - xpProximoNivel(lvl));
        lvl++;
        aumentarCapInventario(this.inventario);
    }


    public boolean alternarModoOfensivo() {
        return this.ofensiva = !this.ofensiva;
    }

    // remove quest utilizando indice, verifica antes se é possivel
    public boolean removerQuest(int indice) {
        if (indice < 0 || indice >= listaQuests.size()) {
            return false;
        }

        listaQuests.remove(indice);
        return true;
    }

    public void addQuestAoHistorico(Quest questFinalizada, Player player){
        this.questsFinalizadas.put(questFinalizada, questFinalizada.getDataFinalizacao());
    }

    public void visualizarQuestsFinalizadas(){
        System.out.println(questsFinalizadas);

    }

    public void aumentarCapInventario(Inventario inventario){
        inventario.setCapacidadeMax(inventario.getCapacidadeMax() + 1);
    }

    //função para serializar quest (para json):
    public String questParaJson(int id){

        Quest quest = this.listaQuests.get(id);

        quest.finalizar();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String json = gson.toJson(quest);

        System.out.println(json);

        return json;
    }


    // função para serializar o player
    public void serializarPlayer(Player player){

        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("player-serial.ser"))) {
            output.writeObject(player);
            System.out.println();
            System.out.println("player serializado");

        } catch (Exception ex) {
            System.out.println("erro ao serializar: " + ex.getMessage());
        }
    }

    // função para deserializar o player
    public Player desserializarPlayer() {
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("player-serial.ser"))) {
            System.out.println();
            System.out.println("Player desserializado!");
            return (Player) input.readObject();
        } catch (Exception ex) {
            System.out.println("erro ao desserializar: " + ex.getMessage());
            return null;
        }
    }

    // Getters e Setters

    public Map<Quest, Date> getQuestsFinalizadas(){
        return this.questsFinalizadas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        if(xp < 0){
            xp = 0;
        }
        this.xp = xp;
        verificarSubirNivel();
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public int getConstituicao() {
        return constituicao;
    }

    public void setConstituicao(int constituicao) {
        this.constituicao = constituicao;
    }

    public boolean isOfensiva() {
        return ofensiva;
    }

    public void setOfensiva(boolean ofensiva) {
        this.ofensiva = ofensiva;
    }

    public ArrayList<Quest> getListaQuests() {
        return listaQuests;
    }

    public void setListaQuests(ArrayList<Quest> listaQuests) {
        this.listaQuests = listaQuests;
    }

    public int getId() {
        return id;
    }

    public int getQuantidadeQuests() {
        return listaQuests.size();
    }

    public String toString(){
        return "\n=== Status do Jogador ==="
                + "\nId: " + id
                + "\nNome: " + nome
                + "\nIdade: " + idade + " anos"
                + "\nNível: " + lvl
                + "\nXP: " + xp + " / " + xpProximoNivel(lvl)
                + "\nMana: " + mana
                + "\nForça: " + forca
                + "\nInteligência: " + inteligencia
                + "\nConstituição: " + constituicao
                + "\nModo Ofensivo: " + (ofensiva ? "Ativado" : "Desativado")
                + "\nCapacidade Inventario: " + inventario.getCapacidadeMax();

    }
}
