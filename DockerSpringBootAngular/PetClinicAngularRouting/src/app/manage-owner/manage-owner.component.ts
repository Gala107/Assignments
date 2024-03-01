import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { OwnerService } from '../owner.service';
import { Router } from '@angular/router';
import { Owner } from '../owner';
import { Pet } from '../pet';

@Component({
  selector: 'app-manage-owner',
  templateUrl: './manage-owner.component.html',
  styleUrls: ['./manage-owner.component.css']
})
export class ManageOwnerComponent {

  ownerForm = new FormGroup({
    name: new FormControl(),
    address: new FormControl(),
    phone: new FormControl(),
    email: new FormControl()
  })

  constructor(private ownerService: OwnerService, private router: Router) {}

  saveOwner() {
    let owner = this.ownerForm.value;
    this.ownerService.saveOwner(new Owner(0, owner.name, owner.address, owner.phone, owner.email, new Array<Pet>()));

    this.router.navigate(['/'], {skipLocationChange:true})
  }
}
