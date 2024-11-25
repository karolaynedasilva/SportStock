package br.univille.sportstock.repository;

import br.univille.sportstock.entity.User;
import br.univille.sportstock.entity.UserRole;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<UserRole> findByUsernameAndActiveTrue(String username);
}
