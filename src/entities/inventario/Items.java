package entities.inventario;

public class Items {
    public int itemId;
    public String nomeItem;
    public String descItem;

    // Criar item com id, nome e descrição
    public Items(int itemId, String nomeItem, String descItem) {
        this.itemId = itemId;
        this.nomeItem = nomeItem;
        this.descItem = descItem;
    }
}
