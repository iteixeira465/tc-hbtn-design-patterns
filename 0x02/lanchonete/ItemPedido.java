import java.util.Comparator;

public class ItemPedido implements Comparator<ItemPedido> {

    private TipoItemPedido tipo;
    private String nome;

    public ItemPedido() {
    }

    public ItemPedido(TipoItemPedido tipo, String nome) {
        setTipo(tipo);
        setNome(nome);
    }

    public TipoItemPedido getTipo() {
        return tipo;
    }

    public void setTipo(TipoItemPedido tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int compare(ItemPedido t1, ItemPedido t2) {
        return Integer.compare(getValue(t1.getTipo()), getValue(t2.getTipo()));
    }

    int getValue(TipoItemPedido tipo) {
        switch (tipo) {
            case BEBIDA:
                return 0;
            case BRINDE:
                return 1;
            case BATATA:
                return 2;
            case LANCHE:
                return 3;
            default:
                return Integer.MAX_VALUE;
        }
    }

}