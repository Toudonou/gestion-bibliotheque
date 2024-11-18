import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LivreInfoComponent } from './livre-info.component';

describe('LivreInfoComponent', () => {
  let component: LivreInfoComponent;
  let fixture: ComponentFixture<LivreInfoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LivreInfoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LivreInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
