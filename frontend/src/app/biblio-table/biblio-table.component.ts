import { Component, OnInit } from '@angular/core';
import { Livre } from '../models/livre';
import { LivreService } from '../livre.service';
import { Router } from '@angular/router';
import { ReservationService } from '../reservation.service';

@Component({
  selector: 'app-biblio-table',
  templateUrl: './biblio-table.component.html',
  styleUrls: ['./biblio-table.component.css']
})
export class BiblioTableComponent implements OnInit {
  hoveredRow: number | null = null;
  livres: Livre[] = [];

  constructor(private _livreService: LivreService, private reservationService: ReservationService , private router: Router){}

  ngOnInit(): void {
    this._livreService.getAllLivres().subscribe({
      next: (data: Livre[]) => {
        console.log(data);
        this.livres = data;
        
      },
      error: (error) => {
        console.error('Erreur lors de la récupération des livres:', error);
      }
    });
  }

  redirect(id: number, titre: string): void {
    console.log("Redirect to", id);
    this.router.navigate(['/livre', id, titre]);

  }

  onMouseOver(event: MouseEvent, index: number): void {
    event.preventDefault(); // Empêche le comportement par défaut
    event.stopPropagation(); // Stoppe la propagation de l'événement
    this.hoveredRow = index; // Met à jour la ligne survolée
  }

  onMouseOut(event: MouseEvent): void {
    event.preventDefault(); // Empêche le comportement par défaut
    event.stopPropagation(); // Stoppe la propagation de l'événement
    // this.hoveredRow = null; // Réinitialise la ligne survolée
  }

  reserver(livre: any): void {
    if (livre.nombreExamplairesRestants > 0) {
      this.reservationService.reserverLivre(livre.id).subscribe({
        next: (response) => {
          console.log('Réservation réussie', response);
          livre.nombreRestants--; // Mettre à jour le nombre localement après la mise à jour backend
        },
        error: (error) => {
          console.error('Erreur lors de la réservation', error);
        },
      });
    } else {
      console.log('Pas assez d’exemplaires pour réserver');
    }
  }

}
