import { Component, OnInit } from '@angular/core';
import { Personne } from '../personne';
import { PersonnesService } from '../personnes.service';
import { NiveauEtude } from '../niveauEtude';
import { NiveauEtudeService } from '../niveau-etude.service';
import {MatTableDataSource} from '@angular/material/table';

export interface PeriodiqueElement {
  position: Number;
  name: string;
  surname: string;
  age: number;
  level: String;
  action: Personne;
}

const ELEMENT_DATA: PeriodiqueElement[] = [];

@Component({
  selector: 'app-personne',
  templateUrl: './personne.component.html',
  styleUrls: ['./personne.component.css']
})
export class PersonneComponent implements OnInit {

  displayedColumns: string[] = ['position', 'name', 'surname', 'age', 'level','action'];
  dataSource = new MatTableDataSource(ELEMENT_DATA)

  personne: Personne[];
  niveauEtude: NiveauEtude[];
  public valide: boolean = false;

  private async getAllPersonne() {
   const result = await this.personneService.getPersonne();
   if(result.length !== 0) {
    this.personne = result;
    ELEMENT_DATA.splice(0,ELEMENT_DATA.length);
    for (const p of this.personne) {
      ELEMENT_DATA.push({position: p.id, name: p.nom, surname: p.prenom, age: p.age, level: p.niveauEtude.libelle, action: p });
    }
    this.dataSource = new MatTableDataSource(ELEMENT_DATA);
   }
  }

  private async getAllNiveauEtude() {
    const result = await this.niveauEtudeService.getAll();
    if(result.length !== 0){
      this.niveauEtude = result;
      this.valide = true;
    }
  }

  private async deletePersonne(personne: Personne) {
    await this.personneService.deletePersonne(personne);
    this.getAllPersonne();
  }

  async add(nom: string, prenom: string, age: number, niveauEtude: string){
    this.valide = false;
    if(nom.trim() && prenom.trim() && age.toString() !== "0" && age.toString() !== ""){
      this.personne = [];
      const result = await this.personneService.addPersonne(nom, prenom,age, niveauEtude);
      if(result.id !== null){
       this.getAllPersonne();
      }
    }
  }

  constructor(private personneService: PersonnesService, private niveauEtudeService: NiveauEtudeService) { }

  ngOnInit() {
    this.getAllPersonne();
  }
}
