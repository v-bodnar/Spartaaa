import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ArenaPhaseScreenComponent } from './arena-phase-screen.component';

describe('ArenaPhaseScreenComponent', () => {
  let component: ArenaPhaseScreenComponent;
  let fixture: ComponentFixture<ArenaPhaseScreenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ArenaPhaseScreenComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ArenaPhaseScreenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
