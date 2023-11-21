package itu.dev.rojonba.repository;

import itu.dev.rojonba.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Integer> {
}
