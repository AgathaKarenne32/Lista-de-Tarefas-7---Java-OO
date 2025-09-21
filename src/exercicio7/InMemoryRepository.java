package exercicio7;

import java.util.*;

public class InMemoryRepository<T extends Identificavel<ID>, ID> implements IRepository<T, ID> {

    // Boa prática: tornar o mapa final para que a referência não possa ser trocada
    private final Map<ID, T> repositorio = new HashMap<>();

    @Override
    public void salvar(T entidade) {
        repositorio.put(entidade.getId(), entidade);
    }

    @Override
    public Optional<T> buscarPorId(ID id) { // Nome corrigido
        return Optional.ofNullable(repositorio.get(id));
    }

    @Override
    public List<T> listarTodos() { // Nome corrigido
        // Retorna uma cópia imutável para proteger os dados internos
        return List.copyOf(repositorio.values());
    }

    @Override
    public void remover(ID id) throws EntityNotFoundException { // Método implementado
        if (!repositorio.containsKey(id)) {
            throw new EntityNotFoundException("Entidade com ID " + id + " não encontrada.");
        }
        repositorio.remove(id);
    }

    @Override
    public Produto[] getAll() {
        return new Produto[0];
    }
}