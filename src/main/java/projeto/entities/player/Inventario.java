package projeto.entities.player;

import java.io.Serializable;
import java.util.ArrayList;

public class Inventario implements Serializable {
    private int capacidadeMax;
    private int totalItens;

    // COLEÇÃO E AGREGAÇÃO
    private ArrayList<Item> itens;

    // Construtor padrão
    public Inventario(){
        this.capacidadeMax = 20;
        this.totalItens = 0;
        this.itens = new ArrayList<Item>();
    }

    // Adicionar item ao inventário se houver espaço
    public void adicionarItem(Item item) {
        if (item != null && totalItens < capacidadeMax) {
            itens.add(item);
            totalItens++;
            System.out.println("item adicionado.");
        }
        if(totalItens >= capacidadeMax){
            System.out.println("inventario cheio.");
        }

    }

    // Remover item por ID
    public void removerItem(int itemId) {
        Item item = null;
        for (int i = 0; i < totalItens; i++) {
            item = itens.get(i);
            if (item.getItemId() == itemId) {
                itens.remove(item);
            }
        }
    }

    public int getCapacidadeMax() {
        return capacidadeMax;
    }

    public void setCapacidadeMax(int capacidadeMax) {
        this.capacidadeMax = capacidadeMax;
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Item> itens) {
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
