package br.univille.sportstock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.sportstock.entity.Franquiado;

@Repository
public interface FranquiadoRepository extends JpaRepository<Franquiado,Long>{
    
}
