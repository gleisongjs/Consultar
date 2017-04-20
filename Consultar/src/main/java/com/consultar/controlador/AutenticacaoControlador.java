package com.consultar.controlador;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class AutenticacaoControlador {

    @RequestMapping(value = "/login")
    public Principal user(Principal user) {
        System.out.println("AutenticacaoControlador"+user);
        return user;
    }

}

