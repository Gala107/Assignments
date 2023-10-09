import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ClientService } from '../client.service';

@Component({
  selector: 'app-create-client',
  templateUrl: './create-client.component.html',
  styleUrls: ['./create-client.component.css']
})
export class CreateClientComponent {

  constructor(private router: Router, private service: ClientService) { }

  createClient(clientForm: NgForm) {
    let client = clientForm.value;

    // Validate that first name contains only letters.
    const firstNameExp = /^[a-zA-Z]+$/;

    // Validate that last name contains only letters and 
    // possibly a space, hyphen or apostrophe.
    // Ex. Last names like: Van Duck, Small-Mighty, O'Connell.
    const lastNameExp = /^[a-zA-Z]+[' -]?[a-zA-Z]*$/;

    // Validate that email starts with letters, digits, underscores, hyphens, or periods,
    // proceeds with '@', continues with another set of the first part characters, period
    // and ends with the top level domain like 'com' taking 2 to 4 characters.
    const emailExp = /^[\w-\.]+@[\w-]+\.[\w-]{2,4}$/;

    if (!firstNameExp.test(client.firstName)) {
      alert("Please enter your first name.");
      return;
    } else if (!lastNameExp.test(client.lastName)) {
      alert("Please enter your last name.");
      return;
    } else if (!emailExp.test(client.email)) {
      alert("Please enter your email.");
      return;
    }

    this.service.createClient(client).subscribe({
      next: client => console.log(client),
      error: error => console.log(`Observer received and error: ${error}`),
      complete: () => this.service.loadClients() 
    }); 

    this.router.navigate(["client-list"], {skipLocationChange:true});
  }
}
