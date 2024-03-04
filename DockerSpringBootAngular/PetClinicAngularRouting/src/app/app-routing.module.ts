import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FindOwnerComponent } from './find-owner/find-owner.component';
import { ManageOwnerComponent } from './manage-owner/manage-owner.component';
import { PetVisitComponent } from './pet-visit/pet-visit.component';

const routes: Routes = [
  {path: 'findOwner', component: FindOwnerComponent},
  {path: 'manageOwner/:ownerId', component: ManageOwnerComponent},
  {path: 'petVisit/:petId', component: PetVisitComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
