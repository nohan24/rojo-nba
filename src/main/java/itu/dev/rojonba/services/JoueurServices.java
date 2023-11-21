package itu.dev.rojonba.services;

import itu.dev.rojonba.entity.Joueur;
import itu.dev.rojonba.entity.MoyenneJoueur;
import itu.dev.rojonba.model.Moyenne;
import itu.dev.rojonba.repository.EquipeRepository;
import itu.dev.rojonba.repository.JoueurRepository;
import itu.dev.rojonba.repository.MoyenneRepository;
import itu.dev.rojonba.repository.StatistiqueRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JoueurServices {
    private StatistiqueRepository statistiqueRepository;
    private JoueurRepository joueurRepository;
    private MoyenneRepository moyenneRepository;
    private EquipeRepository equipeRepository;

    public JoueurServices(MoyenneRepository moyenneRepository,JoueurRepository joueurRepository,StatistiqueRepository statistiqueRepository, EquipeRepository equipeRepository) {
        this.statistiqueRepository = statistiqueRepository;
        this.joueurRepository = joueurRepository;
        this.moyenneRepository = moyenneRepository;
        this.equipeRepository = equipeRepository;
    }

    public List<Moyenne> statistiques(Integer equipe){
        List<Moyenne> ret = new ArrayList<>();
        for(Joueur j : joueurRepository.findAllByEquipe(equipeRepository.findById(equipe).get())){
            ret.add(new Moyenne(j, moyenneRepository.findById(j.getIdJoueur()).orElseGet(MoyenneJoueur::new)));
        }
        return ret;
    }
}
