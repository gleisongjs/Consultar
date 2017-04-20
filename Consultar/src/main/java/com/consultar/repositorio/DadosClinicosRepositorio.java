package com.consultar.repositorio;

import com.consultar.entidade.DadosClinico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Gleisongjs on 20/03/2017.
 */

@Repository
public interface DadosClinicosRepositorio extends JpaRepository<DadosClinico, Long> {
    //DadosClinico findByEmail(String email);
}
