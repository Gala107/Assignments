import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PetVisitComponent } from './pet-visit.component';

describe('PetVisitComponent', () => {
  let component: PetVisitComponent;
  let fixture: ComponentFixture<PetVisitComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PetVisitComponent]
    });
    fixture = TestBed.createComponent(PetVisitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
