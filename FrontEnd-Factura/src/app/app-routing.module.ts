import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { FacturaComponent } from './factura/factura.component';

const routes: Routes = [
  {
    path: 'factura',
    component: FacturaComponent,
  },
  {
    path: '',
    component: FacturaComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
