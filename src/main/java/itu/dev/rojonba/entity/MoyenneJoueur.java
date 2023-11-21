package itu.dev.rojonba.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="moyenne_joueur_view")
public class MoyenneJoueur {
    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    @Column(name = "joueur")
    private Integer id;

    public double getRebond() {
        return rebond;
    }

    public void setRebond(double rebond) {
        this.rebond = rebond;
    }

    public double getPassedecisive() {
        return passedecisive;
    }

    public void setPassedecisive(double passedecisive) {
        this.passedecisive = passedecisive;
    }

    public double getInterception() {
        return interception;
    }

    public void setInterception(double interception) {
        this.interception = interception;
    }

    public double getContre() {
        return contre;
    }

    public void setContre(double contre) {
        this.contre = contre;
    }

    public double getMinjoue() {
        return minjoue;
    }

    public void setMinjoue(double minjoue) {
        this.minjoue = minjoue;
    }

    public double getLancee() {
        return lancee;
    }

    public void setLancee(double lancee) {
        this.lancee = lancee;
    }

    public double getP3pts() {
        return p3pts;
    }

    public void setP3pts(double p3pts) {
        this.p3pts = p3pts;
    }

    public double getP2pts() {
        return p2pts;
    }

    public void setP2pts(double p2pts) {
        this.p2pts = p2pts;
    }

    private double rebond;
    private double passedecisive;
    private double interception;
    private double contre;
    private double minjoue;
    private double lancee;
    private double p3pts;
    private double p2pts;

    public double getMatchjoue() {
        return matchjoue;
    }

    public void setMatchjoue(double matchjoue) {
        this.matchjoue = matchjoue;
    }

    public double getPoins() {
        return poins;
    }

    public void setPoins(double poins) {
        this.poins = poins;
    }

    private double matchjoue;
    private double poins;

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    private double points;

    public Integer getId() {
        return id;
    }
}
