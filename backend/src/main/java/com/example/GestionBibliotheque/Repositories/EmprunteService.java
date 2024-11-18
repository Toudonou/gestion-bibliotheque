package com.example.GestionBibliotheque.Repositories;

import com.example.GestionBibliotheque.Models.Emprunte;
import com.example.GestionBibliotheque.Models.Livre;
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
    private final LivreRepository livreRepository;

    public EmprunteService(EmprunteRepository emprunteRepository, PersonneRepository personneRepository, LivreRepository livreRepository) {
        this.emprunteRepository = emprunteRepository;
        this.personneRepository = personneRepository;
        this.livreRepository = livreRepository;
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
            if(emprunt.getDateRetour() != null) continue; // ne pas afficher les emprunts déjà retournés
            Personne personne = personnes.get(i);
            HashMap<String, Object> map = new HashMap<>();
            map.put("id_emprunt", emprunt.getId());
            map.put("id_personne", personne.getId());
            map.put("nom_personne", personne.getNom());
            map.put("prenom_personne", personne.getPrenom());
            map.put("id_livre", emprunt.getId_livre());
            map.put("date_emprunt", emprunt.getDateEmprunt());
            map.put("date_retour", emprunt.getDateRetour());
            map.put("date_retour_prevue", emprunt.getDateRetourEstimee());
            result.add(map);
        }
        return result;
    }

    public void emprunterLivre(String id_livre){

        // vérifier si le livre est disponible
        Livre livre = livreRepository.findById(id_livre).orElse(null);
        if(livre == null){
            return;
        }
        long nombreExamplairesRestants = livre.getNombreExamplairesRestants();
        if(nombreExamplairesRestants == 0){
            return;
        } else {
            //livre.setNombreExamplairesRestants(nombreExamplairesRestants - 1);
            livreRepository.save(livre);
        }

        Emprunte emprunt = new Emprunte();
        emprunt.setId(emprunteRepository.findAll().size() + 1);
        emprunt.setId_livre(id_livre);
        emprunt.setId_personne(1); // id de la personne qui emprunte le livre
        emprunt.setDateEmprunt(java.time.LocalDate.now());
        emprunteRepository.save(emprunt);
    }
}
