package projeto;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import projeto.entities.player.Player;
import projeto.entities.quest.NivelDificuldade;
import projeto.entities.quest.Quest;
import projeto.entities.quest.QuestFactory;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o nome do seu personagem: ");
        String nome = sc.nextLine();
        int idade = 0;

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

        // chama construtor para criar player;
        Player player = new Player(nome, idade);

        System.out.println(player);

        // Loop principal do programa
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n=== Menu Principal ===");
            System.out.println("1 - Criar Nova Missão");
            System.out.println("2 - Ver Status");
            System.out.println("3 - Ver Missões");
            System.out.println("4 - Finalizar Missão");
            System.out.println("5 - Mostrar Quests Feitas");
            System.out.println("6 - Quest para json");
            System.out.println("7 - Serializar player");
            System.out.println("8 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("\n=== Criar Nova Missão ===");

                    System.out.println("Digite o título da missão: ");
                    String titulo = sc.nextLine();

                    System.out.println("Digite a descrição da missão: ");
                    String descricao = sc.nextLine();

                    NivelDificuldade dificuldade = NivelDificuldade.FACIL;

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

                    String tipo = "";

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
                            int duracaoOpcao = sc.nextInt();
                            sc.nextLine(); // consumir quebra de linha
                            switch (duracaoOpcao) {
                                case 1 -> tipo = "diaria";
                                case 2 -> tipo = "semanal";
                                case 3 -> tipo = "mensal";
                                default -> throw new IllegalArgumentException("Opção inválida.");
                            }
                            break;
                        } catch (Exception exception) {
                            System.out.println("\nErro, insira um número válido\n" + exception);
                            sc.nextLine();
                        }
                    }

                    // cria a quest usando o FACTORY
                    Quest novaQuest = QuestFactory.criarQuest(titulo, dificuldade, descricao, tipo);
                    player.adicionarQuest(novaQuest);
                    System.out.println("Missão criada com sucesso!");
                    break;
                case 2:
                    System.out.println(player);
                    break;
                case 3:
                    player.mostrarMissoes(player);
                    break;
                case 4:
                    if (player.getQuantidadeQuests() == 0) {
                        System.out.println("Você não tem missões para finalizar!");
                        break;
                    }
                    player.mostrarMissoes(player);

                    System.out.print("\nDigite o número da missão que deseja finalizar: ");
                    int numeroMissao = sc.nextInt() - 1;


                    player.finalizarMissao(player, numeroMissao);
                    break;
                case 5:
                    player.visualizarQuestsFinalizadas();
                    break;
                case 6:
                    System.out.println("Insira o id da Quest:");
                    int idJson = sc.nextInt();
                    idJson--;

                    player.questParaJson(idJson);
                    break;
                case 7:
                    player.serializarPlayer(player);
                    break;
                case 8:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }

        System.out.println("\nPrograma finalizado!");
        sc.close();
    }
}
