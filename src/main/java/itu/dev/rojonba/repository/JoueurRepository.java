package itu.dev.rojonba.repository;

import itu.dev.rojonba.entity.Equipe;
import itu.dev.rojonba.entity.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JoueurRepository extends JpaRepository<Joueur, Integer> {
    List<Joueur> findAllByEquipe(Equipe equipe);
}
