import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { OwnerService } from '../owner.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-find-owner',
  templateUrl: './find-owner.component.html',
  styleUrls: ['./find-owner.component.css']
})
export class FindOwnerComponent {

  msg: String = '';

  findOwnerForm = new FormGroup({
    findBy: new FormControl(''),
    ownerInfo: new FormControl('')
  })

  constructor(private ownerService: OwnerService, private router: Router) {}

  findOwner() {
    let owner;
    let byWhat = this.findOwnerForm.value.findBy;
    if (byWhat == 'phone') {
      owner = this.ownerService.findOwnerByPhone(byWhat);
    } else if (byWhat == 'email') {
      owner = this.ownerService.findOwnerByEmail(byWhat);
    }

    let path = '';
    if (owner == undefined) {
      this.msg = 'No owner is found in the system for specified criteria. Please create New Owner.'
      path = 'findOwner';
    } else {
      path = 'manageOwner'
    }
    this.router.navigate([path],{skipLocationChange:true});
  }
}
