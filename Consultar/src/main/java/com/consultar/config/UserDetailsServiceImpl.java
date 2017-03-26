package com.consultar.config;


import com.consultar.entidade.Permissao;
import com.consultar.entidade.Pessoa;
import com.consultar.repositorio.PessoaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service("userDetailsService")
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    private PessoaRepositorio pessoaRepositorio;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Pessoa pessoa = pessoaRepositorio.findByEmail(email);
        if(pessoa!= null) {
            System.out.println("USUARIO ENCONTRADO");
            List<GrantedAuthority> authorities = this.buildUserAuthority(pessoa.getPermissoes());
            return this.buildUserForAuthentication(pessoa, authorities);
        } else {
            throw new Error("USUARIO NÃO EXISTE");
        }
    }

    // conver entidade pessoa para um user(security)
    private User buildUserForAuthentication(Pessoa pessoa, List<GrantedAuthority> authorities){
        return new User(pessoa.getEmail(), pessoa.getSenha(), true, true, true, true, authorities);
    }

    // converte as permissões de usuário
    private List<GrantedAuthority> buildUserAuthority(List<Permissao> permissoes){
        List<GrantedAuthority> result = new ArrayList<GrantedAuthority>();
        for(Permissao permissao : permissoes){
            result.add(new SimpleGrantedAuthority(permissao.getNome()));
        }
        return result;
    }

}