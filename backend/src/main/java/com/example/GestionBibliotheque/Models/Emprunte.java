package com.example.GestionBibliotheque.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "emprunte")
public class Emprunte {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_emprunt")
    private Integer id;

    @Column(name = "id_livre")
    private String id_livre;

    @Column(name = "id_personne")
    private Integer id_personne;

    @Column(name = "date_emprunt")
    private Integer dateEmprunt;

    @Column(name = "date_retour_estimee")
    private Integer dateRetourEstimee;

    @Column(name = "date_retour")
    private Integer dateRetour;
}