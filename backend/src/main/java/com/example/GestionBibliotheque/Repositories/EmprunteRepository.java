package com.example.GestionBibliotheque.Repositories;

import com.example.GestionBibliotheque.Models.Emprunte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface EmprunteRepository extends JpaRepository<Emprunte, Integer> {
    @Query("SELECT e FROM Emprunte e WHERE e.id_livre = :id_livre")
    List<Emprunte> findAllById_livre(@Param("id_livre") String id_livre);

    //@Query("SELECT p,e,l FROM Personne p JOIN Emprunte e ON p.id = e.id_personne JOIN Livre l ON e.id_livre = l.id WHERE e.id_livre = :id_livre")
    //List<Map<String, Object>> findAllAboutWhoEmpruntedBookByBookId(@Param("id_livre") String id_livre);
}