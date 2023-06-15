import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {NgxPaginationModule} from 'ngx-pagination';
import { NavBarComponent } from './layout/nav-bar/nav-bar.component';
import { RecordListComponent } from './component/record/record-list/record-list.component';
import { RecordEditComponent } from './component/record/record-edit/record-edit.component';
import Swal from 'sweetalert2';

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    RecordListComponent,
    RecordEditComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        ReactiveFormsModule,
        HttpClientModule,
        NgxPaginationModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
