import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaVentaComponent } from './lista-venta.component';

describe('ListaVentaComponent', () => {
  let component: ListaVentaComponent;
  let fixture: ComponentFixture<ListaVentaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ListaVentaComponent]
    });
    fixture = TestBed.createComponent(ListaVentaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
