package exercicio8;

import java.math.BigDecimal;

public class FreteSedex implements ICalculoFrete {
    @Override
    public BigDecimal calcular(Pedido pedido) {
        // Lógica de exemplo: 10% do valor do pedido + taxa fixa de R$ 12.00
        BigDecimal taxaFixa = new BigDecimal("12.00");
        BigDecimal percentual = pedido.getValorTotal().multiply(new BigDecimal("0.10"));
        return percentual.add(taxaFixa);
    }
}