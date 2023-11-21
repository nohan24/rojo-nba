package itu.dev.rojonba.controller;

import itu.dev.rojonba.entity.Match;
import itu.dev.rojonba.repository.EquipeRepository;
import itu.dev.rojonba.repository.MatchRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
public class MatchController {
    public MatchController(EquipeRepository equipeRepository, MatchRepository matchRepository) {
        this.equipeRepository = equipeRepository;
        this.matchRepository = matchRepository;
    }

    EquipeRepository equipeRepository;
    MatchRepository matchRepository;
    @PostMapping(path = "/matchs")
    public ResponseEntity<String> insertMatch(String date, Integer equipe_v, Integer equipe_l) {
        Match m = new Match();
        m.setDate_match(date);

        m.setEquipe_l(equipeRepository.findById(equipe_l).get());
        m.setEquipe_v(equipeRepository.findById(equipe_v).get());
        matchRepository.save(m);
        return new ResponseEntity<>("Insérer", HttpStatus.OK);
    }

    @GetMapping(path = "/matchs")
    public List<Match> getMatchs(){
        return matchRepository.findAll();
    }
}
