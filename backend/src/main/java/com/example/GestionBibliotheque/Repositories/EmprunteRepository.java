package com.example.GestionBibliotheque.Repositories;

import com.example.GestionBibliotheque.Models.Emprunte;
import com.example.GestionBibliotheque.Models.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmprunteRepository extends JpaRepository<Emprunte, Integer> {

    @Query("SELECT p FROM Personne p JOIN Emprunte e ON p.id = e.id_personne WHERE e.id_livre = :id_livre")
    List<Personne> findAllPersonnesWhoEmpruntedBooks(@Param("id_livre") Integer id_livre);
}