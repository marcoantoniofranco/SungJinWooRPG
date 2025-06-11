package projeto.entities.player;

import java.io.Serializable;

public class Inventario implements Serializable {
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

    public int getCapacidadeMax() {
        return capacidadeMax;
    }

    public void setCapacidadeMax(int capacidadeMax) {
        this.capacidadeMax = capacidadeMax;
    }

    public Item[] getItens() {
        return itens;
    }

    public void setItens(Item[] itens) {
        this.itens = itens;
    }

    public int getTotalItens() {
        return totalItens;
    }

    public void setTotalItens(int totalItens) {
        this.totalItens = totalItens;
    }

    public String toString(){
        return "\nCapacidade do inventario: " + capacidadeMax;
    }
}
