package Inventario;

public class Sombras {
    public String nomeSombra;
    public String descSombra;
    public String[] raridade;
    public Items[] itens;
    public int quantidadeItens;

    public Sombras(String nomeSombra, String descSombra) {
        this.nomeSombra = nomeSombra;
        this.descSombra = descSombra;
        this.raridade = new String[] { "Comum", "Raro", "Lendário" };
        this.itens = new Items[5];
        this.quantidadeItens = 0;
    }

    public void adicionarItem(Items item) {
        if (item != null && quantidadeItens < 5) {
            itens[quantidadeItens++] = item;
        }
    }

    public boolean removerItem(int itemId) {
        for (int i = 0; i < quantidadeItens; i++) {
            if (itens[i].itemId == itemId) {
                itens[i] = itens[--quantidadeItens];
                itens[quantidadeItens] = null;
                return true;
            }
        }
        return false;
    }
}
