package com.example.GestionBibliotheque.Controllers;

import com.example.GestionBibliotheque.Models.Livre;
import com.example.GestionBibliotheque.Repositories.LivreRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/livre")
@CrossOrigin()
public class LivreController {
    private final LivreRepository livreRepository;

    public LivreController(LivreRepository livreRepository) {
        this.livreRepository = livreRepository;
    }

    @GetMapping
    public List<Livre> getAllLivres(){
        return livreRepository.findAll();
    }

    @GetMapping("/orderedByAuteur")
    public List<Livre> getLivresOrderedByAuteur(){
        return livreRepository.findAllByOrderByAuteurAsc();
    }
}
