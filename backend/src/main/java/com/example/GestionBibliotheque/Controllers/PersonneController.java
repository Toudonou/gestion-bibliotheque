package com.example.GestionBibliotheque.Controllers;

import com.example.GestionBibliotheque.Models.Personne;
import com.example.GestionBibliotheque.Repositories.PersonneRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personnes")
@CrossOrigin()
public class PersonneController {
    private final PersonneRepository personneRepository;

    public PersonneController(PersonneRepository personneRepository) {
        this.personneRepository = personneRepository;
    }

    @GetMapping("/{id_personne}")
    public List<Personne> getPersonneById(@PathVariable("id_personne") Integer id_personne) {
        return personneRepository.findAllById(id_personne);
    }

    @GetMapping
    public List<Personne> getAllPersonnes() {
        return personneRepository.findAll();
    }
}
