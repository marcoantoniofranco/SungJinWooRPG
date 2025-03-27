package Inventario;

public class Sombras {
    public String nomeSombra;
    public String descSombra;
    public String[] raridade;
    public Items[] itens;
    public int quantidadeItens;



    /**
     * Construtor da classe Sombras.
     * 
     * @param nomeSombra Nome da sombra
     * @param descSombra Descrição da sombra
     */
    public Sombras(String nomeSombra, String descSombra) {
        this.nomeSombra = nomeSombra;
        this.descSombra = descSombra;
        this.raridade = new String[] { "Comum", "Raro", "Lendário" };
        this.itens = new Items[5];
        this.quantidadeItens = 0;
    }

    /**
     * Adiciona um item ao sombra.
     * 
     * @param item Item a ser adicionado
     */
    public void adicionarItem(Items item) {
        if (item != null && quantidadeItens < 5) {
            itens[quantidadeItens++] = item;
        }
    }

    /**
     * Remove um item do sombra.
     * 
     * @param itemId ID do item a ser removido
     * @return true se o item foi removido, false caso contrário
     */
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
