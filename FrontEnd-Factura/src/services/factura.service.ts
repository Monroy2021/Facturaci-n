import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baserUrl from './helper';


@Injectable({
  providedIn: 'root'
})
export class FacturaService {

  constructor(private http: HttpClient) { }   
  
  public listarFacturas(){
      return this.http.get(`${baserUrl}/facturas/`);
  }

  public guardarFactura(factura:any){
    return this.http.post(`${baserUrl}/factura/`,factura);
  } 

  
  public actualizarFactura(factura:any){
    return this.http.put(`${baserUrl}/factura/`,factura);
  }

}
