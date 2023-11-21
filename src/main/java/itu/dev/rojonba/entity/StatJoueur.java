package itu.dev.rojonba.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "stat_joueur_view ")
public class StatJoueur {
    @Id
    @Column(name = "joueur")
    private Integer joueur;

    public Integer getRebond() {
        return rebond;
    }

    public void setRebond(Integer rebond) {
        this.rebond = rebond;
    }

    public Integer getPassedecisive() {
        return passedecisive;
    }

    public void setPassedecisive(Integer passedecisive) {
        this.passedecisive = passedecisive;
    }

    public Integer getInterception() {
        return interception;
    }

    public void setInterception(Integer interception) {
        this.interception = interception;
    }

    public Integer getContre() {
        return contre;
    }

    public void setContre(Integer contre) {
        this.contre = contre;
    }

    public Integer getMinjoue() {
        return minjoue;
    }

    public void setMinjoue(Integer minjoue) {
        this.minjoue = minjoue;
    }

    public Integer getLancee_marque() {
        return lancee_marque;
    }

    public void setLancee_marque(Integer lancee_marque) {
        this.lancee_marque = lancee_marque;
    }

    public Integer getLancee_donne() {
        return lancee_donne;
    }

    public void setLancee_donne(Integer lancee_donne) {
        this.lancee_donne = lancee_donne;
    }

    public Integer getTentative3pts() {
        return tentative3pts;
    }

    public void setTentative3pts(Integer tentative3pts) {
        this.tentative3pts = tentative3pts;
    }

    public Integer getMarque3pts() {
        return marque3pts;
    }

    public void setMarque3pts(Integer marque3pts) {
        this.marque3pts = marque3pts;
    }

    public Integer getTentative2pts() {
        return tentative2pts;
    }

    public void setTentative2pts(Integer tentative2pts) {
        this.tentative2pts = tentative2pts;
    }

    public Integer getMarque2pts() {
        return marque2pts;
    }

    public void setMarque2pts(Integer marque2pts) {
        this.marque2pts = marque2pts;
    }

    public Integer getMatchjoue() {
        return matchjoue;
    }

    public void setMatchjoue(Integer matchjoue) {
        this.matchjoue = matchjoue;
    }

    private Integer rebond, passedecisive, interception,contre, minjoue, lancee_marque,lancee_donne, tentative3pts, marque3pts, tentative2pts, marque2pts, matchjoue;


    public void setJoueur(Integer joueur) {
        this.joueur = joueur;
    }

    public Integer getJoueur() {
        return joueur;
    }
}
