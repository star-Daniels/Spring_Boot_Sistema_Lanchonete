package com.example.demo.repositories;

import com.example.demo.entities.Lanche;
import com.example.demo.interfaces.LancheRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LancheRepositoryImpl implements LancheRepository {
    private List<Lanche> lanches = new ArrayList<>();

    public Lanche buscarPorCodigo(int codigo) {
        Lanche lanche = lanches
                .stream()
                .filter(p -> p.getCodigo() == codigo)
                .findFirst()
                .get();

        return lanche;
    }

    public List<Lanche> buscar() {
        return lanches;
    }

    public void adicionar(Lanche lanche) {
        lanches.add(lanche);
    }

    public void remover(int codigo) {
        lanches.removeIf(p -> p.getCodigo() == codigo);
    }

    public void atualizar(int codigo, Lanche lanche) {
        Lanche lancheInMemory = this.buscarPorCodigo(codigo);

        lancheInMemory.setNome(lanche.getNome());
        lancheInMemory.setPreco(lanche.getPreco());
        lancheInMemory.setImagem(lanche.getImagem());
    }
}
