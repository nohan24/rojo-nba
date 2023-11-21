
CREATE TABLE equipe(
    idEquipe SERIAL PRIMARY KEY ,
    nom_equipe VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE match(
    idMatch SERIAL PRIMARY KEY,
    date_match DATE NOT NULL ,
    equipe_visiteuse INT,
    equipe_locale INT,
    FOREIGN KEY (equipe_locale) REFERENCES equipe(idEquipe),
    FOREIGN KEY (equipe_visiteuse) REFERENCES equipe(idEquipe)
);

CREATE TABLE joueur(
    idJoueur SERIAL PRIMARY KEY ,
    nom_joueur VARCHAR(100) NOT NULL,
    equipe INT,
    FOREIGN KEY (equipe) REFERENCES equipe(idEquipe)
);

CREATE TABLE stat_match_joueur(
    idStat SERIAL PRIMARY KEY ,
    match INT,
    joueur INT,
    rebond INT default 0,
    passedecisive INT default 0,
    interception INT default 0,
    contre INT default 0,
    minjoue INT default 0,
    lancee_donne INT default 0,
    lancee_marque INT default 0,
    tentative3pts INT default 0,
    marque3pts INT default 0,
    tentative2pts INT default 0,
    marque2pts INT DEFAULT 0,
    totalPoint INT default 0,
    FOREIGN KEY (match) REFERENCES match(idMatch),
    FOREIGN KEY (joueur) REFERENCES joueur(idJoueur),
    UNIQUE (match,joueur)
);

CREATE OR REPLACE VIEW stat_joueur_view AS SELECT joueur, sum(totalPoint) as points,count(joueur) as matchjoue, sum(rebond) as rebond, sum(passedecisive) as passedecisive, sum(interception) as interception, sum(contre) as contre, sum(minjoue) as minjoue, sum(lancee_donne) as lancee_donne, sum(lancee_marque) as lancee_marque, sum(tentative3pts) as tentative3pts, sum(marque3pts) as marque3pts, sum(tentative2pts) as tentative2pts, sum(marque2pts) as marque2pts FROM (SELECT * FROM stat_match_joueur where minjoue > 0) as m GROUP BY joueur;
CREATE OR REPLACE VIEW moyenne_joueur_view AS SELECT joueur, sum(totalPoint)/count(joueur) as points,count(joueur) as matchjoue, sum(rebond)/count(joueur) as rebond, sum(passedecisive)/count(joueur) as passedecisive, sum(interception)/count(joueur) as interception, sum(contre)/count(joueur)  as contre, sum(minjoue)/count(joueur)  as minjoue, sum(lancee_marque)*100/sum(lancee_donne) as lancee, sum(marque3pts)*100/sum(tentative3pts) as p3pts,sum(marque2pts)*100/sum(tentative2pts) as p2pts FROM (SELECT * FROM stat_match_joueur where minjoue > 0) as m GROUP BY joueur;
