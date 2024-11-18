package com.example.GestionBibliotheque.Models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "livre")
public class Livre {
    @Id
    @Column(name = "id_livre")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(name = "ISBN")
    private String isbn;

    @Column(name = "nombre_examplaires")
    private Long nombreExamplaires;

    @Column(name = "nombre_examplaires_restants")
    private Long nombreExamplairesRestants;

    @Column(name = "titre")
    private String titre;

    @Column(name = "auteur")
    private String auteur;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "date_publication")
    private LocalDate date;
}
