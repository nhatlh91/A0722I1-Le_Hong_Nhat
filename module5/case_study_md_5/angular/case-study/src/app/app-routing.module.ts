import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListCustomerComponent} from './customer/list-customer/list-customer.component';
import {AddCustomerComponent} from './customer/add-customer/add-customer.component';
import {EditCustomerComponent} from './customer/edit-customer/edit-customer.component';


const routes: Routes = [
  {
    path: 'customer/list',
    component: ListCustomerComponent
  },
  {
    path: 'customer/create',
    component: AddCustomerComponent
  },
  {
    path: 'customer/edit/:customerCode',
    component: EditCustomerComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
