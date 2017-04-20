package com.consultar.controlador;

import com.consultar.entidade.DadosClinico;
import com.consultar.repositorio.DadosClinicosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Gleisongjs on 20/03/2017.
 */
@RestController
@RequestMapping(value = "/dadosClinicos")
public class DadosClinicosControlador {


    @Autowired
    DadosClinicosRepositorio dadosClinicoRepositorio;


    @RequestMapping(method = RequestMethod.GET)
    public List<DadosClinico> listar(){

        return dadosClinicoRepositorio.findAll();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public DadosClinico buscarPeloId(@PathVariable long id){
        return dadosClinicoRepositorio.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public DadosClinico criar(@RequestBody DadosClinico unidadeDeSaude){

        if (unidadeDeSaude!=null) {
            unidadeDeSaude=dadosClinicoRepositorio.save(unidadeDeSaude);


            return unidadeDeSaude;
        }
        return null;

    }

    @RequestMapping(method = RequestMethod.PUT)
    public DadosClinico atualizar(@RequestBody DadosClinico unidadeDeSaude){
        if (unidadeDeSaude!=null) {
            dadosClinicoRepositorio.save(unidadeDeSaude);
            return unidadeDeSaude;
        }
        return null;
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public void deletar(@PathVariable long id){

        DadosClinico unidadeDeSaude = dadosClinicoRepositorio.findOne(id);
        if(unidadeDeSaude != null){
            dadosClinicoRepositorio.delete(unidadeDeSaude);
        }
    }


}

