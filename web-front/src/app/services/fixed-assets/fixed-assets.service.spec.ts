import { TestBed } from '@angular/core/testing';

import { FixedAssetsService } from './fixed-assets.service';

describe('FixedAssetsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: FixedAssetsService = TestBed.get(FixedAssetsService);
    expect(service).toBeTruthy();
  });
});
