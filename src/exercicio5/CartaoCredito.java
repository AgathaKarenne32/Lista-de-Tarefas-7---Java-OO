package exercicio5;

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