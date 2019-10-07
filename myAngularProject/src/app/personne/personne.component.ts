import { Component, OnInit } from '@angular/core';
import { Personne } from '../personne';
import { PersonnesService } from '../personnes.service';

@Component({
  selector: 'app-personne',
  templateUrl: './personne.component.html',
  styleUrls: ['./personne.component.css']
})
export class PersonneComponent implements OnInit {

  personne: Personne[];

  private async getAllPersonne() {
   const result =  await this.personneService.getPersonne();
   if(result.length !== 0) {
    this.personne = result;
   }
  }

  private async deletePersonne(personne: Personne) {
   this.personne = this.personne.filter(h => h !== personne);
    this.personneService.deletePersonne(personne);
  }

  add(nom: string, prenom: string, age: number ){
       this.personneService.addPersonne(nom, prenom,age);
       this.getAllPersonne();
  }

  constructor(private personneService: PersonnesService) { }

  ngOnInit() {
   
  }

}
