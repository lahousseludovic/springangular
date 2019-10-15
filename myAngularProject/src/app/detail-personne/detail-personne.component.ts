import { Component, OnInit } from '@angular/core';
import { Personne } from '../personne';
import { ActivatedRoute } from '@angular/router';
import { PersonnesService } from '../personnes.service';
import { Location } from '@angular/common';
import { NiveauEtude } from '../niveauEtude';

@Component({
  selector: 'app-detail-personne',
  templateUrl: './detail-personne.component.html',
  styleUrls: ['./detail-personne.component.css']
})
export class DetailPersonneComponent implements OnInit {

  personne: Personne;

  getPersonne(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.personneService.getPersonneById(id)
    .then(res => 
      {
      this.personne = res;
      console.log(this.personne);
      })
  }

  update(): void {
    this.personneService.update(this.personne);
  }

  constructor(private route: ActivatedRoute, private personneService: PersonnesService, private location: Location) { }

  ngOnInit() {
    this.getPersonne();
  }

  goBack()  {
    this.location.back();
  }

}
