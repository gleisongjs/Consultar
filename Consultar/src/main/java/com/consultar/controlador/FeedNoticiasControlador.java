package com.consultar.controlador;

import com.consultar.entidade.FeedNoticias;
import com.consultar.repositorio.FeedNoticiasRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Gleisongjs on 20/03/2017.
 */
@RestController
@RequestMapping(value = "/feedNoticia")
public class FeedNoticiasControlador {






    @Autowired
    FeedNoticiasRepositorio feedNoticiasRepositorio;


    @RequestMapping(method = RequestMethod.GET)
    public List<FeedNoticias> listar(){

        return feedNoticiasRepositorio.findAll();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public FeedNoticias buscarPeloId(@PathVariable long id){
        return feedNoticiasRepositorio.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public FeedNoticias criar(@RequestBody FeedNoticias feedNoticias){

        if (feedNoticias!=null) {
            feedNoticias=feedNoticiasRepositorio.save(feedNoticias);


            return feedNoticias;
        }
        return null;

    }

    @RequestMapping(method = RequestMethod.PUT)
    public FeedNoticias atualizar(@RequestBody FeedNoticias feedNoticias){
        if (feedNoticias!=null) {
            feedNoticiasRepositorio.save(feedNoticias);
            return feedNoticias;
        }
        return null;
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public FeedNoticias deletar(@PathVariable long id){

System.out.println("id:"+id);
        FeedNoticias feedNoticias = feedNoticiasRepositorio.findOne(id);
        if(feedNoticias != null){
            feedNoticiasRepositorio.delete(feedNoticias);
        }
        return feedNoticias;
    }


}

