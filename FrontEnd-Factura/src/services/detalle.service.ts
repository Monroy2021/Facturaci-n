import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baserUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class DetalleService {

  constructor(private http: HttpClient) { }

  public listarDetalles() {
    return this.http.get(`${baserUrl}/detalles/`);
  }

  public guardarDetalle(detalle: any) {
    return this.http.post(`${baserUrl}/detalle/`, detalle);
  }


  public actualizarDetalle(detalle: any) {
    return this.http.put(`${baserUrl}/detalle/`, detalle);
  }
}
