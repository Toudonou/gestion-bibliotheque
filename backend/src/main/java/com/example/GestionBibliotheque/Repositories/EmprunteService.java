package com.example.GestionBibliotheque.Repositories;

import com.example.GestionBibliotheque.Models.Emprunte;
import com.example.GestionBibliotheque.Models.Personne;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class EmprunteService {
    private final EmprunteRepository emprunteRepository;
    private final PersonneRepository personneRepository;

    public EmprunteService(EmprunteRepository emprunteRepository, PersonneRepository personneRepository) {
        this.emprunteRepository = emprunteRepository;
        this.personneRepository = personneRepository;
    }

    public List<Map<String, Object>> getEmpruntByIdLivre(String id_livre) {
        // récupérer les emprunts
        List<Emprunte> emprunts = emprunteRepository.findAllById_livre(id_livre);
        // récupérer les personnes
        List<Personne> personnes = new ArrayList<>();
        for (Emprunte emprunt : emprunts) {
            personnes.addAll(personneRepository.findAllById(emprunt.getId_personne()));
        }

        List<Map<String, Object>> result = new ArrayList<>();
        for (int i = 0; i < emprunts.size(); i++) {
            Emprunte emprunt = emprunts.get(i);
            Personne personne = personnes.get(i);
            Map<String, Object> map = Map.of(
                "id_emprunt", emprunt.getId(),
                "id_personne", personne.getId(),
                "nom_personne", personne.getNom(),
                "prenom_personne", personne.getPrenom(),
                "id_livre", emprunt.getId_livre(),
                "date_emprunt", emprunt.getDateEmprunt(),
                "date_retour", emprunt.getDateRetour()
            );
            result.add(map);
        }
        return result;
    }
}
