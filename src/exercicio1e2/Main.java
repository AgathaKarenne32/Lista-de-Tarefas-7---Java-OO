package exercicio1e2;

public class Main {
    public static void main(String[] args) {
        // --- Demonstração do Exercício 1 e 2 ---

        // 1. Testando validações do construtor
        System.out.println("--- Testando Validações ---");
        try {
            new Produto("", 600, 1);
        } catch (IllegalArgumentException ex) {
            System.out.println("Erro capturado (esperado): " + ex.getMessage());
        }
        try {
            new Produto("Produto Válido", -10, 1);
        } catch (IllegalArgumentException ex) {
            System.out.println("Erro capturado (esperado): " + ex.getMessage());
        }

        System.out.println("\n--- Testando Aplicação de Desconto ---");

        // 2. Testando desconto válido
        try {
            Produto produto = new Produto("Skate", 100.00, 23);
            System.out.println("Antes do desconto: " + produto);

            produto.aplicarDesconto(20); // Aplicando 20%
            System.out.println("Após desconto de 20%: " + produto);

        } catch (IllegalArgumentException e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
        }

        // 3. Testando desconto inválido
        System.out.println("\n--- Testando Desconto Inválido ---");
        try {
            Produto produto2 = new Produto("Patins", 300.00, 10);
            System.out.println("Produto: " + produto2);
            System.out.println("Tentando aplicar desconto de 70%...");
            produto2.aplicarDesconto(70);
        } catch (DescontoInvalidoException e) {
            System.out.println("Erro capturado (esperado): " + e.getMessage());
        }
    }
}