package exercicio8;

import java.math.BigDecimal;

public class CalculadoraFrete {

    // Validação de CEP (exemplo simples)
    private void validarCep(String cep) {
        if (cep == null || !cep.matches("\\d{5}-?\\d{3}")) {
            throw new CepInvalidoException("Formato de CEP inválido: " + cep);
        }
    }

    public BigDecimal calcular(Pedido pedido) {
        validarCep(pedido.getCepDestino());
        // Delega o cálculo para o objeto de estratégia contido no pedido
        return pedido.getEstrategiaFrete().calcular(pedido);
    }
}