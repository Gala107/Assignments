import { TestBed } from '@angular/core/testing';

import { PetVisitService } from './pet-visit.service';

describe('PetVisitService', () => {
  let service: PetVisitService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PetVisitService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
