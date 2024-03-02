import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { OwnerService } from '../owner.service';
import { Router } from '@angular/router';
import { Owner } from '../owner';
import { Pet } from '../pet';
import { Subscription } from 'rxjs/internal/Subscription';

@Component({
  selector: 'app-manage-owner',
  templateUrl: './manage-owner.component.html',
  styleUrls: ['./manage-owner.component.css']
})
export class ManageOwnerComponent implements OnInit, OnDestroy  {

  ownerId = 0;
  isPetForm = false;
  isPetSaved = false;
  subscription: Subscription = new Subscription();
  msg = "";

  ownerForm = new FormGroup({
    name: new FormControl(),
    address: new FormControl(),
    phone: new FormControl(),
    email: new FormControl()
  })

  petForm = new FormGroup({
    petName: new FormControl(),
    type: new FormControl(),
    breed: new FormControl(),
    dob: new FormControl()
  })

  constructor(private ownerService: OwnerService, private router: Router) {}

  ngOnInit(): void {
  
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

  saveOwner() {
    this.subscription = this.ownerService.saveOwner(this.ownerForm.value).subscribe({
      next: (result:any) => {this.ownerId = result},
      error: (error:any) => {console.log(error)},
      complete: () => console.log("New Owner is saved successfully")
    })

    console.log("Owner ID: " + this.ownerId);
  }

  addPetForm() {
    this.isPetForm = true;
  }

  savePet() {
    this.isPetSaved = true;
  }
}
