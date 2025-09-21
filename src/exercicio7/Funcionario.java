package exercicio7;

import java.math.BigDecimal;

public class Funcionario implements Identificavel<String> {
    private final String id; // Ex: matrícula "FUNC-001"
    private final String nome;
    private final BigDecimal salario; // Alterado de 'cargo' para 'salario' com BigDecimal

    public Funcionario(String id, String nome, BigDecimal salario) {
        this.id = id;
        this.nome = nome;
        this.salario = salario;
    }

    @Override
    public String getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public BigDecimal getSalario() { // Alterado para getSalario
        return this.salario;
    }

    @Override
    public String toString() {
        return String.format("Funcionario[ID=%s, Nome='%s', Salário=R$%.2f]", id, nome, salario);
    }
}