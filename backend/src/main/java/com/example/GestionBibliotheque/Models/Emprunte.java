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

    @Column(name = "book_id")
    private String bookId;

    @Column(name = "genre_id")
    private Integer genreId;

    @Column(name = "date_emprunt")
    private Integer dateEmprunt;

    @Column(name = "date_retour_estimee")
    private Integer dateRetourEstimee;
}