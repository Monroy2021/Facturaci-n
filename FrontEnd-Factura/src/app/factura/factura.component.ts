import { Component, OnInit, Input } from '@angular/core';
import { Product } from '../producto/producto';
import { ProductoService } from '../producto/producto.service';
import { ConfirmationService } from 'primeng/api';
import { MessageService } from 'primeng/api';
import { ClienteService } from '../cliente/cliente.service';
import { cliente } from '../cliente/cliente';
import { detalle, factura } from '../factura/factura';
import { DetalleService } from 'src/services/detalle.service';
import { FacturaService } from 'src/services/factura.service';

@Component({
  selector: 'app-root',
  templateUrl: './factura.component.html',
  styleUrls: ['./factura.component.scss'],
})
export class FacturaComponent {

  productDialog: boolean = false;
  searchTerm: string = '';
  productos: any[] = [];
  product!: any;

  selectedProducts!: Product[];
  detalleFactura!: detalle;
  selectedProduct!: Product;
  selectedCliente!: any;
  precioNuevo!: number;
  cantidadNueva!: number;

  factura!: factura;

  submitted: boolean = false;
  clientes: any[] = [];

  constructor(
    private productService: ProductoService,
    private messageService: MessageService,
    private confirmationService: ConfirmationService,
    private clienteService: ClienteService,
    private detalleService: DetalleService,
    private facturaService: FacturaService

  ) { }

  ngOnInit() {
    this.productService.getProductos().subscribe((data) => {
      this.productos = data.data;
    });
    this.clienteService
      .getClientes()
      .subscribe((data) => (this.clientes = data.data));
    this.factura = {
      detalle: [],
      cliente: {
        idCliente: '',
        nombre: '',
        apellido: '',
        direccion: '',
        fechaNacimiento: '',
        telefono: '',
        email: '',
      },
    };
  }

  openNew() {
    this.product = {};
    this.submitted = false;
    this.productDialog = true;
  }

  deleteSelectedProducts() {
    this.confirmationService.confirm({
      message: '¿Estás seguro de que desea eliminar los productos seleccionados?',
      header: 'Confirm',
      icon: 'pi pi-exclamation-triangle',
      accept: () => {
        this.productos = this.productos.filter(
          (val) => !this.selectedProducts.includes(val)
        );
        this.selectedProducts = [];
        this.messageService.add({
          severity: 'success',
          summary: 'Successful',
          detail: 'Products Deleted',
          life: 3000,
        });
      },
    });
  }

  editProduct(detalle: detalle) {
    this.selectedProduct = detalle.producto;
    this.precioNuevo = detalle.precioVariante;
    this.cantidadNueva = detalle.cantidad;
    this.productDialog = true;
  }

  deleteProduct(product: Product) {
    this.confirmationService.confirm({
      message: '¿Estás seguro de que quieres eliminar? ' + product.nombre + '?',
      header: 'Confirm',
      icon: 'pi pi-exclamation-triangle',
      accept: () => {
        this.productos = this.productos.filter(
          (val) => val.id !== product.idPoducto
        );
        this.product = {};
        this.messageService.add({
          severity: 'success',
          summary: 'Successful',
          detail: 'Product Deleted',
          life: 3000,
        });
      },
    });
  }

  hideDialog() {
    this.productDialog = false;
    this.submitted = false;
  }

  saveProduct() {
    this.submitted = true;;

    if (this.selectedProduct.nombre?.trim()) {
      const index = this.factura.detalle.findIndex((object) => {
        return object.producto.idPoducto === this.selectedProduct.idPoducto;
      });
      console.log(
        index
      );

      if (
        this.selectedProduct.idPoducto &&
        index === -1
      ) {
        this.factura?.detalle.push({
          producto: this.selectedProduct,
          cantidad: this.cantidadNueva,
          precioVariante: this.precioNuevo,
        });
        this.messageService.add({
          severity: 'success',
          summary: 'Successful',
          detail: 'Product Updated',
          life: 3000,
        });
      } else {
        const index = this.factura.detalle.findIndex((object) => {
          return object.producto.idPoducto === this.selectedProduct.idPoducto;
        });
        this.factura.detalle[index] = {
          producto: this.selectedProduct,
          cantidad: this.cantidadNueva,
          precioVariante: this.precioNuevo,
        };
      }
      this.productDialog = false;
      this.cantidadNueva = 0;
      this.precioNuevo = 0;
    }
  }

  findIndexById(id: string): number {
    let index = -1;
    for (let i = 0; i < this.productos.length; i++) {
      if (this.productos[i].id === id) {
        index = i;
        break;
      }
    }

    return index;
  }

  createId(): string {
    let id = '';
    var chars =
      'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
    for (var i = 0; i < 5; i++) {
      id += chars.charAt(Math.floor(Math.random() * chars.length));
    }
    return id;
  }
}
