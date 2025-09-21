package exercicio8;

import java.math.BigDecimal;

public class FretePac implements ICalculoFrete {
    @Override
    public BigDecimal calcular(Pedido pedido) {
        // Lógica de exemplo: 5% do valor do pedido + taxa fixa de R$ 7.00
        BigDecimal taxaFixa = new BigDecimal("7.00");
        BigDecimal percentual = pedido.getValorTotal().multiply(new BigDecimal("0.05"));
        return percentual.add(taxaFixa);
    }
}