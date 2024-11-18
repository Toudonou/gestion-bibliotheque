package com.example.GestionBibliotheque.Models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "emprunte")
public class Emprunte {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_emprunt")
    private Integer id;

    @Column(name = "id_livre")
    private String id_livre;

    @Column(name = "id_personne")
    private Integer id_personne;

    @Column(name = "date_emprunt")
    private LocalDate dateEmprunt;

    @Column(name = "date_retour_estimee")
    private LocalDate dateRetourEstimee;

    @Column(name = "date_retour")
    private LocalDate dateRetour;
}