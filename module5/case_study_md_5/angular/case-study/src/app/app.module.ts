import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { FooterComponent } from './footer/footer.component';
import { SideBarComponent } from './side-bar/side-bar.component';
import { AddCustomerComponent } from './customer/add-customer/add-customer.component';
import { ReactiveFormsModule} from '@angular/forms';
import { ListCustomerComponent } from './customer/list-customer/list-customer.component';
import { EditCustomerComponent } from './customer/edit-customer/edit-customer.component';

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    FooterComponent,
    SideBarComponent,
    AddCustomerComponent,
    ListCustomerComponent,
    EditCustomerComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        ReactiveFormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
