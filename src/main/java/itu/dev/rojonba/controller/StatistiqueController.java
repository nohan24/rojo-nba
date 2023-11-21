package itu.dev.rojonba.controller;

import itu.dev.rojonba.entity.Joueur;
import itu.dev.rojonba.entity.Stat;
import itu.dev.rojonba.model.Moyenne;
import itu.dev.rojonba.repository.*;
import itu.dev.rojonba.services.JoueurServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StatistiqueController {
    EquipeRepository equipeRepository;
    JoueurServices joueurServices;
    JoueurRepository joueurRepository;
    MatchRepository matchRepository;
    StatistiqueRepository statistiqueRepository;
    MoyenneRepository moyenneRepository;

    public StatistiqueController(MoyenneRepository moyenneRepository, EquipeRepository equipeRepository, JoueurServices joueurServices, JoueurRepository joueurRepository, MatchRepository matchRepository, StatistiqueRepository statistiqueRepository) {
        this.equipeRepository = equipeRepository;
        this.joueurServices = joueurServices;
        this.joueurRepository = joueurRepository;
        this.matchRepository = matchRepository;
        this.statistiqueRepository = statistiqueRepository;
        this.moyenneRepository = moyenneRepository;
    }

    @GetMapping(path = "/statistique/equipes/{id}")
    public List<Moyenne> getEquipeStatistique(@PathVariable("id") Integer equipe){
        return joueurServices.statistiques(equipe);
    }

    @PostMapping(path = "/statistique")
    public ResponseEntity<String> addStatistiqueJoueur(Integer match, Integer joueur, Integer rebond, Integer passedecisive, Integer interception, Integer contre, Integer minjoue, Integer lancee_marque, Integer lancee_donne, Integer tentative3pts, Integer marque3pts, Integer tentative2pts, Integer marque2pts){
        if(!joueurRepository.existsById(joueur)){
            return new ResponseEntity<>("Joueur non trouvé", HttpStatusCode.valueOf(404));
        }

        if(!matchRepository.existsById(match)){
            return new ResponseEntity<>("Match non trouvé", HttpStatusCode.valueOf(404));
        }

        try {
            Stat s = new Stat(matchRepository.findById(match).get(), joueurRepository.findById(joueur).get(), rebond, passedecisive, interception, contre, minjoue, lancee_marque, lancee_donne, tentative3pts, marque3pts, tentative2pts, marque2pts);
            statistiqueRepository.save(s);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>("Statistique du match du joueur ajouté", HttpStatus.OK);
    }
}
