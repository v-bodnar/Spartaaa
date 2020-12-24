import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IntriguePhaseScreenComponent } from './intrigue-phase-screen.component';

describe('IntriguePhaseScreenComponent', () => {
  let component: IntriguePhaseScreenComponent;
  let fixture: ComponentFixture<IntriguePhaseScreenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IntriguePhaseScreenComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(IntriguePhaseScreenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
