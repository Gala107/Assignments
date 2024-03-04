import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs/internal/Subscription';
import { Visit } from '../visit';
import { Pet } from '../pet';
import { PetVisitService } from '../pet-visit.service';

@Component({
  selector: 'app-pet-visit',
  templateUrl: './pet-visit.component.html',
  styleUrls: ['./pet-visit.component.css']
})
export class PetVisitComponent implements OnInit, OnDestroy {

  petId = 0;
  isVisitForm = false;
  visits: Array<Visit> = [];
  subscription: Subscription = new Subscription();
  pet: any;

  visitForm = new FormGroup({
    date: new FormControl(),
    time: new FormControl(),
    reason: new FormControl(),
    ownerId: new FormControl(),
    petId: new FormControl()
  })

  constructor(private petService: PetVisitService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.getPetIdParam();
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

  getPetIdParam() {
    this.route.params.subscribe(params => {
      this.petId = params["petId"];
      if (this.petId > 0) {
        this.findPetById();
      }
    });
  }

  saveVisit() {
    let visit = new Visit(this.visitForm.value);
    visit.petId = this.petId; 
    this.subscription = this.petService.addVisit(visit).subscribe({
      next: result => { this.visitForm.patchValue(result); this.visits = result.visits },
      error: error => { console.error(error) },
      complete: () => { console.log("Visit is saved for a Pet.") }
    })
    this.isVisitForm = false;
  }

  findPetById() {
    this.subscription = this.petService.findPetById(this.petId).subscribe({
      next: (result: Pet) => { 
        this.pet = result;
        this.visits = result.visits; 
      },
      error: (error: any) => { console.log(error) },
      complete: () => { console.log("Retrieveing Owner by Id is completed.") }
    });
  }

  resetVisitForm() {
    this.isVisitForm = true;
    // this.petForm.reset(this.petForm.value);
    // this.petForm.markAsPristine();
    // this.petForm.markAsUntouched();

  }
}
 {

}
