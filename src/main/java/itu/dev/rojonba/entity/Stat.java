package itu.dev.rojonba.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "stat_match_joueur")
public class Stat {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen")
    @SequenceGenerator(name = "gen", sequenceName = "stat_match_joueur_idstat_seq", allocationSize = 1)
    @Column(name = "idstat")
    private Integer idStat;

    public Stat(Match match, Joueur joueur, Integer rebond, Integer passedecisive, Integer interception, Integer contre, Integer minjoue, Integer lanceeMarque, Integer lanceeDonne, Integer tentative3pts, Integer marque3pts, Integer tentative2pts, Integer marque2pts) throws Exception {
        if(marque2pts.intValue() > tentative2pts.intValue())throw  new Exception("Tentative inférieur à 2 points marqués");
        if(marque3pts.intValue() > tentative3pts.intValue())throw  new Exception("Tentative inférieur à 3 points marqués");
        setMatch(match);
        setJoueur(joueur);
        setRebond(rebond);
        setPassedecisive(passedecisive);
        setInterception(interception);
        setContre(contre);
        setMinjoue(minjoue);
        setLancee_donne(lanceeDonne);
        setLancee_marque(lanceeMarque);
        setMarque2pts(marque2pts);
        setMarque3pts(marque3pts);
        setTentative2pts(tentative2pts);
        setTentative3pts(tentative3pts);
        setTotalpoint(marque2pts*2+marque3pts*3+lanceeMarque);
    }

    public Stat() {

    }

    public Integer getRebond() {
        return rebond;
    }

    public void setRebond(Integer rebond) throws Exception{
        if(rebond.intValue() < 0)throw new Exception("Nombre de rebond non acceptable");
        this.rebond = rebond;
    }

    public Integer getPassedecisive() {
        return passedecisive;
    }

    public void setPassedecisive(Integer passedecisive) throws Exception{
        if(passedecisive.intValue() < 0)throw new Exception("Nombre de passe décisive non acceptable");
        this.passedecisive = passedecisive;
    }

    public Integer getInterception() {
        return interception;
    }

    public void setInterception(Integer interception) throws Exception{
        if(interception.intValue() < 0)throw new Exception("Nombre d'interception non acceptable");
        this.interception = interception;
    }

    public Integer getContre() {
        return contre;
    }

    public void setContre(Integer contre) throws Exception{
        if(contre.intValue() < 0)throw new Exception("Nombre de contre non acceptable");
        this.contre = contre;
    }

    public Integer getMinjoue() {
        return minjoue;
    }

    public void setMinjoue(Integer minjoue) throws Exception{
        if(minjoue.intValue() < 0)throw new Exception("Nombre de minutes jouées non acceptable");
        this.minjoue = minjoue;
    }

    public Integer getLancee_marque() {
        return lancee_marque;
    }

    public void setLancee_marque(Integer lancee_marque) throws Exception{
        if(lancee_marque.intValue() < 0)throw new Exception("Nombre de lancé marqué non acceptable");
        this.lancee_marque = lancee_marque;
    }

    public Integer getLancee_donne() {
        return lancee_donne;
    }

    public void setLancee_donne(Integer lancee_donne) throws Exception{
        if(lancee_donne.intValue() < 0)throw new Exception("Nombre de lancé donné non acceptable");
        this.lancee_donne = lancee_donne;
    }

    public Integer getTentative3pts() {
        return tentative3pts;
    }

    public void setTentative3pts(Integer tentative3pts) throws Exception{
        if(tentative3pts.intValue() < 0)throw new Exception("Nombre de tentative à 3 points non acceptable");
        this.tentative3pts = tentative3pts;
    }

    public Integer getMarque3pts() {
        return marque3pts;
    }

    public void setMarque3pts(Integer marque3pts) throws Exception{
        if(marque3pts.intValue() < 0)throw new Exception("Nombre de 3 points marqué non acceptable");
        this.marque3pts = marque3pts;
    }

    public Integer getTentative2pts() {
        return tentative2pts;
    }

    public void setTentative2pts(Integer tentative2pts) throws Exception{
        if(tentative2pts.intValue() < 0)throw new Exception("Nombre de tentative à 2 points non acceptable");
        this.tentative2pts = tentative2pts;
    }

    public Integer getMarque2pts() {
        return marque2pts;
    }

    public void setMarque2pts(Integer marque2pts) throws Exception{
        if(marque2pts.intValue() < 0)throw new Exception("Nombre de 2 points marqué non acceptable");
        this.marque2pts = marque2pts;
    }

    private Integer rebond;
    private Integer passedecisive;
    private Integer interception;
    private Integer contre;
    private Integer minjoue;
    private Integer lancee_marque;
    private Integer lancee_donne;
    private Integer tentative3pts;
    private Integer marque3pts;
    private Integer tentative2pts;
    private Integer marque2pts;

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    public Integer getTotalpoint() {
        return totalpoint;
    }

    public void setTotalpoint(Integer totalpoint) {
        this.totalpoint = totalpoint;
    }

    @Column(name = "totalpoint")
    private Integer totalpoint;

    public void setIdStat(Integer idStat) {
        this.idStat = idStat;
    }

    public Integer getIdStat() {
        return idStat;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="match", referencedColumnName = "idMatch")
    private Match match;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="joueur", referencedColumnName = "idJoueur")
    private Joueur joueur;

}
