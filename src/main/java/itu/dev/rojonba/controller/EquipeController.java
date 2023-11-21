package itu.dev.rojonba.controller;

import itu.dev.rojonba.entity.Equipe;
import itu.dev.rojonba.repository.EquipeRepository;
import itu.dev.rojonba.services.JoueurServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EquipeController {
    EquipeRepository equipeRepository;

    public EquipeController(EquipeRepository equipeRepository) {
        this.equipeRepository = equipeRepository;
    }

    @GetMapping(path = "/equipes")
    public List<Equipe> getEquipes(){
        return equipeRepository.findAll();
    }

    @PostMapping(path = "/equipes")
    public ResponseEntity<String> insertEquipe(String nom_equipe){
        Equipe e = new Equipe();
        e.setNom_equipe(nom_equipe);
        equipeRepository.save(e);
        return new ResponseEntity<>("Insertion OK", HttpStatus.OK);
    }

}
