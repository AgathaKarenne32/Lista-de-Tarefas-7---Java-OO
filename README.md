# Exercícios de Orientação a Objetos em Java

Este repositório contém uma coleção de 8 exercícios práticos desenvolvidos em Java, focados em solidificar os principais conceitos da Programação Orientada a Objetos (POO). Cada exercício está contido em seu próprio pacote e demonstra uma faceta diferente do paradigma de OO.

## 🚀 Conceitos Abordados

-   **Encapsulamento:** Proteção e validação de dados.
-   **Herança:** Reutilização de código e especialização de classes.
-   **Polimorfismo:** Execução de comportamentos diferentes através de uma interface comum.
-   **Abstração:** Foco no essencial, escondendo complexidade.
-   **Interfaces:** Definição de contratos e desacoplamento.
-   **Imutabilidade:** Criação de objetos seguros e previsíveis.
-   **Generics:** Criação de componentes reutilizáveis e com segurança de tipo.
-   **Padrões de Projeto:** Aplicação do padrão *Strategy* para algoritmos intercambiáveis.

## 🛠️ Tecnologias Utilizadas

-   **Java 17+**
-   **IntelliJ IDEA**
-   **Git & GitHub**

---

## 📋 Detalhes dos Exercícios

### Exercício 1 — Encapsulamento (Classe Produto)
**Conceito:** Encapsulamento.
-   Implementação da classe `Produto` com atributos privados (`nome`, `preco`, `quantidadeEmEstoque`).
-   Uso de getters e setters com validações para garantir a integridade dos dados (valores não nulos ou negativos).

### Exercício 2 — Encapsulamento com Validação de Regra (Desconto)
**Conceito:** Encapsulamento e Regras de Negócio.
-   Extensão da classe `Produto` com um método `aplicarDesconto`.
-   Validação da porcentagem de desconto para garantir que ela esteja dentro de um intervalo permitido (0-50%).

### Exercício 3 — Herança (Hierarquia de Funcionários)
**Conceito:** Herança.
-   Criação de uma classe base `Funcionario` e subclasses `Gerente` e `Desenvolvedor`.
-   Sobrescrita do método `calcularBonus()` em cada subclasse para implementar lógicas de bônus específicas.

### Exercício 4 — Polimorfismo com Interface (IMeioTransporte)
**Conceito:** Polimorfismo e Interfaces.
-   Definição da interface `IMeioTransporte` com os métodos `acelerar()` e `frear()`.
-   Implementações concretas (`Carro`, `Bicicleta`, `Trem`), cada uma com sua própria lógica de velocidade e limites.

### Exercício 5 — Abstração (Sistema de Pagamentos)
**Conceito:** Abstração.
-   Implementação da classe abstrata `FormaPagamento`.
-   Criação de classes concretas (`CartaoCredito`, `Boleto`, `Pix`) que herdam da classe abstrata e implementam validações específicas.

### Exercício 6 — Imutabilidade e Objetos de Valor (Carrinho de Compras)
**Conceito:** Imutabilidade.
-   Criação de um `Carrinho` imutável, onde operações como adicionar/remover itens retornam uma **nova instância** do carrinho.
-   Modelação do `Dinheiro` como um Objeto de Valor imutável.

### Exercício 7 — Generics (Repositório Genérico em Memória)
**Conceito:** Generics.
-   Definição de um `IRepository` genérico para operações de CRUD.
-   Implementação de um `InMemoryRepository` que pode armazenar qualquer tipo de entidade que implemente a interface `Identificavel`.

### Exercício 8 — Padrão Strategy (Cálculo de Frete com Lambdas)
**Conceito:** Padrões de Projeto (Strategy).
-   Implementação de um sistema de cálculo de frete onde a estratégia (algoritmo) pode ser trocada em tempo de execução (`Sedex`, `PAC`, etc.).
-   Demonstração do uso de uma expressão lambda para criar uma estratégia promocional de forma dinâmica.

## 🚀 Como Executar

Cada exercício está em seu próprio pacote (`exercicio1e2`, `exercicio7`, etc.) e possui uma classe principal para demonstração (ex: `Main`).

1.  Clone o repositório.
2.  Abra o projeto em sua IDE de preferência (ex: IntelliJ IDEA).
3.  Navegue até o pacote do exercício desejado e execute a classe principal.

## 👩‍💻 Autor

-   **Agatha Karenne**
