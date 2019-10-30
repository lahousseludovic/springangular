import { Component, OnInit } from '@angular/core';
import { Personne } from '../personne';
import { PersonnesService } from '../personnes.service';
import { NiveauEtude } from '../niveauEtude';
import { NiveauEtudeService } from '../niveau-etude.service';
import {MatTableDataSource} from '@angular/material/table';
import {FormControl, Validators, FormGroup} from '@angular/forms';

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

  form= new FormGroup({
      name: new FormControl(null, [Validators.required]),
      surname: new FormControl(null, [Validators.required]),
      age: new FormControl(null, [Validators.required, Validators.pattern('[1-9]{2}')])
  });

  getErrorMessageName() {
    return this.form.controls.name.hasError('required') ? 'Vous devez remplir ce champ' :'';
  }

  getErrorMessageSurname() {
    return this.form.controls.surname.hasError('required') ? 'Vous devez remplir ce champ' :'';
  }

  getErrorMessageAge() {
    return this.form.controls.age.hasError('required') ? 'Vous devez remplir ce champ' :'';
    /**this.form.controls.age.hasError('age') ? 'format non valide' : '';*/
  }

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
    if(niveauEtude == null){
        niveauEtude = 'Aucun';
    }
      this.personne = [];
      const result = await this.personneService.addPersonne(nom, prenom,age, niveauEtude);
      if(result.id !== null){
       this.getAllPersonne();
      }
    
  }

  private valid(){
    if(this.valid){
      this.valide = false;
    }else{
      this.valide = true;
    }
    this.form.reset();
  }

  constructor(private personneService: PersonnesService, private niveauEtudeService: NiveauEtudeService) { }

  ngOnInit() {
    this.getAllPersonne();
  }
}
