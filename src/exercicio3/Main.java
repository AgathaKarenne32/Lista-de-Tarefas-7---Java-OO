package exercicio3;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Exercício 3: Herança e Polimorfismo ---");
        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        // --- 1. Criação dos funcionários ---
        Gerente gerente = new Gerente("Carlos Andrade", new BigDecimal("12000.00"));
        Desenvolvedor dev = new Desenvolvedor("Mariana Souza", new BigDecimal("8000.00"));

        // --- 2. Uso de Polimorfismo com uma coleção ---
        List<Funcionario> funcionarios = List.of(gerente, dev);

        System.out.println("\nCalculando bônus para cada funcionário:");
        for (Funcionario f : funcionarios) {
            // A chamada f.calcularBonus() invoca o método correto (de Gerente ou Desenvolvedor)
            BigDecimal bonus = f.calcularBonus();
            System.out.printf("Funcionário: %-15s | Cargo: %-13s | Bônus: %s\n",
                    f.getNome(),
                    f.getClass().getSimpleName(),
                    formatoMoeda.format(bonus));
        }

        // --- 3. Teste de Validação ---
        System.out.println("\nTentando criar funcionário com salário negativo...");
        try {
            new Gerente("Invalido", new BigDecimal("-1000"));
        } catch (IllegalArgumentException e) {
            System.err.println("Erro capturado (esperado): " + e.getMessage());
        }
    }
}