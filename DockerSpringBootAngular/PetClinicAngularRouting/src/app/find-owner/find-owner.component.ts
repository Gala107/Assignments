import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { OwnerService } from '../owner.service';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs/internal/Subscription';
import { Owner } from '../owner';

@Component({
  selector: 'app-find-owner',
  templateUrl: './find-owner.component.html',
  styleUrls: ['./find-owner.component.css']
})
export class FindOwnerComponent implements OnInit, OnDestroy {

  msg: string = "";
  ownerId: number = 0;
  subscription: Subscription = new Subscription();

  findOwnerForm = new FormGroup({
    findBy: new FormControl(''),
    ownerInfo: new FormControl('')
  })

  constructor(private ownerService: OwnerService, private router: Router) { }

  ngOnInit(): void {

  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

  findOwner() {
    let findCriteria = this.findOwnerForm.value;
    this.subscription = this.ownerService.findOwner(findCriteria.findBy, findCriteria.ownerInfo).subscribe({
      next: (result: Owner) => {
        this.ownerId = result.id;
        let path;
        if (this.ownerId > 0) {
          path = 'manageOwner/' + this.ownerId;
        } else {
          this.msg = 'No owner is found in the system for specified criteria. Please create New Owner.'
          path = 'findOwner';
        } 
        this.router.navigate([path], { skipLocationChange: true });
      },
      error: (error: any) => { console.log(error) },
      complete: () => { }
    });
  }
}
