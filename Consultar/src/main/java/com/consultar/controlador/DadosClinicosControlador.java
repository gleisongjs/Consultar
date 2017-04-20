package com.consultar.controlador;

import com.consultar.entidade.Imagem;
import com.consultar.repositorio.ImagemRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Gleisongjs on 20/03/2017.
 */
@RestController
@RequestMapping(value = "/imagem")
public class ImagemControlador {


    @Autowired
    ImagemRepositorio imagemRepositorio;


    @RequestMapping(method = RequestMethod.GET)
    public List<Imagem> listar(){

        return imagemRepositorio.findAll();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Imagem buscarPeloId(@PathVariable long id){
        return imagemRepositorio.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Imagem criar(@RequestBody Imagem unidadeDeSaude){

        if (unidadeDeSaude!=null) {
            unidadeDeSaude=imagemRepositorio.save(unidadeDeSaude);


            return unidadeDeSaude;
        }
        return null;

    }

    @RequestMapping(method = RequestMethod.PUT)
    public Imagem atualizar(@RequestBody Imagem unidadeDeSaude){
        if (unidadeDeSaude!=null) {
            imagemRepositorio.save(unidadeDeSaude);
            return unidadeDeSaude;
        }
        return null;
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public void deletar(@PathVariable long id){

        Imagem unidadeDeSaude = imagemRepositorio.findOne(id);
        if(unidadeDeSaude != null){
            imagemRepositorio.delete(unidadeDeSaude);
        }
    }


}

