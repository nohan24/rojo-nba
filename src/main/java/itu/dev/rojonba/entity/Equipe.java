package itu.dev.rojonba.entity;

import jakarta.persistence.*;

@Entity
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen")
    @SequenceGenerator(name = "gen", sequenceName = "equipe_idequipe_seq", allocationSize = 1)
    @Column(name="idequipe")
    private Integer idEquipe;

    public String getNom_equipe() {
        return nom_equipe;
    }

    public void setNom_equipe(String nom_equipe) {
        this.nom_equipe = nom_equipe;
    }

    private String nom_equipe;

    public void setIdEquipe(Integer idEquipe) {
        this.idEquipe = idEquipe;
    }

    public Integer getIdEquipe() {
        return idEquipe;
    }
}
