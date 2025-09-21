package exercicio7;

import java.math.BigDecimal;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Exercício 7: Repositório Genérico ---");

        // --- 1. Demonstração com Repositório de Produtos ---
        System.out.println("\n--- Usando Repositório para Produtos (ID: Integer) ---");
        IRepository<Produto, Integer> repoProdutos = new InMemoryRepository<>();

        System.out.println("Salvando produtos...");
        repoProdutos.salvar(new Produto(1, "Caneta Azul", new BigDecimal("2.50")));
        repoProdutos.salvar(new Produto(2, "Caderno 10 Matérias", new BigDecimal("25.99")));

        System.out.println("\nListando todos os produtos:");
        repoProdutos.listarTodos().forEach(System.out::println);

        System.out.println("\nBuscando produto com ID 2:");
        repoProdutos.buscarPorId(2).ifPresentOrElse(
                produto -> System.out.println("Encontrado: " + produto),
                () -> System.out.println("Produto não encontrado.")
        );

        System.out.println("\nRemovendo produto com ID 1...");
        repoProdutos.remover(1);
        System.out.println("Produtos restantes: " + repoProdutos.listarTodos());

        System.out.println("\nTentando remover produto com ID 99 (inexistente):");
        try {
            repoProdutos.remover(99);
        } catch (EntityNotFoundException e) {
            System.err.println("Exceção capturada (esperado): " + e.getMessage());
        }

        // --- 2. Demonstração com Repositório de Funcionários ---
        System.out.println("\n\n--- Usando Repositório para Funcionários (ID: String) ---");
        IRepository<Funcionario, String> repoFuncionarios = new InMemoryRepository<>();

        System.out.println("Salvando funcionários...");
        repoFuncionarios.salvar(new Funcionario("FUNC-001", "Ana Clara", new BigDecimal("5500.00")));
        repoFuncionarios.salvar(new Funcionario("FUNC-002", "Bruno Dias", new BigDecimal("7200.00")));

        System.out.println("\nListando todos os funcionários:");
        repoFuncionarios.listarTodos().forEach(System.out::println);

        System.out.println("\nBuscando funcionário com ID 'FUNC-001':");
        Optional<Funcionario> func = repoFuncionarios.buscarPorId("FUNC-001");
        func.ifPresent(f -> System.out.println("Encontrado: " + f.getNome()));
    }
}