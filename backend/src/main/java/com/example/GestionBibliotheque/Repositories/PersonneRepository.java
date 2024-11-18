package com.example.GestionBibliotheque.Repositories;

import com.example.GestionBibliotheque.Models.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonneRepository extends JpaRepository<Personne, Integer> {
    List<Personne> findAllById(@Param("id_personne") Integer id_personne);
}
