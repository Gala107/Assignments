import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClientListComponent } from './client-list/client-list.component';
import { ClientMeetingComponent } from './client-meeting/client-meeting.component';
import { CreateClientComponent } from './create-client/create-client.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
  { path: "", component: CreateClientComponent },
  { path: "create-client", component: CreateClientComponent },
  { path: "client-list", component: ClientListComponent },
  { path: "client-meeting", component: ClientMeetingComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
