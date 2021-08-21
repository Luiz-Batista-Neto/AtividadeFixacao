package com.example.exerciciofixacao.controller;

import com.example.exerciciofixacao.model.Pessoa;
import com.example.exerciciofixacao.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/p")
//Quando coloco restcontroller eu informo que essa classe vai receber requesições HTTP
public class PessoaController {

    @Autowired
    PessoaRepository pessoaRepository;

    @GetMapping
        public List<Pessoa> listarTodosGET(){
        List<Pessoa> pessoas = new ArrayList<>();
        return this.pessoaRepository.findAll();
    }

    @PostMapping
        public Pessoa salvarPOST(@RequestBody Pessoa pessoa){
        return this.pessoaRepository.save(pessoa);
    }

    @PutMapping(path = "/{id}")
        public Pessoa AtualizacaoPUT(@RequestBody Long id){
        Pessoa pessoa = pessoaRepository.getById(id);

        return pessoa;
    }

    @DeleteMapping(path = "/{id}")
        public void apagarDELETE(@PathVariable Long id){
            pessoaRepository.getById(id);
    }
}
