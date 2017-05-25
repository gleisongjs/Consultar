package com.consultar.controlador;

import com.consultar.entidade.Acesso;
import com.consultar.entidade.Permissao;
import com.consultar.repositorio.AcessoRepositorio;
import com.consultar.repositorio.PermissaoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    @Autowired
    PermissaoRepositorio permissaoRepositorio;
    //@Autowired
    //PermissaoRepositorio  permissaoRepositorio;
    Permissao permissao=null;
    List<Permissao> permissoes=null;
    @RequestMapping(method = RequestMethod.GET)
    public List<Acesso> listar(){

        return acessoRepositorio.findAll();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Acesso buscarPeloId(@PathVariable int id){
        return acessoRepositorio.findOne(id);
    }

    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }
    @RequestMapping(method = RequestMethod.POST)
    public Acesso criar(@RequestBody Acesso acesso){

        if (acesso.getPermissoes()==null) {

             permissao = permissaoRepositorio.findByNome("USER");
             if (permissao==null){
                 permissao=new Permissao();
                 permissao.setNome("USER") ;
                permissao=permissaoRepositorio.save(permissao);
             }

             permissoes = new ArrayList<>();
            permissoes.add(permissao);
            acesso.setPermissoes(permissoes);
        }

        if (acesso.getIdacesso()==null){
            Acesso aux=acessoRepositorio.findByEmail(acesso.getEmail());
            if (aux!=null){
                throw new Error("USUARIO Ja EXISTE");
            }

        }
//        System.out.println(acesso.toString());
        PasswordEncoder p=passwordEncoder();
        acesso.setPermissoes(permissoes);
        acesso.setSenha(p.encode(acesso.getSenha()));


  //      pessoa.setPermissoes(a);
        acessoRepositorio.save(acesso);
        return acesso;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Acesso atualizar(@RequestBody Acesso pessoa){
        acessoRepositorio.save(pessoa);
        return pessoa;
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public void deletar(@PathVariable int id){
        Acesso pessoa = acessoRepositorio.findOne(id);
        if(pessoa != null){
            acessoRepositorio.delete(pessoa);
        }
    }
    @RequestMapping(value="/alterar", method = RequestMethod.POST)
    public void alterar(@RequestBody Acesso pessoa){

        acessoRepositorio.save(pessoa);
    }


}

