import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { personnes } from 'src/assets/personnes';
import { Personne } from '../models/personne';
import { PersonneService } from '../personnes.service';

@Component({
  selector: 'app-livre',
  templateUrl: './livre.component.html',
  styleUrls: ['./livre.component.css']
})
export class LivreComponent implements OnInit {
  personnes: Personne[] = []; // Tableau pour stocker les données reçues
  personneId: number | null = null; // Stocke l'ID de la personne
  livreTitre: string | null = null; // Stocke le titre du livre
  hoveredRow: number | null = null; //

  constructor(
    private route: ActivatedRoute,
    private personneService: PersonneService
  ) {}

  ngOnInit(): void {
    // Récupérer l'ID depuis les paramètres de la route
    this.personneId = Number(this.route.snapshot.paramMap.get('id'));
    this.livreTitre = this.route.snapshot.paramMap.get('titre');


    if (this.personneId) {
      // Appeler le service pour récupérer les données de la personne
      this.personneService.getPersonneById(this.personneId).subscribe({
        next: (data) => {
          this.personnes = data;
          console.log('Personne récupérée :', data);
        },
        error: (error) => {
          console.error('Erreur lors de la récupération de la personne :', error);
        },
      });
    }

}}
