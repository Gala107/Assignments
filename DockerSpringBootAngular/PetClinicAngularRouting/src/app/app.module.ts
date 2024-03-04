import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FindOwnerComponent } from './find-owner/find-owner.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ManageOwnerComponent } from './manage-owner/manage-owner.component';
import { PetVisitComponent } from './pet-visit/pet-visit.component'

@NgModule({
  declarations: [
    AppComponent,
    FindOwnerComponent,
    ManageOwnerComponent,
    PetVisitComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
