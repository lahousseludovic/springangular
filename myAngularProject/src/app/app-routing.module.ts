import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { PersonneComponent } from './personne/personne.component';
import { DetailPersonneComponent} from './detail-personne/detail-personne.component';

const routes: Routes = [
  { path: 'personne', component: PersonneComponent},
  { path: '', redirectTo: '/personne', pathMatch: 'full'},
  { path: 'detail/:id', component: DetailPersonneComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
