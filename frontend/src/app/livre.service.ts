import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Livre } from './models/livre';

@Injectable({
  providedIn: 'root'
})
export class LivreService {
  private url = "http://localhost:8080/livre/orderedByAuteur";
  constructor(private http: HttpClient) { }

  getAllLivres(): Observable<Livre[]>{
    return this.http.get<Livre[]>(this.url);
  }
}
