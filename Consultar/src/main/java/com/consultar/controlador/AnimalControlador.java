package com.consultar.controlador;

/**
 * Created by Gleisongjs on 20/03/2017.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/animal")
public class AnimalControlador {
/*
    @Autowired
    AnimalRepositorio repositorio;

    @RequestMapping(method = RequestMethod.GET)
    public List<Animal> listar(){
        return repositorio.findAll();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Animal buscarPeloId(@PathVariable long id){
        return repositorio.findOne(id);
    }

    @RequestMapping(value="/buscar-pelo-nome/{nome}", method = RequestMethod.GET)
    public List<Animal> buscarPeloNome(@PathVariable String nome){
        System.out.println("NOME = "+ nome);
        return repositorio.findByNome(nome);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Animal criar(@RequestBody Animal animal){
        repositorio.save(animal);
        return animal;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Animal atualizar(@RequestBody Animal animal){
        repositorio.save(animal);
        return animal;
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public void deletar(@PathVariable long id){
        Animal animal = repositorio.findOne(id);
        if(animal != null){
            repositorio.delete(animal);
        }
    }
*/
}

