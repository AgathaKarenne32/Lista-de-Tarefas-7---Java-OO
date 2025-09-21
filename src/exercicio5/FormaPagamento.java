package exercicio5;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public abstract class FormaPagamento {
    public abstract void validarPagamento() throws PagamentoInvalidoException;

    public void processarPagamento(BigDecimal valor) {
        // 1. Garante que a validação seja executada antes de processar
        validarPagamento();

        // 2. Simula o processamento
        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        System.out.printf("Pagamento de %s processado com sucesso via %s.\n",
                formatoMoeda.format(valor), this.getClass().getSimpleName());
    }// CartaoCredito.java
    public class CartaoCredito extends FormaPagamento {
        private final String numeroCartao;
        private final String nomeTitular;
        private final String cvv;

        public CartaoCredito(String numeroCartao, String nomeTitular, String cvv) {
            this.numeroCartao = numeroCartao;
            this.nomeTitular = nomeTitular;
            this.cvv = cvv;
        }

        @Override
        public void validarPagamento() throws PagamentoInvalidoException {
            System.out.println("Validando Cartão de Crédito...");
            if (numeroCartao == null || !numeroCartao.matches("\\d{16}")) {
                throw new PagamentoInvalidoException("Número de cartão de crédito inválido. Deve conter 16 dígitos.");
            }
            if (cvv == null || !cvv.matches("\\d{3}")) {
                throw new PagamentoInvalidoException("CVV inválido. Deve conter 3 dígitos.");
            }
            if (nomeTitular == null || nomeTitular.trim().isEmpty()) {
                throw new PagamentoInvalidoException("Nome do titular não pode ser vazio.");
            }
            System.out.println("Cartão de Crédito válido.");
        }
    }
}
