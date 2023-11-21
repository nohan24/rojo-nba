package itu.dev.rojonba.repository;

import itu.dev.rojonba.entity.Stat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatistiqueRepository extends JpaRepository<Stat, Integer> {
}
