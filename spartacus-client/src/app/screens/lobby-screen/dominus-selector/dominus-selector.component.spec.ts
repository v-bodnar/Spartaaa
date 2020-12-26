import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DominusSelectorComponent } from './dominus-selector.component';

describe('DominusSelectorComponent', () => {
  let component: DominusSelectorComponent;
  let fixture: ComponentFixture<DominusSelectorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DominusSelectorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DominusSelectorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
