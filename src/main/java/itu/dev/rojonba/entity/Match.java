package itu.dev.rojonba.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Entity
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen")
    @SequenceGenerator(name = "gen", sequenceName = "match_idmatch_seq", allocationSize = 1)
    @Column(name = "idmatch")
    private Integer idMatch;

    public Date getDate_match() {
        return date_match;
    }

    public void setDate_match(String date_match) {
        this.date_match = new Date(date_match);
    }

    public Equipe getEquipe_v() {
        return equipe_v;
    }

    public void setEquipe_v(Equipe equipe_v) {
        this.equipe_v = equipe_v;
    }

    public Equipe getEquipe_l() {
        return equipe_l;
    }

    public void setEquipe_l(Equipe equipe_l) {
        this.equipe_l = equipe_l;
    }

    private Date date_match;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="equipe_visiteuse", referencedColumnName = "idEquipe")
    private Equipe equipe_v;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="equipe_locale", referencedColumnName = "idEquipe")
    private Equipe equipe_l;

    public void setIdMatch(Integer idMatch) {
        this.idMatch = idMatch;
    }

    public Integer getIdMatch() {
        return idMatch;
    }
}
