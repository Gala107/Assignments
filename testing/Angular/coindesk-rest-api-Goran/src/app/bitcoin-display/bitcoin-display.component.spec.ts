import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BitcoinDisplayComponent } from './bitcoin-display.component';

describe('BitcoinDisplayComponent', () => {
  let component: BitcoinDisplayComponent;
  let fixture: ComponentFixture<BitcoinDisplayComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BitcoinDisplayComponent]
    });
    fixture = TestBed.createComponent(BitcoinDisplayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
