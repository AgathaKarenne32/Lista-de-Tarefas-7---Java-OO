package exercicio6;

import java.math.BigDecimal;

public final class ItemCarrinho {
    private final Produto produto;
    private final int quantidade;

    public ItemCarrinho(Produto produto, int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero.");
        }
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() { return produto; }
    public int getQuantidade() { return quantidade; }

    public BigDecimal getSubtotal() {
        return produto.getPreco().getValor().multiply(new BigDecimal(quantidade));
    }

    @Override
    public String toString() {
        return String.format("%s (x%d) - Subtotal: %s %.2f", produto.getNome(), quantidade, produto.getPreco().getMoeda(), getSubtotal());
    }
}