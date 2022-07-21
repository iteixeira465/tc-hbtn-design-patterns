import java.util.HashSet;
import java.util.Objects;

public class Pedido {

    private HashSet<ItemPedido> itensDentroCaixa = new HashSet<>();
    private HashSet<ItemPedido> itensForaCaixa = new HashSet<>();

    public Pedido() {
    }

    public Pedido(HashSet<ItemPedido> itensDentroCaixa, HashSet<ItemPedido> itensForaCaixa) {
        setItensDentroCaixa(itensDentroCaixa);
        setItensForaCaixa(itensForaCaixa);
    }

    public HashSet<ItemPedido> getItensDentroCaixa() {
        return itensDentroCaixa;
    }

    public void setItensDentroCaixa(HashSet<ItemPedido> itensDentroCaixa) {
        this.itensDentroCaixa = itensDentroCaixa;
    }

    public HashSet<ItemPedido> getItensForaCaixa() {
        return itensForaCaixa;
    }

    public void setItensForaCaixa(HashSet<ItemPedido> itensForaCaixa) {
        this.itensForaCaixa = itensForaCaixa;
    }

    public void adicionarItemDentroCaixa(ItemPedido item) {
        getItensDentroCaixa().add(item);
    }

    public void adicionarItemForaCaixa(ItemPedido item) {
        getItensForaCaixa().add(item);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(itensDentroCaixa, pedido.itensDentroCaixa) && Objects.equals(itensForaCaixa, pedido.itensForaCaixa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itensDentroCaixa, itensForaCaixa);
    }

    @Override
    public String toString() {
        StringBuilder itensForaDaCaixa = new StringBuilder("\tFora da Caixa:\n");
        StringBuilder itensDentroDaCaixa = new StringBuilder("\tDentro da Caixa:\n");

        getItensForaCaixa().stream().sorted(new ItemPedido()).forEach(itemPedido -> itensForaDaCaixa.append(String.format("\t\t- %s %s\n", itemPedido.getTipo(), itemPedido.getNome())));
        getItensDentroCaixa().stream().sorted(new ItemPedido()).forEach(itemPedido -> itensDentroDaCaixa.append(String.format("\t\t- %s %s\n", itemPedido.getTipo(), itemPedido.getNome())));

        return itensForaDaCaixa + itensDentroDaCaixa.toString();
    }

}