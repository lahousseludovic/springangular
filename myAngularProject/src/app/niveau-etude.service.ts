import { Injectable } from '@angular/core';
import { NiveauEtude } from './niveauEtude';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class NiveauEtudeService {

  private urlApi: string = 'http://localhost:8080/monAppli/niveauEtude';
  
  /** GET niveau d'étude du serveur */
  public getAll(): Promise<NiveauEtude[]> {
    return this.http.get<NiveauEtude[]>(`${this.urlApi}`).toPromise();
  }
  
  constructor(private http: HttpClient ) {}
}
