package exercicio6;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class Carrinho {
    private final List<ItemCarrinho> itens;

    // Construtor padrão para um carrinho vazio
    public Carrinho() {
        this.itens = Collections.emptyList();
    }

    // Construtor privado para uso interno, que recebe a nova lista de itens
    private Carrinho(List<ItemCarrinho> itens) {
        // Cria uma cópia defensiva e torna a lista imutável
        this.itens = Collections.unmodifiableList(new ArrayList<>(itens));
    }

    public List<ItemCarrinho> getItens() {
        return itens;
    }

    public Carrinho adicionarItem(Produto produto, int quantidade) {
        List<ItemCarrinho> novosItens = new ArrayList<>(this.itens);
        novosItens.add(new ItemCarrinho(produto, quantidade));
        // Retorna uma NOVA instância do carrinho com a lista atualizada
        return new Carrinho(novosItens);
    }

    public Carrinho removerItem(Produto produtoParaRemover) {
        List<ItemCarrinho> novosItens = this.itens.stream()
                .filter(item -> !item.getProduto().equals(produtoParaRemover))
                .collect(Collectors.toList());

        // Retorna um NOVO carrinho apenas com os itens que não foram removidos
        return new Carrinho(novosItens);
    }

    public Carrinho aplicarCupomDeDesconto(BigDecimal percentual) {
        if (percentual.compareTo(BigDecimal.ZERO) < 0 || percentual.compareTo(new BigDecimal("0.3")) > 0) {
            throw new IllegalArgumentException("Cupom de desconto deve ser entre 0% e 30%.");
        }

        BigDecimal fatorDesconto = BigDecimal.ONE.subtract(percentual);

        List<ItemCarrinho> itensComDesconto = this.itens.stream()
                .map(item -> {
                    Dinheiro precoOriginal = item.getProduto().getPreco();
                    BigDecimal novoValor = precoOriginal.getValor()
                            .multiply(fatorDesconto)
                            .setScale(2, RoundingMode.HALF_EVEN); // Arredondamento bancário

                    Dinheiro novoPreco = new Dinheiro(novoValor, precoOriginal.getMoeda());
                    Produto produtoComDesconto = new Produto(item.getProduto().getNome(), novoPreco);
                    return new ItemCarrinho(produtoComDesconto, item.getQuantidade());
                })
                .collect(Collectors.toList());

        // Retorna um NOVO carrinho com os preços dos produtos atualizados
        return new Carrinho(itensComDesconto);
    }

    public BigDecimal getValorTotal() {
        return itens.stream()
                .map(ItemCarrinho::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Carrinho (Total: " + getValorTotal().setScale(2, RoundingMode.HALF_EVEN) + ")\n");
        itens.forEach(item -> sb.append(" - ").append(item).append("\n"));
        return sb.toString();
    }
}