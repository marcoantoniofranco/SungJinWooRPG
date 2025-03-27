import java.util.Date;
import java.util.Scanner;

import PlayerEMissao.Player;
import PlayerEMissao.Quest;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    /**
     * Método principal do programa.
     * 
     * @param args Argumentos da linha de comando
     */
    public static void main(String[] args) {
        Player player = criarJogador();
        mostrarStatusInicial(player);

        // Loop principal do programa
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n=== Menu Principal ===");
            System.out.println("1 - Criar Nova Missão");
            System.out.println("2 - Ver Status");
            System.out.println("3 - Ver Missões");
            System.out.println("4 - Finalizar Missão");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    criarMissaoUsuario(player);
                    break;
                case 2:
                    mostrarStatusInicial(player);
                    break;
                case 3:
                    mostrarMissoes(player);
                    break;
                case 4:
                    finalizarMissao(player);
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }

        System.out.println("\nPrograma finalizado!");
        sc.close();
    }

    /**
     * Cria um novo jogador.
     * 
     * @return Jogador criado
     */
    private static Player criarJogador() {
        System.out.println("Digite o nome do seu personagem: ");
        String nome = sc.nextLine();

        System.out.println("Digite a idade do seu personagem: ");
        int idadeInt = sc.nextInt();
        Date idade = new Date(idadeInt, 1, 1);

        return new Player(nome, idade);
    }

    /**
     * Exibe o status inicial do jogador.
     * 
     * @param player Jogador
     */
    private static void mostrarStatusInicial(Player player) {
        System.out.println("\n=== Status do Jogador ===");
        System.out.println("Nome: " + player.nome);
        System.out.println("Nível: " + player.lvl);
        System.out.println("XP: " + player.xp);
        System.out.println("Mana: " + player.mana);
        System.out.println("Força: " + player.forca);
        System.out.println("Inteligência: " + player.inteligencia);
        System.out.println("Constituição: " + player.constituicao);
        System.out.println("Modo Ofensivo: " + (player.ofensiva ? "Ativado" : "Desativado"));
    }

    /**
     * Exibe as missões do jogador.
     * 
     * @param player Jogador
     */
    private static void mostrarMissoes(Player player) {
        System.out.println("\n=== Suas Missões ===");
        if (player.quantidadeQuests == 0) {
            System.out.println("Você ainda não tem missões!");
            return;
        }
        for (int i = 0; i < player.quantidadeQuests; i++) {
            Quest quest = player.listaQuests[i];
            System.out.println((i + 1) + " - " + quest.titulo +
                    " (XP: " + quest.calcularXP() +
                    ", Dificuldade: " + quest.getDificuldadeNome() +
                    ", Duração: " + quest.duracao + ")");
        }
    }

    /**
     * Cria uma nova missão para o jogador.
     * 
     * @param player Jogador
     */
    private static void criarMissaoUsuario(Player player) {
        System.out.println("\n=== Criar Nova Missão ===");

        System.out.println("Digite o título da missão: ");
        String titulo = sc.nextLine();

        System.out.println("Digite a descrição da missão: ");
        String descricao = sc.nextLine();

        System.out.println("Escolha o nível de dificuldade:");
        System.out.println("1 - Fácil");
        System.out.println("2 - Médio");
        System.out.println("3 - Difícil");
        System.out.print("Escolha: ");
        int dificuldade = sc.nextInt();

        System.out.println("Escolha a duração da missão:");
        System.out.println("1 - Diária");
        System.out.println("2 - Semanal");
        System.out.println("3 - Mensal");
        System.out.print("Escolha: ");
        int duracaoOpcao = sc.nextInt();
        String duracao;

        switch (duracaoOpcao) {
            case 1:
                duracao = "diária";
                break;
            case 2:
                duracao = "semanal";
                break;
            case 3:
                duracao = "mensal";
                break;
            default:
                duracao = "diária";
        }

        Quest novaQuest = new Quest(titulo, dificuldade, descricao, duracao);
        player.adicionarQuest(novaQuest);
        System.out.println("Missão " + duracao + " criada com sucesso!");
    }

    /**
     * Finaliza uma missão do jogador.
     * 
     * @param player Jogador
     */
    private static void finalizarMissao(Player player) {
        if (player.quantidadeQuests == 0) {
            System.out.println("Você não tem missões para finalizar!");
            return;
        }

        mostrarMissoes(player);
        System.out.print("\nDigite o número da missão que deseja finalizar: ");
        int numeroMissao = sc.nextInt() - 1;

        if (numeroMissao >= 0 && numeroMissao < player.quantidadeQuests) {
            Quest quest = player.listaQuests[numeroMissao];
            if (!quest.finalizada) {
                int xpGanho = quest.calcularXP();
                quest.finalizar();
                player.adicionarXP(xpGanho);
                System.out.println("Missão finalizada! Você ganhou " + xpGanho + " XP!");
            } else {
                System.out.println("Esta missão já foi finalizada!");
            }
        } else {
            System.out.println("Número de missão inválido!");
        }
    }
}
