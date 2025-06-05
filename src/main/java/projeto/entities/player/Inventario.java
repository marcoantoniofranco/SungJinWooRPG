package projeto.entities.player;

public class Inventario {
    private int capacidadeMax;
    private int totalItens;

    // AGREGAÇÃO
    private Item[] itens;

    // Construtor padrão
    public Inventario(){
        this.capacidadeMax = 20;
        this.totalItens = 0;
        this.itens = new Item[capacidadeMax];
    }

    // Adicionar item ao inventário se houver espaço
    public void adicionarItem(Item item) {
        if (item != null && totalItens < capacidadeMax) {
            itens[totalItens++] = item;
            System.out.println("item adicionado.");
        }
        if(totalItens >= capacidadeMax){
            System.out.println("inventario cheio.");
        }

    }

    // Remover item por ID
    public void removerItem(int itemId) {
        for (int i = 0; i < totalItens; i++) {
            if (itens[i].getItemId() == itemId) {
                itens[i] = null;
            }
        }
    }
}
