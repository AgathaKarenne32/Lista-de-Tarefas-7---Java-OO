package exercicio8;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class main {
    public static void main(String[] args) {
        CalculadoraFrete calculadora = new CalculadoraFrete();
        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        // --- Cenário 1: Pedido padrão com Sedex ---
        System.out.println("--- Cenário 1: Cálculo de Frete Dinâmico ---");
        Pedido pedido = new Pedido(new BigDecimal("150.00"), "01001-000", new FreteSedex());
        BigDecimal custoFrete = calculadora.calcular(pedido);
        System.out.printf("Estratégia Inicial (Sedex): %s\n", formatoMoeda.format(custoFrete));

        // --- Trocando a estratégia em tempo de execução para PAC ---
        pedido.setEstrategiaFrete(new FretePac());
        custoFrete = calculadora.calcular(pedido);
        System.out.printf("Estratégia Alterada (PAC): %s\n", formatoMoeda.format(custoFrete));

        // --- Trocando para Retirada na Loja ---
        pedido.setEstrategiaFrete(new RetiradaNaLoja());
        custoFrete = calculadora.calcular(pedido);
        System.out.printf("Estratégia Alterada (Retirada na Loja): %s\n", formatoMoeda.format(custoFrete));

        System.out.println("\n--- Cenário 2: Estratégia Promocional com Lambda ---");

        // Criando a estratégia promocional usando uma expressão lambda
        ICalculoFrete freteGratisAcimaDe200 = p -> {
            if (p.getValorTotal().compareTo(new BigDecimal("200.00")) > 0) {
                System.out.println("Aplicando promoção de frete grátis!");
                return BigDecimal.ZERO;
            }
            // Caso não se qualifique, usa a lógica do PAC como padrão
            return new FretePac().calcular(p);
        };

        // Pedido que NÃO se qualifica para a promoção
        Pedido pedidoPromocional1 = new Pedido(new BigDecimal("180.00"), "01001-001", freteGratisAcimaDe200);
        custoFrete = calculadora.calcular(pedidoPromocional1);
        System.out.printf("Pedido de %s (não qualificado): Frete %s\n",
                formatoMoeda.format(pedidoPromocional1.getValorTotal()),
                formatoMoeda.format(custoFrete));

        // Pedido que SE QUALIFICA para a promoção
        Pedido pedidoPromocional2 = new Pedido(new BigDecimal("250.00"), "01001-002", freteGratisAcimaDe200);
        custoFrete = calculadora.calcular(pedidoPromocional2);
        System.out.printf("Pedido de %s (qualificado): Frete %s\n",
                formatoMoeda.format(pedidoPromocional2.getValorTotal()),
                formatoMoeda.format(custoFrete));


        System.out.println("\n--- Cenário 3: Tratamento de Exceção (CEP Inválido) ---");
        try {
            Pedido pedidoInvalido = new Pedido(new BigDecimal("100.00"), "CEP-INVALIDO", new FreteSedex());
            calculadora.calcular(pedidoInvalido);
        } catch (CepInvalidoException e) {
            System.err.println("Erro capturado (esperado): " + e.getMessage());
        }
    }
}