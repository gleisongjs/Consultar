package com.consultar.controlador;

import com.consultar.entidade.Pessoa;
import com.consultar.repositorio.PessoaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Gleisongjs on 20/03/2017.
 */
@RestController
@RequestMapping(value = "/pessoa")
public class PessoaControlador {

    @Autowired
    PessoaRepositorio pessoaRepositorio;

    @RequestMapping(method = RequestMethod.GET)
    public List<Pessoa> listar(){

        return pessoaRepositorio.findAll();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Pessoa buscarPeloId(@PathVariable long id){
        return pessoaRepositorio.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Pessoa criar(@RequestBody Pessoa pessoa){
        pessoaRepositorio.save(pessoa);
        return pessoa;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Pessoa atualizar(@RequestBody Pessoa pessoa){
        pessoaRepositorio.save(pessoa);
        return pessoa;
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public void deletar(@PathVariable long id){
        Pessoa pessoa = pessoaRepositorio.findOne(id);
        if(pessoa != null){
            pessoaRepositorio.delete(pessoa);
        }
    }
}

