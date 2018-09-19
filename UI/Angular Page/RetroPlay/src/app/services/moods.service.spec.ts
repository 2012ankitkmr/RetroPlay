import { TestBed, inject } from '@angular/core/testing';

import { MoodsService } from './moods.service';

describe('MoodsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [MoodsService]
    });
  });

  it('should be created', inject([MoodsService], (service: MoodsService) => {
    expect(service).toBeTruthy();
  }));
});
