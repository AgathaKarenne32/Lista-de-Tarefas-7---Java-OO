package exercicio5;

import exercicio5.FormaPagamento;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class MainPagamentos {
    public static void main(String[] args) {
        // Criando instâncias de várias formas de pagamento
        FormaPagamento cartaoValido = new CartaoCredito("1111222233334444", "JOAO DA SILVA", "123");
        FormaPagamento boletoInvalido = new Boleto("123456789"); // Código curto
        FormaPagamento pixValido = new Pix("contato@meuemail.com");
        FormaPagamento cartaoInvalido = new CartaoCredito("1111222233334444", "MARIA SOUZA", "abc"); // CVV inválido

        List<FormaPagamento> formasDePagamento = Arrays.asList(cartaoValido, boletoInvalido, pixValido, cartaoInvalido);
        BigDecimal valorCompra = new BigDecimal("250.75");

        // Processando cada pagamento de forma polimórfica
        for (FormaPagamento forma : formasDePagamento) {
            System.out.println("\n--- Tentando processar pagamento com " + forma.getClass().getSimpleName() + " ---");
            try {
                forma.processarPagamento(valorCompra);
            } catch (PagamentoInvalidoException e) {
                System.err.println("!!! Falha na Validação: " + e.getMessage());
            }
        }
    }
}