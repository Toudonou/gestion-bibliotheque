import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LivreComponent } from './livre/livre.component';
import { BiblioTableComponent } from './biblio-table/biblio-table.component';

const routes: Routes = [
  { path: '', component: BiblioTableComponent }, // Table des livres
  { path: "livre/:id", component: LivreComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
