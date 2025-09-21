package exercicio8;

import java.math.BigDecimal;

public class Pedido {
    private final BigDecimal valorTotal;
    private final String cepDestino;
    private ICalculoFrete estrategiaFrete; // Referência à estratégia

    public Pedido(BigDecimal valorTotal, String cepDestino, ICalculoFrete estrategiaInicial) {
        this.valorTotal = valorTotal;
        this.cepDestino = cepDestino;
        this.estrategiaFrete = estrategiaInicial;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public String getCepDestino() {
        return cepDestino;
    }

    // Método crucial para trocar a estratégia em tempo de execução
    public void setEstrategiaFrete(ICalculoFrete estrategiaFrete) {
        this.estrategiaFrete = estrategiaFrete;
    }

    public ICalculoFrete getEstrategiaFrete() {
        return estrategiaFrete;
    }
}