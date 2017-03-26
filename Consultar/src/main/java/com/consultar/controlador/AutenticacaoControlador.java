package com.consultar.controlador;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Gleisongjs on 20/03/2017.
 */
@RestController
public class AutenticacaoControlador {

    @RequestMapping(name = "/login")
    public String login() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null && !(authentication instanceof AnonymousAuthenticationToken) && authentication.isAuthenticated()){
            return "AUTENTICADO";
        } else {
            return "NÃO ESTÁ AUTENTICADO";
        }
    }

}

