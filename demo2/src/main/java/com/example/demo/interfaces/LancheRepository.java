package com.example.demo.interfaces;

import com.example.demo.entities.Lanche;

import java.util.List;

public interface LancheRepository {

    public Lanche buscarPorCodigo(int codigo);
    public List<Lanche> buscar();
    public void adicionar(Lanche lanche);
    public void remover(int codigo);
    public void atualizar(int codigo, Lanche lanche);

}
