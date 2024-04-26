import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LogoLuisComponent } from './logo-luis.component';

describe('LogoLuisComponent', () => {
  let component: LogoLuisComponent;
  let fixture: ComponentFixture<LogoLuisComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [LogoLuisComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(LogoLuisComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
