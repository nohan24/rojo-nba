package itu.dev.rojonba.model;

import itu.dev.rojonba.entity.Joueur;
import itu.dev.rojonba.entity.MoyenneJoueur;

import java.util.function.Supplier;

public class Moyenne {
    public Moyenne(Joueur j, MoyenneJoueur moyenne) {
        setJ(j);
        setM(moyenne);
    }

    public Moyenne() {

    }

    public Joueur getJ() {
        return j;
    }

    public void setJ(Joueur j) {
        this.j = j;
    }

    public MoyenneJoueur getM() {
        return m;
    }

    public void setM(MoyenneJoueur m) {
        this.m = m;
    }

    Joueur j;
    MoyenneJoueur m;
}
