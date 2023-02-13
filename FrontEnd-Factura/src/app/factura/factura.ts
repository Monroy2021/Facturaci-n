import { cliente } from "../cliente/cliente";
import { Product } from "../producto/producto";

export interface factura{
  detalle: detalle[];
  cliente: cliente;
}

export interface detalle{
  producto: Product;
  cantidad: number;
  precioVariante: number;
}
