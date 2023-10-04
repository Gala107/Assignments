import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';

import { ClientObj } from '../client-obj';

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css']
})
export class ClientComponent {
  validateClient(clientForm: NgForm) {
    let formValues = clientForm.value;

    

    clientForm.reset();
  }
}
