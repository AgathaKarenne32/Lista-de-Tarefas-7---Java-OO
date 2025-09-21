package exercicio4;

import java.util.List;

public class main {
    public static void main(String[] args) {
        System.out.println("--- Exercício 4: Polimorfismo com Interfaces ---");

        // --- 1. Criação dos meios de transporte ---
        IMeioTransporte carro = new Carro("Ford Ka", 180); // velocidade Max de 180 km/h

        List<IMeioTransporte> veiculos = List.of(carro);

        // --- 2. Demonstração de Polimorfismo ---
        for (IMeioTransporte veiculo : veiculos) {
            System.out.printf("\n--- Testando %s ---\n", veiculo.getClass().getSimpleName());
            veiculo.acelerar();
            veiculo.acelerar();
            veiculo.frear();
        }

        // --- 3. Teste de Exceção ---
        System.out.println("\n\n--- Testando Limites e Exceções ---");
        try {
            System.out.println("Tentando frear um carro parado...");
            carro.frear(); // Já está em 0, deve lançar exceção
        } catch (IllegalStateException e) {
            System.err.println("Erro capturado (esperado): " + e.getMessage());
        }
    }
}
