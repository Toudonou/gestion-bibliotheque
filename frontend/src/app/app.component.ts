import { Component } from '@angular/core';
import { Livre } from './models/livre';
import { LivreService } from './livre.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
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
}
