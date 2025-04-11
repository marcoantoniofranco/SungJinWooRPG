package entities.inventario;

public class Inventario {
    public int quantidade;
    public String tipoItem;
    public Items[] itens;

    /**
     * Construtor da classe entities.Inventario.
     * 
     * @param tipoItem Tipo de item do inventário
     */
    public Inventario(String tipoItem) {
        this.tipoItem = tipoItem;
        this.quantidade = 0;
        this.itens = new Items[20];
    }

    /**
     * Adiciona um item ao inventário.
     * 
     * @param item Item a ser adicionado
     */
    /**
     * Adiciona um item ao inventário.
     * 
     * @param item Item a ser adicionado
     */
    public void adicionarItem(Items item) {
        if (item != null && quantidade < 20) {
            itens[quantidade++] = item;
        }
    }

    /**
     * Remove um item do inventário.
     * 
     * @param itemId ID do item a ser removido
     * @return true se o item foi removido, false caso contrário
     */
    public boolean removerItem(int itemId) {
        for (int i = 0; i < quantidade; i++) {
            if (itens[i].itemId == itemId) {
                itens[i] = itens[--quantidade];
                itens[quantidade] = null;
                return true;
            }
        }
        return false;
    }
}
