import { Component, OnInit } from '@angular/core';
import { Personne } from '../personne';
import { ActivatedRoute } from '@angular/router';
import { PersonnesService } from '../personnes.service';
import { Location } from '@angular/common';
import { NiveauEtude } from '../niveauEtude';
import { NiveauEtudeService } from '../niveau-etude.service';
import {FormControl, Validators, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-detail-personne',
  templateUrl: './detail-personne.component.html',
  styleUrls: ['./detail-personne.component.css']
})
export class DetailPersonneComponent implements OnInit {

  personne: Personne;
  nom: string;
  prenom: string;
  niveauEtude: NiveauEtude[];

  form= new FormGroup({
    name: new FormControl(null, [Validators.required, Validators.pattern('[a-zA-Z]*')]),
    surname: new FormControl(null, [Validators.required, Validators.pattern('[a-zA-Z]*')]),
    age: new FormControl(null, [Validators.required, Validators.pattern('[0-9]{2}'), this.ageDomainValidator])
});

getErrorMessageName() {
  return this.form.controls.name.hasError('required') ? 'Vous devez remplir ce champ' : 
  this.form.controls.name.hasError('pattern') ? 'Format invalide' : '';
}

getErrorMessageSurname() {
  return this.form.controls.surname.hasError('required') ? 'Vous devez remplir ce champ' :
  this.form.controls.surname.hasError('pattern') ? 'Format invalide' : '';
}

getErrorMessageAge() {
  return this.form.controls.age.hasError('required') ? 'Vous devez remplir ce champ' :
  this.form.controls.age.hasError('ageDomain') ? 'L\'âge doit ếtre >= 18' : 
  this.form.controls.age.hasError('pattern') ? 'Format invalide' : '';
}

ageDomainValidator(control: FormControl) {
 const age:number = control.value;
 if(age < 18){
   return {
     ageDomain:{
       parsedDomain: ''
     }
   }
 }
    return null;
}

  getPersonne(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    
    this.personneService.getPersonneById(id)
    .then(res => 
      {
      this.personne = res;
      this.nom = this.personne.nom;
      this.prenom = this.personne.prenom;
    })
  }

  async getAllNiveauEtude(){
    const result = await this.niveauEtudeService.getAll();
    if(result.length !== 0){
      this.niveauEtude = result;
    }
  }

  async update(){
    await this.personneService.update(this.personne);
    this.goBack();
  }

  constructor(private route: ActivatedRoute, private personneService: PersonnesService, private location: Location, private niveauEtudeService: NiveauEtudeService) { }

  ngOnInit() {
    this.getPersonne();
    this.getAllNiveauEtude();
    this.form.reset();
  }

  goBack()  {
    this.location.back();
  }

}
