import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { OwnerService } from '../owner.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Owner } from '../owner';
import { Pet } from '../pet';
import { Subscription } from 'rxjs/internal/Subscription';

@Component({
  selector: 'app-manage-owner',
  templateUrl: './manage-owner.component.html',
  styleUrls: ['./manage-owner.component.css']
})
export class ManageOwnerComponent implements OnInit, OnDestroy {

  ownerId = 0;
  isPetForm = false;
  pets: Array<Pet> = [];
  subscription: Subscription = new Subscription();

  ownerForm = new FormGroup({
    name: new FormControl(),
    address: new FormControl(),
    phone: new FormControl(),
    email: new FormControl(),
    id: new FormControl()
  })

  petForm = new FormGroup({
    name: new FormControl(),
    type: new FormControl(),
    breed: new FormControl(),
    dob: new FormControl()
  })

  constructor(private ownerService: OwnerService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.getOwnerIdParam();
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

  findOwnerById() {
    this.subscription = this.ownerService.findOwnerById(this.ownerId).subscribe({
      next: (result: Owner) => { 
        this.ownerForm.patchValue(result);
        this.pets = result.pets; 
      },
      error: (error: any) => { console.log(error) },
      complete: () => { console.log("Retrieveing Owner by Id is completed.") }
    });
  }

  saveOwner() {
    this.subscription = this.ownerService.saveOwner(this.ownerForm.value).subscribe({
      next: (result: Owner) => { this.ownerForm.patchValue(result); this.ownerId = result.id },
      error: (error: any) => { console.error(error) },
      complete: () => console.log("New Owner is saved successfully.")
    })
  }

  getOwnerIdParam() {
    this.route.params.subscribe(params => {
      this.ownerId = params["ownerId"];
      if (this.ownerId > 0) {
        this.findOwnerById();
      }
    });
  }

  savePet() {
    let pet = new Pet(this.petForm.value);
    pet.ownerId = this.ownerForm.value.id;
    this.subscription = this.ownerService.addPet(pet).subscribe({
      next: result => { this.ownerForm.patchValue(result); this.pets = result.pets },
      error: error => { console.error(error) },
      complete: () => { console.log("Pet is saved for his Owner.") }
    })
    this.isPetForm = false;
  }

  resetPetForm() {
    this.isPetForm = true;
    // this.petForm.reset(this.petForm.value);
    // this.petForm.markAsPristine();
    // this.petForm.markAsUntouched();

  }
}
