package exercicio8;

import java.math.BigDecimal;

/**
 * Interface Strategy que define o contrato para diferentes algoritmos de cálculo de frete.
 */
@FunctionalInterface // Boa prática, pois pode ser implementada por uma lambda.
public interface ICalculoFrete {
    BigDecimal calcular(Pedido pedido);
}