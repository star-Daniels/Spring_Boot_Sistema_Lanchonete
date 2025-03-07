package com.example.demo.controllers;

import com.example.demo.entities.Lanche;
import com.example.demo.facade.LancheFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LancheControllers{


    private final LancheFacade lancheFacade;

    @Autowired
    public LancheControllers(LancheFacade lancheFacade) {
        this.lancheFacade = lancheFacade;


        Lanche lanche = new Lanche(1,"Lanche-1",10.1,"");
        Lanche lanche2 = new Lanche(2,"Lanche-2",10.1,"");
        Lanche lanche3 = new Lanche(3,"Lanche-3",10.1,"");

        this.lancheFacade.cadastrar(lanche);
        this.lancheFacade.cadastrar(lanche2);
        this.lancheFacade.cadastrar(lanche3);
    }

    @GetMapping("/")
    public List<Lanche> get(){
        return  lancheFacade.buscar();
    }

    @GetMapping("/{codigo}")
    public Lanche getLanche(@PathVariable int codigo){
        return lancheFacade.buscarPorCodigo(codigo);
    }

    @PostMapping("")
    public void cadastrar(@RequestBody Lanche lanche){
        lancheFacade.cadastrar(lanche);
    }

    @PutMapping("/atualizar/{cod}") //
    public void atualizar(@PathVariable int cod, @RequestBody Lanche lanche){
        lancheFacade.atualizar(cod, lanche);
    }
}
