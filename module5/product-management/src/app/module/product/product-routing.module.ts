import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ProductEditComponent} from './product-edit/product-edit.component';
import {ProductCreateComponent} from './product-create/product-create.component';
import {ProductListComponent} from './product-list/product-list.component';


const routes: Routes = [
  {
    path: 'edit/:id',
    component: ProductEditComponent
  },
  {
    path: 'create',
    component: ProductCreateComponent
  },
  {
    path: 'list',
    component: ProductListComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProductRoutingModule { }
