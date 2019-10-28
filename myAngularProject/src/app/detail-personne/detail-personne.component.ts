import { Component, OnInit } from '@angular/core';
import { Personne } from '../personne';
import { ActivatedRoute } from '@angular/router';
import { PersonnesService } from '../personnes.service';
import { Location } from '@angular/common';
import { NiveauEtude } from '../niveauEtude';
import { NiveauEtudeService } from '../niveau-etude.service';

@Component({
  selector: 'app-detail-personne',
  templateUrl: './detail-personne.component.html',
  styleUrls: ['./detail-personne.component.css']
})
export class DetailPersonneComponent implements OnInit {

  personne: Personne;
  niveauEtude: NiveauEtude[];

  getPersonne(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.personneService.getPersonneById(id)
    .then(res => 
      {
      this.personne = res;
    })
  }

  async getAllNiveauEtude(){
    const result = await this.niveauEtudeService.getAll();
    if(result.length !== 0){
      this.niveauEtude = result;
    }
  }

  update(): void {
    this.personneService.update(this.personne);
  }

  constructor(private route: ActivatedRoute, private personneService: PersonnesService, private location: Location, private niveauEtudeService: NiveauEtudeService) { }

  ngOnInit() {
    this.getPersonne();
    this.getAllNiveauEtude();

  }

  goBack()  {
    this.location.back();
  }

}
