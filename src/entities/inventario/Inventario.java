package entities.inventario;

public class Inventario {
    public int quantidade;
    public String tipoItem;
    public Items[] itens;

    // Criar inventário com tipo e capacidade fixa
    public Inventario(String tipoItem) {
        this.tipoItem = tipoItem;
        this.quantidade = 0;
        this.itens = new Items[20];
    }

    // Adicionar item ao inventário se houver espaço
    public void adicionarItem(Items item) {
        if (item != null && quantidade < 20) {
            itens[quantidade++] = item;
        }
    }

    // Remover item por ID e compactar inventário
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
