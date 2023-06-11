import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {NgxPaginationModule} from 'ngx-pagination';
import {ProductListComponent} from './module/product/product-list/product-list.component';
import {ProductCreateComponent} from './module/product/product-create/product-create.component';
import {ProductDeleteComponent} from './module/product/product-delete/product-delete.component';
import {ProductEditComponent} from './module/product/product-edit/product-edit.component';
import {ProductSearchComponent} from './module/product/product-search/product-search.component';
import {CategoryCreateComponent} from './module/category/category-create/category-create.component';
import {CategoryListComponent} from './module/category/category-list/category-list.component';
import {CategoryEditComponent} from './module/category/category-edit/category-edit.component';
import {CategoryDeleteComponent} from './module/category/category-delete/category-delete.component';

@NgModule({
  declarations: [
    AppComponent,
    ProductListComponent,
    ProductCreateComponent,
    ProductDeleteComponent,
    ProductEditComponent,
    ProductSearchComponent,
    CategoryCreateComponent,
    CategoryListComponent,
    CategoryEditComponent,
    CategoryDeleteComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        ReactiveFormsModule,
        HttpClientModule,
        FormsModule,
        NgxPaginationModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
