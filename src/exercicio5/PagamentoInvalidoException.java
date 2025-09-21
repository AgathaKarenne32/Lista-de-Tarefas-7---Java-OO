package exercicio5;

// PagamentoInvalidoException.java
public class PagamentoInvalidoException extends RuntimeException {
    public PagamentoInvalidoException(String message) {
        super(message);
    }
}