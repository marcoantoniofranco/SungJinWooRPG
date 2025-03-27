package Inventario;

public class Items {
    public int itemId;
    public String nomeItem;
    public String descItem;

    /**
     * Construtor da classe Items.
     * 
     * @param itemId ID do item
     * @param nomeItem Nome do item
     * @param descItem Descrição do item
     */
    public Items(int itemId, String nomeItem, String descItem) {
        this.itemId = itemId;
        this.nomeItem = nomeItem;
        this.descItem = descItem;
    }
}
