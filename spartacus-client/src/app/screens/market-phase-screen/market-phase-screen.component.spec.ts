import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MarketPhaseScreenComponent } from './market-phase-screen.component';

describe('MarketPhaseScreenComponent', () => {
  let component: MarketPhaseScreenComponent;
  let fixture: ComponentFixture<MarketPhaseScreenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MarketPhaseScreenComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MarketPhaseScreenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
