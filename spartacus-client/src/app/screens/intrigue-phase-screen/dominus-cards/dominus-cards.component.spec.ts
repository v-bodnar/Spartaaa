import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DominusCardsComponent } from './dominus-cards.component';

describe('DominusCardsComponent', () => {
  let component: DominusCardsComponent;
  let fixture: ComponentFixture<DominusCardsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DominusCardsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DominusCardsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
