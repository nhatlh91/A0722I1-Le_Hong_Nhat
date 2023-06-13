import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {FacilityRoutingModule} from './facility-routing.module';
import {FacilityListComponent} from './facility-list/facility-list.component';
import {NgxPaginationModule} from 'ngx-pagination';
import {FacilityCreateComponent} from './facility-create/facility-create.component';
import {ReactiveFormsModule} from '@angular/forms';
import {FacilityEditComponent} from './facility-edit/facility-edit.component';


@NgModule({
  declarations: [
    FacilityListComponent,
    FacilityCreateComponent,
    FacilityEditComponent
  ],
  imports: [
    CommonModule,
    FacilityRoutingModule,
    NgxPaginationModule,
    ReactiveFormsModule
  ]
})
export class FacilityModule {
}
