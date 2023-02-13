import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { of } from 'rxjs';
import baserUrl from 'src/services/helper';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {
  getProductos() {
    let productos = {
      data: [
        {
          idPoducto: 1,
          nombre: 'Salsas',
          precio: '1000',
          stock: '10',
        },
        {
          idPoducto: 2,
          nombre: 'Refrescos',
          precio: '2000',
          stock: '5',
        },
        {
          idPoducto: 3,
          nombre: 'Cremas',
          precio: '5000',
          stock: '10',
        },
      ],
      success: true,
      message: 'Consulta realizada con éxito',
      status: 'OK',
      title: 'Consulta éxitosa',
    };
    return of(productos);
  }

  constructor(private http: HttpClient) { }

  public listarProductos() {
    return this.http.get(`${baserUrl}/productos/`);
  }

  public guardarProducto(producto: any) {
    return this.http.post(`${baserUrl}/producto/`, producto);
  }


  public actualizarProducto(producto: any) {
    return this.http.put(`${baserUrl}/producto/`, producto);
  }
}
