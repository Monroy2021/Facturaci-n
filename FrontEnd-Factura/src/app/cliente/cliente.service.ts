import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { of } from 'rxjs';
import baserUrl from 'src/services/helper'; 


@Injectable({
  providedIn: 'root'
}) 

export class ClienteService {
  getClientes() {
    let clientes = {
      data: [
        {
          idCliente: 1,
          nombre: 'carlos',
          apellido: 'sanabria',
          direccion: 'calle 13',
          fechaNacimiento: '11-0-5',
          telefono: '115',
          email: 'carlos@gmail.com'
        },
        {
          idCliente: 2,
          nombre: 'Antonio',
          apellido: 'Garcia',
          direccion: 'calle 20',
          fechaNacimiento: '11-0-5',
          telefono: '115',
          email: 'Antonio@gmail.com'
        },
        {
          idCliente: 3,
          nombre: 'José ',
          apellido: 'Lopez',
          direccion: 'calle 10',
          fechaNacimiento: '11-0-5',
          telefono: '115',
          email: 'jose@gmail.com'
        },
      ],
      success: true,
      message: 'Consulta realizada con éxito',
      status: 'OK',
      title: 'Consulta éxitosa',
    };
    return of(clientes);
  }

  constructor(private http: HttpClient) {} 

    public listarClientes(){
      return this.http.get(`${baserUrl}/clientes/`);
  }

  public guardarCliente(cliente:any){
    return this.http.post(`${baserUrl}/cliente/`,cliente);
  } 

  
  public actualizarCliente(cliente:any){
    return this.http.put(`${baserUrl}/cliente/`,cliente);
  }
}
