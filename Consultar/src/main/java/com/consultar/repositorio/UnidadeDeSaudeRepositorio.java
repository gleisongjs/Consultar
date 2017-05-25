package com.consultar.repositorio;


import com.consultar.entidade.UnidadeDeSaude;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Gleisongjs on 20/03/2017.
 */

@Repository
public interface UnidadeDeSaudeRepositorio extends JpaRepository<UnidadeDeSaude, Integer> {
    UnidadeDeSaude findOne(int id);
}
