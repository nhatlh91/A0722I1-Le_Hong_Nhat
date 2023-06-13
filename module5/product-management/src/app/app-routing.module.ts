import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';


const routes: Routes = [
  {
    path: 'categories',
    loadChildren: () => import('./module/category/category.module').then(module => module.CategoryModule)
  },
  {
    path: 'products',
    loadChildren: () => import('./module/product/product.module').then(module => module.ProductModule)
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
