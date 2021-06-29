import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FixedAssetListComponent } from './fixed-asset-list.component';

describe('FixedAssetListComponent', () => {
  let component: FixedAssetListComponent;
  let fixture: ComponentFixture<FixedAssetListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FixedAssetListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FixedAssetListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
