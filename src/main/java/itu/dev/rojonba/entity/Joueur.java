package itu.dev.rojonba.entity;

import jakarta.persistence.*;

@Entity
public class Joueur {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen")
    @SequenceGenerator(name = "gen", sequenceName = "joueur_idjoueur_seq", allocationSize = 1)
    @Column(name="idjoueur")
    private Integer idJoueur;

    public String getNom_joueur() {
        return nom_joueur;
    }

    public void setNom_joueur(String nom_joueur) throws Exception {
        if(nom_joueur == null || nom_joueur == ""){
            throw new Exception("Nom de joueur requis");
        }
        this.nom_joueur = nom_joueur;
    }

    private String nom_joueur;

    public void setIdJoueur(Integer idJoueur) {
        this.idJoueur = idJoueur;
    }

    public Integer getIdJoueur() {
        return idJoueur;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="equipe", referencedColumnName = "idEquipe")
    private Equipe equipe;

    public void getStat(){

    }
}
