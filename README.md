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
-   Implementação
