package com.consultar.controlador;

import com.consultar.entidade.*;
import com.consultar.repositorio.ExamesRepositorio;
import com.consultar.repositorio.FeedNoticiasRepositorio;
import com.consultar.repositorio.PermissaoRepositorio;
import com.consultar.repositorio.UnidadeDeSaudeRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
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
 @Autowired
 PermissaoRepositorio permissaoRepositorio;
@Autowired
    FeedNoticiasRepositorio feedNoticiasRepositorio;


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

        Permissao p=new Permissao();
        p.setNome("USER");
        permissaoRepositorio.save(p);

        Exames e=new Exames();
        Medicamento medicamento=new Medicamento();
        medicamento.setNome("dipirona");
        medicamento.setDescricao("Descricao Dipirona");
        medicamento.setStatus(1);

        Profissional profissional=new Profissional();
        profissional.setNome("Profissional1");
        profissional.setDescricao("Descricao Profissional");
        profissional.setHorario("00:00-00:00");
        profissional.setCrm(12345678);
        profissional.setEspecialidade("Especialidade Profissional");
        profissional.setStatus(1);

        Vacinas vacinas=new Vacinas();
        vacinas.setNome("Nome Vacina");
        vacinas.setDescricao("Descricao Vacina");
        vacinas.setValor((short)0);
        vacinas.setStatus(1);

        Usuario usuario=new Usuario();
        usuario.setTipo(1);

        Estado estado=new Estado();
        Pais pais=new Pais();
        Cidade cidade=new Cidade();
        cidade.setNome("Nome Cidade");
        cidade.setStatus(1);
        Rua rua=new Rua();
        rua.setNome("Nome Rua");
        rua.setStatus(1);

        Bairro bairro=new Bairro();
        bairro.setNome("nome Bairro");
        bairro.setCidade(cidade);
        bairro.setStatus(1);

        Setor setor=new Setor();
        setor.setNome("nome Setor");
        setor.setStatus(1);
        setor.setDescricao("descricao Setor");

        Contato contato=new Contato();
        contato.setDd(62);
        contato.setStatus(1);
        contato.setSetor(setor);
        contato.setTelefone(1234567);

        Complemento complemento=new Complemento();
        complemento.setStatus(1);
        complemento.setDescricao("descricao Complemento");

        Imagem imagem=new Imagem();
        imagem.setNome("nome da imagem");
        imagem.setStatus(1);
        imagem.setLink("Link");
        imagem.setUrl("urlImagem");



         usuario.setStatus(1);
        usuario.setNome("usuarioTeste");
        usuario.setCpf("123456789");


        FeedNoticias feedNoticias=new FeedNoticias();
        feedNoticias.setNome("Nome Noticia");
        feedNoticias.setStatus(1);
        feedNoticias.setDescricao("descricao da Noticia");
        feedNoticias.setTipo(1);
        feedNoticias.setImagem(imagem);
        feedNoticias.setUsuario(usuario);

        feedNoticiasRepositorio.save(feedNoticias);




        Localizacao localizacao=new Localizacao();
        localizacao.setBairro(bairro);
        localizacao.setRua(rua);
        localizacao.setStatus(1);
        localizacao.setLatitude("35.3333");
        localizacao.setLongitude("40.2222");

        bairro.setLocalizacao(localizacao);




        e.setNome("Raiox2123");
        e.setDescricao("Gratuito2123");
        e.setHorario("horario2123");
        e.setStatus(1);
        e.setValor((short)123);

        UnidadeDeSaude unidadeDeSaude = new UnidadeDeSaude();
        unidadeDeSaude.setNome("nome Unidade de Saude");
        unidadeDeSaude.setStatus(1);
        unidadeDeSaude.setDescricao("descricao Unidade Saude");
        unidadeDeSaude.setUrl("url");
        unidadeDeSaude.setHorario("00:00-00:00");

        unidadeDeSaudeRepositorio.save(unidadeDeSaude);

        PlantaoDia plantaoDia=new PlantaoDia();
        plantaoDia.setStatus(1);
        plantaoDia.setDescricao("descricao plantao DIa");
        plantaoDia.setData(new Date());
        plantaoDia.setHorario("00:00-00:00");
        plantaoDia.setProfissional(profissional);
        plantaoDia.setUnidadeSaude(unidadeDeSaude);


        List<Exames> exame=new ArrayList();
        exame.add(e);
        List<Profissional> profissionals=new ArrayList();
        profissionals.add(profissional);
        List<Vacinas> vacinass=new ArrayList();
        vacinass.add(vacinas);
        List<Medicamento> medicamentos=new ArrayList();
        medicamentos.add(medicamento);
         List<PlantaoDia> plantaoDias=new ArrayList();
        plantaoDias.add(plantaoDia);

        unidadeDeSaude.setExames(exame);
        unidadeDeSaude.setProfissional(profissionals);
        unidadeDeSaude.setVacinas(vacinass);
        unidadeDeSaude.setMedicamento(medicamentos);
        unidadeDeSaude.setPlantaoDia(plantaoDias);
        unidadeDeSaude.setUsuario(usuario);
        unidadeDeSaude.setContato(contato);
        unidadeDeSaude.setImagem(imagem);



        unidadeDeSaudeRepositorio.save(unidadeDeSaude);

    }


}

