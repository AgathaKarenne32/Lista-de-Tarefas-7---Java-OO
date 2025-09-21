package exercicio8;

import java.math.BigDecimal;

public class RetiradaNaLoja implements ICalculoFrete {
    @Override
    public BigDecimal calcular(Pedido pedido) {
        // Retirada na loja não tem custo de frete.
        return BigDecimal.ZERO;
    }
}