import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-livre-info',
  templateUrl: './livre-info.component.html',
  styleUrls: ['./livre-info.component.css']
})
export class LivreInfoComponent implements OnInit {
  livreId: number | null = null;

  constructor(private route: ActivatedRoute) {}

  ngOnInit(): void {
    // Récupérer l'ID depuis les paramètres de la route
    this.livreId = Number(this.route.snapshot.paramMap.get('id'));
    console.log('Livre ID:', this.livreId);
    // Vous pouvez ici appeler un service pour récupérer les détails du livre via cet ID
  }

}
