import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProductRoutingModule } from './product-routing.module';
import {ProductListComponent} from './product-list/product-list.component';
import {ProductCreateComponent} from './product-create/product-create.component';
import {ProductEditComponent} from './product-edit/product-edit.component';
import {ProductSearchComponent} from './product-search/product-search.component';
import {NgxPaginationModule} from 'ngx-pagination';
import {ReactiveFormsModule} from '@angular/forms';


@NgModule({
  declarations: [
    ProductListComponent,
    ProductCreateComponent,
    ProductEditComponent,
    ProductSearchComponent,
  ],
  imports: [
    CommonModule,
    ProductRoutingModule,
    NgxPaginationModule,
    ReactiveFormsModule
  ]
})
export class ProductModule { }
