package projeto.entities.player;

import java.io.Serializable;

public class Item implements Serializable {
    private int itemId;
    private String nomeItem;
    private String descItem;

    // Criar item com id, nome e descrição
    public Item(int itemId, String nomeItem, String descItem) {
        this.itemId = itemId;
        this.nomeItem = nomeItem;
        this.descItem = descItem;
    }

    public int getItemId() {
        return itemId;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public String getDescItem() {
        return descItem;
    }

    public void setDescItem(String descItem) {
        this.descItem = descItem;
    }

    @Override
    public String toString() {
        return nomeItem + " - " + descItem;
    }
}