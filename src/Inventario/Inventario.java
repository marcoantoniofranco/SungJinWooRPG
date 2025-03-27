package Inventario;

public class Inventario {
    public int quantidade;
    public String tipoItem;
    public Items[] itens;

    public Inventario(String tipoItem) {
        this.tipoItem = tipoItem;
        this.quantidade = 0;
        this.itens = new Items[20];
    }

    public void adicionarItem(Items item) {
        if (item != null && quantidade < 20) {
            itens[quantidade++] = item;
        }
    }

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
