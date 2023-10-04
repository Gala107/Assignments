import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ClientComponent } from './client/client.component';
import { ClientMeetingComponent } from './client-meeting/client-meeting.component';

@NgModule({
  declarations: [
    AppComponent,
    ClientComponent,
    ClientMeetingComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
