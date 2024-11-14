package com.example.GestionBibliotheque.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "personne")
public class Personne {
    @Id
    @Column(name = "id_personne")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "mail")
    private String mail;
}
