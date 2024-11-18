package com.example.GestionBibliotheque.Repositories;

import com.example.GestionBibliotheque.Models.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivreRepository extends JpaRepository<Livre, String> {
    List<Livre> findAllByOrderByAuteurAsc();
}
