package com.consultar.repositorio;


import com.consultar.entidade.FeedNoticias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Gleisongjs on 20/03/2017.
 */

@Repository
public interface FeedNoticiasRepositorio extends JpaRepository<FeedNoticias, Long> {
    FeedNoticias findOne(long id);
}
