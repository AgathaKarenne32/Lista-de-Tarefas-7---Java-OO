package exercicio5;

public class Boleto extends FormaPagamento {
    private final String codigoDeBarras;

    public Boleto(String codigoDeBarras) {
        this.codigoDeBarras = codigoDeBarras;
    }

    @Override
    public void validarPagamento() throws PagamentoInvalidoException {
        System.out.println("Validando Boleto...");
        // Exemplo: Linha digitável de boleto bancário tem 47 ou 48 dígitos.
        if (codigoDeBarras == null || !codigoDeBarras.matches("\\d{47,48}")) {
            throw new PagamentoInvalidoException("Código de barras do boleto inválido.");
        }
        System.out.println("Boleto válido.");
    }
}