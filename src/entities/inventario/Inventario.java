package entities.inventario;

public class Inventario {
    private int quantidade;

    // AGREGAÇÃO
    private Itens[] itens;

    // Construtor padrão
    public Inventario(){
        this.quantidade = 20;
        this.itens = new Itens[quantidade];
    }

    // Adicionar item ao inventário se houver espaço
    public void adicionarItem(Itens item) {
        if (item != null && quantidade < 20) {
            itens[quantidade++] = item;
        }
    }

    // Remover item por ID e compactar inventário
    public boolean removerItem(int itemId) {
        for (int i = 0; i < quantidade; i++) {
            if (itens[i].getItemId() == itemId) {
                itens[i] = itens[--quantidade];
                itens[quantidade] = null;
                return true;
            }
        }
        return false;
    }
}

