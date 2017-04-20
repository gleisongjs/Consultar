package com.consultar.controlador;

import com.consultar.entidade.Medicamento;
import com.consultar.repositorio.MedicamentoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Gleisongjs on 20/03/2017.
 */
@RestController
@RequestMapping(value = "/medicamento")
public class MedicamentoControlador {


    @Autowired
    MedicamentoRepositorio medicamentoRepositorio;


    @RequestMapping(method = RequestMethod.GET)
    public List<Medicamento> listar(){

        return medicamentoRepositorio.findAll();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Medicamento buscarPeloId(@PathVariable long id){
        return medicamentoRepositorio.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Medicamento criar(@RequestBody Medicamento unidadeDeSaude){

        if (unidadeDeSaude!=null) {
            unidadeDeSaude=medicamentoRepositorio.save(unidadeDeSaude);


            return unidadeDeSaude;
        }
        return null;

    }

    @RequestMapping(method = RequestMethod.PUT)
    public Medicamento atualizar(@RequestBody Medicamento unidadeDeSaude){
        if (unidadeDeSaude!=null) {
            medicamentoRepositorio.save(unidadeDeSaude);
            return unidadeDeSaude;
        }
        return null;
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public void deletar(@PathVariable long id){

        Medicamento unidadeDeSaude = medicamentoRepositorio.findOne(id);
        if(unidadeDeSaude != null){
            medicamentoRepositorio.delete(unidadeDeSaude);
        }
    }


}

