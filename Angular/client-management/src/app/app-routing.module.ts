import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClientListComponent } from './client-list/client-list.component';
import { ClientMeetingComponent } from './client-meeting/client-meeting.component';
import { ClientComponent } from './client/client.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
  { path: "", component: ClientComponent },
  { path: "client", component: ClientComponent },
  { path: "client-list", component: ClientListComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
