import { Component } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css']
})
export class ClientComponent {

  constructor(private router: Router) { }

  validateClient(clientForm: NgForm) {
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
    } else if (!lastNameExp.test(client.lastName)) {
      alert("Please enter your last name.");
    } else if (!emailExp.test(client.email)) {
      alert("Please enter your email.");
    }

    // this.router.navigate(["client-list"]);
    this.router.navigate(['/client-list'], { skipLocationChange: true });
  }
}
