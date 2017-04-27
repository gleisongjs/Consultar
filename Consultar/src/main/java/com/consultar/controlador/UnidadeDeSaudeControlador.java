package com.consultar.controlador;

import com.consultar.entidade.Exames;
import com.consultar.entidade.UnidadeDeSaude;
import com.consultar.repositorio.ExamesRepositorio;
import com.consultar.repositorio.UnidadeDeSaudeRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gleisongjs on 20/03/2017.
 */
@RestController
@RequestMapping(value = "/unidadeSaude")
public class UnidadeDeSaudeControlador {


    @Autowired
    UnidadeDeSaudeRepositorio unidadeDeSaudeRepositorio;
    @Autowired
    ExamesRepositorio examesRepositorio;


    @RequestMapping(method = RequestMethod.GET)
    public List<UnidadeDeSaude> listar(){

        return unidadeDeSaudeRepositorio.findAll();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public UnidadeDeSaude buscarPeloId(@PathVariable long id){
        return unidadeDeSaudeRepositorio.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public UnidadeDeSaude criar(@RequestBody UnidadeDeSaude unidadeDeSaude){

        if (unidadeDeSaude!=null) {
            unidadeDeSaude=unidadeDeSaudeRepositorio.save(unidadeDeSaude);


            return unidadeDeSaude;
        }
        return null;

    }

    @RequestMapping(method = RequestMethod.PUT)
    public UnidadeDeSaude atualizar(@RequestBody UnidadeDeSaude unidadeDeSaude){
        if (unidadeDeSaude!=null) {
            unidadeDeSaudeRepositorio.save(unidadeDeSaude);
            return unidadeDeSaude;
        }
        return null;
    }


    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public void deletar(@PathVariable long id){

        UnidadeDeSaude unidadeDeSaude = unidadeDeSaudeRepositorio.findOne((long)id);
        if(unidadeDeSaude != null){
            unidadeDeSaudeRepositorio.delete(unidadeDeSaude);
        }
    }
    @RequestMapping( value = "/teste",method = RequestMethod.GET)
    public void deletar(){

        Exames e=new Exames();
        e.setNome("Raiox2123");
        e.setDescricao("Gratuito2123");
        e.setHorario("horario2123");
        e.setStatus(1);
        e.setValor((short)123);

        UnidadeDeSaude unidadeDeSaude = unidadeDeSaudeRepositorio.findOne(23);



        e=examesRepositorio.save(e);

        List list=new ArrayList();
        list.add(e);
        unidadeDeSaude.setExames(list);


        unidadeDeSaudeRepositorio.save(unidadeDeSaude);

    }


}

