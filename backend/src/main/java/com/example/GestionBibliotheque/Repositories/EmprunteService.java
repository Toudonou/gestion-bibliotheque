package com.example.GestionBibliotheque.Repositories;

import com.example.GestionBibliotheque.Models.Emprunte;
import com.example.GestionBibliotheque.Models.Personne;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
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

    public List<HashMap<String, Object>> getEmpruntByIdLivre(String id_livre) {
        // récupérer les emprunts
        List<Emprunte> emprunts = emprunteRepository.findAllById_livre(id_livre);
        // récupérer les personnes
        List<Personne> personnes = new ArrayList<>();
        for (Emprunte emprunt : emprunts) {
            personnes.addAll(personneRepository.findAllById(emprunt.getId_personne()));
        }

        List<HashMap<String, Object>> result = new ArrayList<>();
        for (int i = 0; i < emprunts.size(); i++) {
            Emprunte emprunt = emprunts.get(i);
            Personne personne = personnes.get(i);
            HashMap<String, Object> map = new HashMap<>();
            map.put("id_emprunt", emprunt.getId());
            map.put("id_personne", personne.getId());
            map.put("nom", personne.getNom());
            map.put("prenom", personne.getPrenom());
            map.put("id_livre", emprunt.getId_livre());
            map.put("date_emprunt", emprunt.getDateEmprunt());
            map.put("date_retour", emprunt.getDateRetour());
            result.add(map);
        }
        return result;
    }
}
