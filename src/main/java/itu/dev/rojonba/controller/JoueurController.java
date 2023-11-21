package itu.dev.rojonba.controller;

import itu.dev.rojonba.entity.Equipe;
import itu.dev.rojonba.entity.Joueur;
import itu.dev.rojonba.repository.EquipeRepository;
import itu.dev.rojonba.repository.JoueurRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JoueurController {
    public JoueurController(JoueurRepository joueurRepository, EquipeRepository equipeRepository) {
        this.joueurRepository = joueurRepository;
        this.equipeRepository = equipeRepository;
    }

    JoueurRepository joueurRepository;
    EquipeRepository equipeRepository;
    @PostMapping(path = "/joueurs")
    public ResponseEntity<String> insertJoueur(String nom_joueur, Integer equipe)  {
        Equipe e = equipeRepository.findById(equipe).get();
        Joueur j = new Joueur();
        j.setEquipe(e);
        try {
            j.setNom_joueur(nom_joueur);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
        joueurRepository.save(j);
        return new ResponseEntity<>("Insérer", HttpStatus.OK);
    }

    @GetMapping(path = "/joueurs")
    public List<Joueur> getJoueurs() {
        return joueurRepository.findAll();
    }
}
