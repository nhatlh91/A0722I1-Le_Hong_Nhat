import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CustomerRoutingModule } from './customer-routing.module';
import {AddCustomerComponent} from './add-customer/add-customer.component';
import {ListCustomerComponent} from './list-customer/list-customer.component';
import {EditCustomerComponent} from './edit-customer/edit-customer.component';
import {ReactiveFormsModule} from '@angular/forms';


@NgModule({
  declarations: [
    AddCustomerComponent,
    ListCustomerComponent,
    EditCustomerComponent
  ],
  imports: [
    CommonModule,
    CustomerRoutingModule,
    ReactiveFormsModule
  ]
})
export class CustomerModule { }
