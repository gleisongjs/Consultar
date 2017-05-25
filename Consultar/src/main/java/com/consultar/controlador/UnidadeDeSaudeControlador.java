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

        System.out.println("un:"+unidadeDeSaudeRepositorio);
        return unidadeDeSaudeRepositorio.findAll();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public UnidadeDeSaude buscarPeloId(@PathVariable int id){
        return unidadeDeSaudeRepositorio.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public UnidadeDeSaude criar(@RequestBody UnidadeDeSaude unidadeDeSaude){

        if (unidadeDeSaude!=null) {
            if (unidadeDeSaude.getStatus()==null){
                unidadeDeSaude.setStatus(1);
                unidadeDeSaude.getEndereco().setStatus(1);
                unidadeDeSaude.getEndereco().getComplemento().setStatus(1);
                unidadeDeSaude.getEndereco().getRua().setStatus(1);
                unidadeDeSaude.getEndereco().getRua().getBairro().setStatus(1);
                unidadeDeSaude.getEndereco().getRua().getBairro().getCidade().setStatus(1);
                unidadeDeSaude.getEndereco().getRua().getBairro().getCidade().getEstado().setStatus(1);
                unidadeDeSaude.getEndereco().getRua().getBairro().getCidade().getEstado().getPais().setStatus(1);



            }

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
    public void deletar(@PathVariable int id){

        UnidadeDeSaude unidadeDeSaude = unidadeDeSaudeRepositorio.findOne(id);
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
        medicamento.setDescricao("Descricao Medicamento");
        medicamento.setStatus(1);

        Profissional profissional=new Profissional();
        profissional.setNome("João");
        profissional.setDescricao("Cardiologista");
        profissional.setHorario("00:00-00:00");
        profissional.setCrm(12345678);
        profissional.setEspecialidade("Cardiologista");
        profissional.setStatus(1);

        Vacinas vacinas=new Vacinas();
        vacinas.setNome("Tetano");
        vacinas.setDescricao("Descricao Vacina");
        vacinas.setValor((short)0);
        vacinas.setStatus(1);

        Usuario usuario=new Usuario();
        usuario.setTipo(1);

        Pais pais=new Pais();
        pais.setNome("Brasil");
        pais.setStatus(1);

        Estado estado=new Estado();
        estado.setNome("Goias");
        estado.setStatus(1);
        estado.setPais(pais);


        Cidade cidade=new Cidade();
        cidade.setNome("Anapolis");
        cidade.setStatus(1);
        cidade.setEstado(estado);


        Bairro bairro=new Bairro();
        bairro.setNome("nome Bairro");
        bairro.setCidade(cidade);
        bairro.setStatus(1);

        Rua rua=new Rua();
        rua.setNome("Rua brasil");
        rua.setStatus(1);
        rua.setBairro(bairro);



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
        complemento.setDescricao("qd 1,lt2");

        Imagem imagem=new Imagem();
        imagem.setNome("nome da imagem");
        imagem.setStatus(1);
        imagem.setLink("Link");
        imagem.setUrl("/img/huana.jpg");



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




        Endereco endereco =new Endereco();
        endereco.setRua(rua);
        endereco.setStatus(1);
        endereco.setLatitude("35.3333");
        endereco.setLongitude("40.2222");
        endereco.setRua(rua);
        endereco.setComplemento(complemento);





        e.setNome("Raiox");
        e.setDescricao("Gratuito");
        e.setHorario("00:00-00:00");
        e.setStatus(1);
        e.setValor((short)123);

        UnidadeDeSaude unidadeDeSaude = new UnidadeDeSaude();
        unidadeDeSaude.setNome("Huana");
        unidadeDeSaude.setStatus(1);
        unidadeDeSaude.setDescricao("A Unidade de Saúde atua através de um contrato de gestão a pedido do Governo do Estado de Goiás/Secretaria Estadual de Saúde com a FASA ");
        unidadeDeSaude.setUrl("https://www.google.com.br/maps/place/Hospital+de+Urg%C3%AAncias+Dr.+Henrique+Santillo/@-16.2991781,-48.9442706,17z/data=!3m1!4b1!4m5!3m4!1s0x935ea418d2836dd3:0x7193ccf5f2b6a99b!8m2!3d-16.2991781!4d-48.9420819");
        unidadeDeSaude.setHorario("00:00-00:00");
        unidadeDeSaude.setEndereco(endereco);
        unidadeDeSaudeRepositorio.save(unidadeDeSaude);

        PlantaoDia plantaoDia=new PlantaoDia();
        plantaoDia.setStatus(1);
        plantaoDia.setDescricao("descricao plantao DIa");
        plantaoDia.setData(new Date());
        plantaoDia.setHorario("00:00-00:00");
        plantaoDia.setProfissional(profissional);


        List<PlantaoDia> plantao=new ArrayList();

       unidadeDeSaude.setPlantaoDia(plantao);


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

