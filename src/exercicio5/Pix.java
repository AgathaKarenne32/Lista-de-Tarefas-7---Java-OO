package exercicio5;

public class Pix extends FormaPagamento {
    private final String chavePix;

    public Pix(String chavePix) {
        this.chavePix = chavePix;
    }

    @Override
    public void validarPagamento() throws PagamentoInvalidoException {
        System.out.println("Validando Pix...");
        if (chavePix == null || chavePix.trim().isEmpty()) {
            throw new PagamentoInvalidoException("A chave Pix não pode ser nula ou vazia.");
        }
        // Uma validação real seria mais complexa (verificar formato de e-mail, CPF, etc.)
        System.out.println("Chave Pix válida.");
    }
}