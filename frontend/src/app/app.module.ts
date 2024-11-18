import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LivreComponent } from './livre/livre.component';
import { HttpClientModule } from '@angular/common/http';
import { BiblioTableComponent } from './biblio-table/biblio-table.component';
import { LivreInfoComponent } from './livre-info/livre-info.component';

@NgModule({
  declarations: [
    AppComponent,
    LivreComponent,
    BiblioTableComponent,
    LivreInfoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
