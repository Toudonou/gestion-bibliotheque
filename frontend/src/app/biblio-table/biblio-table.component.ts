import { Component, OnInit } from '@angular/core';
import { Livre } from '../models/livre';
import { LivreService } from '../livre.service';

@Component({
  selector: 'app-biblio-table',
  templateUrl: './biblio-table.component.html',
  styleUrls: ['./biblio-table.component.css']
})
export class BiblioTableComponent implements OnInit {

  livres: Livre[] = [];

  constructor(private _livreService: LivreService){}

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

  redirect(id: number): void {
    console.log("Redirect to", id);
  }

}
