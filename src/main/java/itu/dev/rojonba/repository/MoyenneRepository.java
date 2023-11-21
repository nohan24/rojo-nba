package itu.dev.rojonba.repository;

import itu.dev.rojonba.entity.MoyenneJoueur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoyenneRepository extends JpaRepository<MoyenneJoueur, Integer> {
}
