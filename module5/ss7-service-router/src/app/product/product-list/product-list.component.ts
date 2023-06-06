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
  search(keyword: string) {
    console.log(keyword);
    const productSet: Set<Product> = new Set<Product>();
    this.productService.searchByName(keyword).subscribe(next => {
      console.log(next);
      next.forEach(item => {
        productSet.add(item);
      });
    });
    this.productService.searchByDescription(keyword).subscribe(next => {
      console.log(next);
      next.forEach(item => {
        productSet.add(item);
      });
    });
    this.products = [];
    productSet.forEach(item => {
      this.products.push(item);
    });
    debugger;
  }

}
