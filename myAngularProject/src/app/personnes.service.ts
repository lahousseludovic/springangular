import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Personne } from './personne';
import { HttpHeaders } from '@angular/common/http';
import { NiveauEtude } from './niveauEtude';


const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    'Authorization': 'my-auth-token'
  })
};

@Injectable({
  providedIn: 'root'
})
export class PersonnesService {


  private urlApi: string = 'http://localhost:8080/monAppli/personne';

  /** GET Personne from the server */
  public getPersonne(): Promise<Personne[]> {

    return this.http.get<Personne[]>(`${this.urlApi}`).toPromise();

  }

  /** GET Personne by ID from the server */
  public getPersonneById(id: number): Promise<Personne> {

    return this.http.get<Personne>(`${this.urlApi}/${id}`).toPromise();
  }

  /** UPDATE Personne from the server */
  public update(personne: Personne): Promise<Personne> {

    if(personne.nom.trim() && personne.prenom.trim() && personne.age != 0 && personne.age != null){
      return this.http.put<Personne>(`${this.urlApi}/update`,personne, httpOptions).toPromise();
    }
  }

  /** CREATE Personne from the server */
  public addPersonne(nom: string, prenom: string, age: number, niveau: string): Promise<Personne>{
    if(nom.trim() && prenom.trim() && age !== null){
      const niveauEtude: NiveauEtude = new NiveauEtude(niveau);
      const personne: Personne =  new Personne(nom,prenom,age,niveauEtude);
      return this.http.post<Personne>(`${this.urlApi}/add`, personne, httpOptions).toPromise();
    }
  }

  /** DELETE a personne from the server by ID */
  public deletePersonne(personne: Personne): void {
    const id = personne.id;
    this.http.delete<Personne>(`${this.urlApi}/delete/${id}`, httpOptions).toPromise();

  }

     /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      //  TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
  constructor(private http: HttpClient) { }
}
