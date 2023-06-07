import {Component, OnInit} from '@angular/core';
import {ProductService} from '../../service/product.service';
import {Product} from '../../model/product';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products: Product[] = [];

  constructor(private productService: ProductService) {
  }
  getAll() {
    this.productService.getAll().subscribe(item => {
      this.products = item;
    });
  }
  ngOnInit(): void {
    this.getAll();
  }
  search($event: Product[]) {
    this.products = $event;
  }
}
