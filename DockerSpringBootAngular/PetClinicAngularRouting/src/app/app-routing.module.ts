import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FindOwnerComponent } from './find-owner/find-owner.component';
import { ManageOwnerComponent } from './manage-owner/manage-owner.component';

const routes: Routes = [
  {path: 'findOwner', component: FindOwnerComponent},
  {path: 'manageOwner', component: ManageOwnerComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
