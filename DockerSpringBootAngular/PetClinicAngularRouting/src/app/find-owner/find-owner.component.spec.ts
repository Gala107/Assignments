import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FindOwnerComponent } from './find-owner.component';

describe('FindOwnerComponent', () => {
  let component: FindOwnerComponent;
  let fixture: ComponentFixture<FindOwnerComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FindOwnerComponent]
    });
    fixture = TestBed.createComponent(FindOwnerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
