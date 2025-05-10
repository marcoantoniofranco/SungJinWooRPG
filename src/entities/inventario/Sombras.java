package entities.inventario;

// Container de sombras
public class Sombras {
    private String nomeSombra;
    private String descSombra;
    private String[] raridade;
    private int quantidadeItens;

    // ASSOCIAÇÃO
    private Itens[] itens;

    // Criar sombra com nome e descrição
    public Sombras(String nomeSombra, String descSombra) {
        this.nomeSombra = nomeSombra;
        this.descSombra = descSombra;
        this.raridade = new String[] { "Comum", "Raro", "Lendário" };
        this.itens = new Itens[5];
        this.quantidadeItens = 0;
    }

    // Adicionar item à sombra
    public void adicionarItem(Itens item) {
        if (item != null && quantidadeItens < 5) {
            itens[quantidadeItens++] = item;
        }
    }

    // Remover item da sombra por ID
    public boolean removerItem(int itemId) {
        for (int i = 0; i < quantidadeItens; i++) {
            if (itens[i].getItemId() == itemId) {
                itens[i] = itens[--quantidadeItens];
                itens[quantidadeItens] = null;
                return true;
            }
        }
        return false;
    }
}
