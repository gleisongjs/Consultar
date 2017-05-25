package com.consultar.controlador;

import com.consultar.entidade.Profissional;
import com.consultar.repositorio.ProfissionalRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Gleisongjs on 20/03/2017.
 */
@RestController
@RequestMapping(value = "/profissional")
public class ProfissionalControlador {


    @Autowired
    ProfissionalRepositorio profissionalRepositorio;


    @RequestMapping(method = RequestMethod.GET)
    public List<Profissional> listar(){

        return profissionalRepositorio.findAll();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Profissional buscarPeloId(@PathVariable int id){
        return profissionalRepositorio.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Profissional criar(@RequestBody Profissional unidadeDeSaude){

        if (unidadeDeSaude!=null) {
            unidadeDeSaude=profissionalRepositorio.save(unidadeDeSaude);


            return unidadeDeSaude;
        }
        return null;

    }

    @RequestMapping(method = RequestMethod.PUT)
    public Profissional atualizar(@RequestBody Profissional unidadeDeSaude){
        if (unidadeDeSaude!=null) {
            profissionalRepositorio.save(unidadeDeSaude);
            return unidadeDeSaude;
        }
        return null;
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public void deletar(@PathVariable int id){

        System.out.println("id:"+id);
        Profissional unidadeDeSaude = profissionalRepositorio.findOne(id);
        if(unidadeDeSaude != null){
            profissionalRepositorio.delete(unidadeDeSaude);
        }
    }


}

