import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BiblioTableComponent } from './biblio-table.component';

describe('BiblioTableComponent', () => {
  let component: BiblioTableComponent;
  let fixture: ComponentFixture<BiblioTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BiblioTableComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BiblioTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
