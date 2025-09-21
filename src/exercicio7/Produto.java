package exercicio7;

import java.math.BigDecimal;

public class Produto implements Identificavel<Integer> {

    // 1. Atributos precisam ser declarados na classe
    private final Integer id;
    private final String nome;
    private final BigDecimal preco;

    // 2. Apenas um construtor é necessário para criar um produto válido
    public Produto(Integer id, String nome, BigDecimal preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco; // 3. Atribuição direta, sem 'BigDecimal.valueOf()'
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }



    public BigDecimal getPreco() {
        return this.preco;
    }

    @Override
    public String toString() {
        // 4. Correção para formatar o BigDecimal como um valor monetário
        return String.format("Produto[ID=%d, Nome='%s', Preço=R$%.2f]", id, nome, preco.doubleValue());
    }
}