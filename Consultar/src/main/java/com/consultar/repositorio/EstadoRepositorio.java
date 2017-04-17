package com.consultar.repositorio;


import com.consultar.entidade.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Gleisongjs on 20/03/2017.
 */

@Repository
public interface EstadoRepositorio extends JpaRepository<Estado, Long> {

}
