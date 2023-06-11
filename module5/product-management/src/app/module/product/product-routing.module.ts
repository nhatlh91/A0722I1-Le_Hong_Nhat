import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ProductEditComponent} from './product-edit/product-edit.component';
import {ProductDeleteComponent} from './product-delete/product-delete.component';
import {ProductCreateComponent} from './product-create/product-create.component';
import {ProductListComponent} from './product-list/product-list.component';


const routes: Routes = [
  {
    path: '/edit/:id',
    component: ProductEditComponent
  },
  {
    path: '/delete/:id',
    component: ProductDeleteComponent
  },
  {
    path: '/create',
    component: ProductCreateComponent
  },
  {
    path: '/list',
    component: ProductListComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProductRoutingModule { }
