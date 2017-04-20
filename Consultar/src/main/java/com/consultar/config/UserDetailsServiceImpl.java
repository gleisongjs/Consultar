package com.consultar.config;


import com.consultar.entidade.Acesso;
import com.consultar.entidade.Permissao;
import com.consultar.repositorio.AcessoRepositorio;
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
    private AcessoRepositorio pessoaRepositorio;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Acesso acesso = pessoaRepositorio.findByEmail(email);
        if(acesso!= null) {
            System.out.println("USUARIO "+email+"ENCONTRADO");
            List<GrantedAuthority> authorities = this.buildUserAuthority(acesso.getPermissoes());
            return this.buildUserForAuthentication(acesso, authorities);
        } else {
            throw new Error("USUARIO NÃO EXISTE");
        }
    }

    // conver entidade pessoa para um user(security)
    private User buildUserForAuthentication(Acesso acesso, List<GrantedAuthority> authorities){
        return new User(acesso.getEmail(), acesso.getSenha(), true, true, true, true, authorities);
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