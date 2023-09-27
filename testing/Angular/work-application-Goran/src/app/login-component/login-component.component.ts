// Create an Angular project named "work-application"
// Add  one component named "login-component" that meets the below requirements.
// a. Has inputs for user login and password
// b. Has a submit button that checks for the below requirements
//   i. The login name is alpha characters only
//   ii. The password has alphanumeric characters and is at least 8 characters long

import { Component } from '@angular/core';

@Component({
  selector: 'app-login-component',
  templateUrl: './login-component.component.html',
  styleUrls: ['./login-component.component.css']
})
export class LoginComponentComponent {

  validate(userName: any, password: any): void {
    // Validate that User Name contains only alpha characters
    const userNameEx = /^[a-zA-Z]+$/;

    // Validate that Password is at least 8 characters long and 
    // contains only alphanumric characters.
    const passwordEx = /^[a-zA-Z0-9]{8,}$/;

    if (!userNameEx.test(userName.value)) {
      userName.focus();
      alert("Please enter User Name.");
      return;
    }
    if (!passwordEx.test(password.value))
    {
      password.focus();
      alert("Please enter Password.");
      return;
    }   
    password.value = "";
    userName.value = "";
    alert("Congratulations! User Name and Password are valid!"); 
  }
}
