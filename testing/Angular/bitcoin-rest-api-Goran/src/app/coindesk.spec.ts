import { TestBed } from '@angular/core/testing';

import { CoindeskService } from './coindesk.service';

describe('CoindeskServiceService', () => {
  let service: CoindeskService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CoindeskService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
