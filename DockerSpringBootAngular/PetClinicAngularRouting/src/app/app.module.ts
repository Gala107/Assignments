import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FindOwnerComponent } from './find-owner/find-owner.component';
import { PetInfoComponent } from './pet-info/pet-info.component';
import { ScheduleVisitComponent } from './schedule-visit/schedule-visit.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ManageOwnerComponent } from './manage-owner/manage-owner.component'

@NgModule({
  declarations: [
    AppComponent,
    FindOwnerComponent,
    PetInfoComponent,
    ScheduleVisitComponent,
    ManageOwnerComponent
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
