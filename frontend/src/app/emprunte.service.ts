import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Emprunte } from './models/emprunte';

@Injectable({
  providedIn: 'root'
})
export class EmprunteService {
  private url = "http://localhost:8080/emprunts/";
  constructor(private http: HttpClient) { }

  getEmprunteByIdLivre(id: number): Observable<Emprunte[]>{
    return this.http.get<Emprunte[]>(this.url + id);
  }
}
