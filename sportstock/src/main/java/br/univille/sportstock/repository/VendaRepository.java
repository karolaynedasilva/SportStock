package br.univille.sportstock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.univille.sportstock.entity.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

}
