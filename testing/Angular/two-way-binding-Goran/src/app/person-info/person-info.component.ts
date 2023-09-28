import { Component } from '@angular/core';
import { PersonInfo } from '../person-info';

@Component({
  selector: 'app-person-info',
  templateUrl: './person-info.component.html',
  styleUrls: ['./person-info.component.css']
})
export class PersonInfoComponent {

  person: PersonInfo = {
    firstName: "", 
    lastName: "",
    email: "",
    zipCode: ""
  };
}
