import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JupitersCockScreenComponent } from './jupiters-cock-screen.component';

describe('JupitersCockScreenComponent', () => {
  let component: JupitersCockScreenComponent;
  let fixture: ComponentFixture<JupitersCockScreenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ JupitersCockScreenComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(JupitersCockScreenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
