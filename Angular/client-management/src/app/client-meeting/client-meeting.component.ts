import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { ClientService } from '../client.service';

@Component({
  selector: 'app-client-meeting',
  templateUrl: './client-meeting.component.html',
  styleUrls: ['./client-meeting.component.css']
})
export class ClientMeetingComponent {

  constructor(private router: Router, private service: ClientService) {}

  meetForm = new FormGroup({
    id: new FormControl(),
    firstName: new FormControl(),
    lastName: new FormControl(),
    meetDate: new FormControl(),
    meetTime: new FormControl(),
    note: new FormControl(),
    clientId: new FormControl()
  })

  schedMeet() {
    let meet = this.meetForm.value;

    // Validate that date has format: yyyy-mm-dd
    const dateExp = /^[0-9]{4}\-[0-9]{2}\-[0-9]{2}$/;

    // Validate that meetingDate is set in the future.
    let today: any = new Date();
    let laterDate: any = new Date(meet.meetDate);
    let isLaterDate = (laterDate - today) > 0;

    if (!dateExp.test(meet.meetDate) || !isLaterDate) {
        alert("Please select meeting date.");
        return;
    }

    this.service.createClientMeeting(meet).subscribe({
      next: result => console.log(`Client meeting is created: ${{result}}`),
      error: error => console.log(`Error creating client meeting: ${{error}}`),
      complete: () => console.log("Client meeting creation is completed.")      
    })

  }

}
