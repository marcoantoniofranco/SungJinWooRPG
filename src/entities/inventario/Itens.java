package entities.inventario;

public class Itens {
    private int itemId;
    private String nomeItem;
    private String descItem;

    // Criar item com id, nome e descrição
    public Itens(int itemId, String nomeItem, String descItem) {
        this.itemId = itemId;
        this.nomeItem = nomeItem;
        this.descItem = descItem;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
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
}