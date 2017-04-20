package com.consultar.controlador;

import com.consultar.entidade.PlantaoDia;
import com.consultar.repositorio.PlataoDiaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Gleisongjs on 20/03/2017.
 */
@RestController
@RequestMapping(value = "/plantaoDia")
public class PlantaoDiaControlador {






    @Autowired
    PlataoDiaRepositorio plantaoDiaRepositorio;


    @RequestMapping(method = RequestMethod.GET)
    public List<PlantaoDia> listar(){

        return plantaoDiaRepositorio.findAll();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public PlantaoDia buscarPeloId(@PathVariable long id){
        return plantaoDiaRepositorio.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public PlantaoDia criar(@RequestBody PlantaoDia feedNoticias){

        if (feedNoticias!=null) {
            feedNoticias=plantaoDiaRepositorio.save(feedNoticias);


            return feedNoticias;
        }
        return null;

    }

    @RequestMapping(method = RequestMethod.PUT)
    public PlantaoDia atualizar(@RequestBody PlantaoDia feedNoticias){
        if (feedNoticias!=null) {
            plantaoDiaRepositorio.save(feedNoticias);
            return feedNoticias;
        }
        return null;
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public void deletar(@PathVariable long id){

        PlantaoDia feedNoticias = plantaoDiaRepositorio.findOne(id);
        if(feedNoticias != null){
            plantaoDiaRepositorio.delete(feedNoticias);
        }
    }


}

