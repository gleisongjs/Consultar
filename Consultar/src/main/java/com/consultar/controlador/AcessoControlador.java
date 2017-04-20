package com.consultar.controlador;

import com.consultar.entidade.Acesso;
import com.consultar.entidade.Permissao;
import com.consultar.repositorio.AcessoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gleisongjs on 20/03/2017.
 */
@RestController
@RequestMapping(value = "/acesso")
public class AcessoControlador {





    @Autowired
    AcessoRepositorio acessoRepositorio;
    //@Autowired
    //PermissaoRepositorio  permissaoRepositorio;

    @RequestMapping(method = RequestMethod.GET)
    public List<Acesso> listar(){

        return acessoRepositorio.findAll();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Acesso buscarPeloId(@PathVariable long id){
        return acessoRepositorio.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Acesso criar(@RequestBody Acesso pessoa){
        System.out.println(pessoa.toString());
        Permissao permissao=new Permissao();

        permissao.setNome("1");
        permissao.setId(1);
        List a=new ArrayList();

             a.add(permissao);
//        permissaoRepositorio.save(permissao);


  //      pessoa.setPermissoes(a);
        acessoRepositorio.save(pessoa);
        return pessoa;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Acesso atualizar(@RequestBody Acesso pessoa){
        acessoRepositorio.save(pessoa);
        return pessoa;
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public void deletar(@PathVariable long id){
        Acesso pessoa = acessoRepositorio.findOne(id);
        if(pessoa != null){
            acessoRepositorio.delete(pessoa);
        }
    }


}

