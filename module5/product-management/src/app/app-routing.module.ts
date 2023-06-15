import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {RecordListComponent} from './component/record/record-list/record-list.component';
import {RecordEditComponent} from './component/record/record-edit/record-edit.component';


const routes: Routes = [
  {
    path: 'records/list',
    component: RecordListComponent
  },
  {
    path: 'records/edit/:id',
    component: RecordEditComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
