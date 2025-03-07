package com.example.demo.applications;

import com.example.demo.entities.Lanche;
import com.example.demo.repositories.LancheRepositoryImpl;
import com.example.demo.services.LancheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LancheApplication {
    private LancheService lancheService;
    private LancheRepositoryImpl lancheRepositoryImpl;

    @Autowired
    public LancheApplication(
            LancheService lancheService,
            LancheRepositoryImpl lancheRepositoryImpl) {
        this.lancheService = lancheService;
        this.lancheRepositoryImpl = lancheRepositoryImpl;
    }

    public void cadastrar(Lanche lanche) {
        this.lancheRepositoryImpl.adicionar(lanche);
        this.lancheService.salvar(lanche);
    }

    public List<Lanche> buscar() {
        return this.lancheRepositoryImpl.buscar();
    }

    public Lanche buscarPorCodigo(int codigo) {
        return this.lancheRepositoryImpl.buscarPorCodigo(codigo);
    }

    public double calcularLanche(Lanche lanche, int quantidade) {
        return lanche.getPreco() * quantidade;
    }

    public void remover(int codigo){
        this.lancheRepositoryImpl.remover(codigo);
    }

    public void atualizar(int codigo, Lanche lanche){
        this.lancheRepositoryImpl.atualizar(codigo,lanche);
    }
}
