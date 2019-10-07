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
  public valide: boolean = false;

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

  async add(nom: string, prenom: string, age: number ){
    this.personne = [];
    this.valide = false;
    await this.personneService.addPersonne(nom, prenom,age);
    this.getAllPersonne();
  }

  valid(){
    this.valide = true;
  }

  constructor(private personneService: PersonnesService) { }

  ngOnInit() { 
  }

}
