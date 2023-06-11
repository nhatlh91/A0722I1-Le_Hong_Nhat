import { Component, OnInit } from '@angular/core';
import {ProductService} from '../../../service/product.service';
import {ActivatedRoute, Router} from '@angular/router';


@Component({
  selector: 'app-product-delete',
  templateUrl: './product-delete.component.html',
  styleUrls: ['./product-delete.component.css']
})
export class ProductDeleteComponent implements OnInit {

  constructor(private productService: ProductService,
              private activatedRoute: ActivatedRoute,
              private router: Router) { }

  ngOnInit(): void {
    this.del();
  }
  private del() {
    this.activatedRoute.paramMap.subscribe(param => {
      const id = parseInt(param.get('id'), 10);
      this.productService.delete(id).subscribe(next => {
        alert('Deleted successfully, Back to product list');
        this.router.navigateByUrl('/product/list');
      });
    });
  }
}
