import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root', // Fournisseur du service au niveau de l'application
})
export class PersonneService {
  private apiUrl = 'http://localhost:8080/emprunts'; // Remplacez par votre endpoint API

  constructor(private http: HttpClient) {}

  // Méthode pour récupérer les données
  getPersonnes(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }
  getPersonneById(id: number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/${id}`);
  }
}
