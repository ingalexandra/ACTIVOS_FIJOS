import { TestBed } from '@angular/core/testing';

import { TypesFixedAssetsService } from './types-fixed-assets.service';

describe('TypesFixedAssetsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: TypesFixedAssetsService = TestBed.get(TypesFixedAssetsService);
    expect(service).toBeTruthy();
  });
});
