package exercicio6;

import java.math.BigDecimal;

public class MainCarrinho {
    public static void main(String[] args) {
        // 1. Criar produtos
        Produto notebook = new Produto("Notebook Pro", new Dinheiro(new BigDecimal("9500.00"), Moeda.BRL));
        Produto mouse = new Produto("Mouse Logic", new Dinheiro(new BigDecimal("350.50"), Moeda.BRL));

        // 2. Iniciar um carrinho vazio
        Carrinho carrinho1 = new Carrinho();
        System.out.println("C1 (vazio): " + carrinho1);

        // 3. Adicionar um item -> cria um NOVO carrinho (carrinho2)
        Carrinho carrinho2 = carrinho1.adicionarItem(notebook, 1);
        System.out.println("C2 (adicionou notebook): \n" + carrinho2);

        // 4. Adicionar outro item -> cria um NOVO carrinho (carrinho3)
        Carrinho carrinho3 = carrinho2.adicionarItem(mouse, 2);
        System.out.println("C3 (adicionou 2 mouses): \n" + carrinho3);

        // ** PROVA DA IMUTABILIDADE **
        System.out.println("PROVA: O carrinho1 ainda está vazio? " + carrinho1.getItens().isEmpty());
        System.out.println("PROVA: O carrinho2 ainda tem 1 item? " + (carrinho2.getItens().size() == 1));
        System.out.println("---------------------------------------------");

        // 5. Aplicar cupom de 15% -> cria um NOVO carrinho (carrinho4)
        Carrinho carrinho4 = carrinho3.aplicarCupomDeDesconto(new BigDecimal("0.15"));
        System.out.println("C4 (com cupom de 15%): \n" + carrinho4);
        System.out.println("Valor original: " + carrinho3.getValorTotal());
        System.out.println("Valor com desconto: " + carrinho4.getValorTotal());
        System.out.println("---------------------------------------------");

        // 6. Remover um item -> cria um NOVO carrinho (carrinho5)
        Carrinho carrinho5 = carrinho4.removerItem(notebook);
        System.out.println("C5 (removeu notebook): \n" + carrinho5);

        // 7. Testando validações
        try {
            carrinho1.adicionarItem(mouse, 0);
        } catch (IllegalArgumentException e) {
            System.err.println("\n!!! Erro (esperado): " + e.getMessage());
        }

        try {
            carrinho3.aplicarCupomDeDesconto(new BigDecimal("0.50")); // 50% é inválido
        } catch (IllegalArgumentException e) {
            System.err.println("!!! Erro (esperado): " + e.getMessage());
        }
    }
}