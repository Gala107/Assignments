import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CoindeskComponent } from './coindesk.component';

describe('CoingdeskComponent', () => {
  let component: CoindeskComponent;
  let fixture: ComponentFixture<CoindeskComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CoindeskComponent]
    });
    fixture = TestBed.createComponent(CoindeskComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
