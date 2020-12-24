import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GameLoadScreenComponent } from './game-load-screen.component';

describe('GameLoadScreenComponent', () => {
  let component: GameLoadScreenComponent;
  let fixture: ComponentFixture<GameLoadScreenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GameLoadScreenComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GameLoadScreenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
