import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  private apiUrl = 'http://localhost:8080/emprunts/emprunter'; // Remplacez par votre endpoint API

  constructor(private http: HttpClient) {}

  // Méthode pour récupérer les données

  reserverLivre(id: number): Observable<any> {
    return this.http.post(`${this.apiUrl}/${id}`, {}); // L'endpoint doit être défini dans le backend
  }

}
