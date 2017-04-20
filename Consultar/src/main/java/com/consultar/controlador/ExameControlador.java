package com.consultar.controlador;

import com.consultar.entidade.Exames;
import com.consultar.repositorio.ExamesRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Gleisongjs on 20/03/2017.
 */
@RestController
@RequestMapping(value = "/exame")
public class ExameControlador {


    @Autowired
    ExamesRepositorio exameRepositorio;


    @RequestMapping(method = RequestMethod.GET)
    public List<Exames> listar(){

        return exameRepositorio.findAll();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Exames buscarPeloId(@PathVariable long id){
        return exameRepositorio.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Exames criar(@RequestBody Exames unidadeDeSaude){

        if (unidadeDeSaude!=null) {
            unidadeDeSaude=exameRepositorio.save(unidadeDeSaude);


            return unidadeDeSaude;
        }
        return null;

    }

    @RequestMapping(method = RequestMethod.PUT)
    public Exames atualizar(@RequestBody Exames unidadeDeSaude){
        if (unidadeDeSaude!=null) {
            exameRepositorio.save(unidadeDeSaude);
            return unidadeDeSaude;
        }
        return null;
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public void deletar(@PathVariable long id){

        Exames unidadeDeSaude = exameRepositorio.findOne(id);
        if(unidadeDeSaude != null){
            exameRepositorio.delete(unidadeDeSaude);
        }
    }


}

