package com.example.GestionBibliotheque.Controllers;

import com.example.GestionBibliotheque.Models.Emprunte;
import com.example.GestionBibliotheque.Models.Personne;
import com.example.GestionBibliotheque.Repositories.EmprunteRepository;
import com.example.GestionBibliotheque.Repositories.EmprunteService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/emprunts")
@CrossOrigin()
public class EmprunteController {
    private final EmprunteRepository emprunteRepository;
    private final EmprunteService emprunteService;

    public EmprunteController(EmprunteRepository emprunteRepository, EmprunteService emprunteService) {
        this.emprunteRepository = emprunteRepository;
        this.emprunteService = emprunteService;
    }

    @GetMapping("/{id_livre}")
    public List<HashMap<String, Object>> getEmpruntByIdLivre(@PathVariable("id_livre") String id_livre) {
        return emprunteService.getEmpruntByIdLivre(id_livre);
    }

    @GetMapping
    public List<Emprunte> getAllEmprunts() {
        return emprunteRepository.findAll();
    }
}