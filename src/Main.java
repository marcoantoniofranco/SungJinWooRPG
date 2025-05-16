import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import entities.player.Player;
import entities.quest.NivelDificuldade;
import entities.quest.Quest;

public class Main {
    private final static Scanner sc = new Scanner(System.in);

    // Inicia o jogo e mostra o menu principal
    public static void main(String[] args) {
        Player player = criarJogador();
        System.out.println(player);

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
                    System.out.println(player);
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

    // Coletar nome e idade para criar Player
    private static Player criarJogador() {
        System.out.println("Digite o nome do seu personagem: ");
        String nome = sc.nextLine();
        int idade = 0;


        // loop para perguntar idade do player, incluindo:
        // try catch para tratar caso o usário insira uma letra
        // if retornando um throw, caso usuário insira um valor menor que zero
        while(true) {
            try {
                System.out.println("Digite a idade do seu personagem: ");
                idade = sc.nextInt();

                if (idade <= 0) {
                    throw new IllegalArgumentException("A idade deve ser maior que zero.");
                }
                break;
            } catch (Exception e) {
                System.out.println("Inisira um número.\n" + e.getMessage());
                sc.nextLine();
            }
        }

        return new Player(nome, idade);
    }

    // Mostrar lista de missões do jogador
    private static void mostrarMissoes(Player player) {
        System.out.println("\n=== Suas Missões ===");
        if (player.getQuantidadeQuests() == 0) {
            System.out.println("Você ainda não tem missões!");
            return;
        }

        for (int i = 0; i < player.getListaQuests().size(); i++) {
            Quest quest = player.getListaQuests().get(i);
            System.out.println(quest.getId() + " - " + quest.getTitulo() +
                    " (XP: " + quest.calcularXP() +
                    ", Dificuldade: " + quest.getDificuldadeNome() +
                    ", Duração: " + quest.getDuracao() + ")");
        }
    }

    // Solicitar dados e adicionar nova missão
    private static void criarMissaoUsuario(Player player) {
        System.out.println("\n=== Criar Nova Missão ===");

        System.out.println("Digite o título da missão: ");
        String titulo = sc.nextLine();

        System.out.println("Digite a descrição da missão: ");
        String descricao = sc.nextLine();

        NivelDificuldade dificuldade = null;

        // loop contendo try catch para tratar caso usuário insira uma letra
        while(true) {
            try {
                System.out.println("Escolha o nível de dificuldade:");
                System.out.println("1 - Fácil");
                System.out.println("2 - Médio");
                System.out.println("3 - Difícil");
                System.out.print("Escolha: ");
                int dificuldadeAux = sc.nextInt();
                dificuldade = NivelDificuldade.intParaValor(dificuldadeAux);
                break;
            } catch (Exception exception) {
                System.out.println("\nErro, Insira um número\n" + exception);
                sc.nextLine();

            }
        }

        int duracaoOpcao = 0;

        // loop contendo:
        // try catch para tratar entradas de letras
        // sai do loop caso usuário digite certo, caso não continua e retorna o erro com throw
        while(true){
            try{
                System.out.println("Escolha a duração da missão:");
                System.out.println("1 - Diária");
                System.out.println("2 - Semanal");
                System.out.println("3 - Mensal");
                System.out.print("Escolha: ");
                duracaoOpcao = sc.nextInt();
                if(duracaoOpcao <= 3){
                    break;
                }
                throw new IllegalArgumentException("Insira a opção correta.");
            } catch (Exception exception) {
                System.out.println("\nErro, Insira um número\n" + exception);
                sc.nextLine();

            }
        }

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

    // Selecionar e finalizar missão
    private static void finalizarMissao(Player player) {
        if (player.getQuantidadeQuests() == 0) {
            System.out.println("Você não tem missões para finalizar!");
            return;
        }

        mostrarMissoes(player);
        System.out.print("\nDigite o número da missão que deseja finalizar: ");
        int numeroMissao = sc.nextInt() - 1;


        if (numeroMissao >= 0 && numeroMissao < player.getListaQuests().size()) {
            Quest quest = player.getListaQuests().get(numeroMissao);
            if (!quest.isFinalizada()) {
                int xpGanho = quest.calcularXP();
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
}
