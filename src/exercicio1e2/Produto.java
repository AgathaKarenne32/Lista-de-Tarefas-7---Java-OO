package exercicio1e2;

class DescontoInvalidoException extends IllegalArgumentException {
    public DescontoInvalidoException(String mensagem) {
        super(mensagem);
    }
}

public class Produto {
    private String nome;
    private double preco;
    private int quantidade;

    public Produto(String nome, double preco, int quantidade) {
        setNome(nome);
        setPreco(preco);
        setQuantidade(quantidade);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser nulo ou vazio.");
        }
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco < 0) {
            throw new IllegalArgumentException("O preço deve ser maior ou igual a zero.");
        }
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade < 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior ou igual a zero.");
        }
        this.quantidade = quantidade;
    }

    public void aplicarDesconto(double porcentagem) {
        if (porcentagem < 0 || porcentagem > 50) {
            throw new DescontoInvalidoException("A porcentagem do desconto deve ser entre 0 e 50.");
        }
        double valorDesconto = this.preco * (porcentagem / 100);
        this.preco -= valorDesconto;
    }

    @Override
    public String toString() {
        return String.format("Produto[Nome: '%s', Preço: R$ %.2f, Quantidade: %d]",
                this.nome, this.preco, this.quantidade);
    }
}