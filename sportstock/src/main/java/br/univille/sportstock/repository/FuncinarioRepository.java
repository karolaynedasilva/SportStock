package br.univille.sportstock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.sportstock.entity.Funcionario;

@Repository
public interface FuncinarioRepository extends JpaRepository<Funcionario, Long>{
    
    
}
