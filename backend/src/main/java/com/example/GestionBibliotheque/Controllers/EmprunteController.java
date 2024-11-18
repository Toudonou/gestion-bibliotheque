package com.example.GestionBibliotheque.Controllers;

import com.example.GestionBibliotheque.Models.Emprunte;
import com.example.GestionBibliotheque.Models.Personne;
import com.example.GestionBibliotheque.Repositories.EmprunteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprunts")
@CrossOrigin()
public class EmprunteController {
    private final EmprunteRepository emprunteRepository;

    public EmprunteController(EmprunteRepository emprunteRepository) {
        this.emprunteRepository = emprunteRepository;
    }

    @GetMapping("/{id_livre}")
    public List<Emprunte> getEmpruntByIdLivre(@PathVariable("id_livre") String id_livre) {
        return emprunteRepository.findAllById_livre(id_livre);
    }

    @GetMapping
    public List<Emprunte> getAllEmprunts() {
        return emprunteRepository.findAll();
    }
}