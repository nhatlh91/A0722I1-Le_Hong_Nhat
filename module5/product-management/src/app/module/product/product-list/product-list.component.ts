import {Component, OnInit} from '@angular/core';
import {ProductService} from '../../../service/product.service';
import {Product} from '../../../model/product';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products: Product[] = [];
  p: number = 1;

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

  delete(id: number) {
    Swal.fire({
      title: 'Confirm to delete this product ?',
      showCancelButton: true,
      confirmButtonText: 'Confirm',
    }).then((result) => {
      /* Read more about isConfirmed, isDenied below */
      if (result.isConfirmed) {
        this.productService.delete(id).subscribe(next => {
          Swal.fire('Deleted! Back to list', '', 'success');
          this.getAll();
        });
      } else {
        Swal.fire('Canceled', '', 'info');
      }
    });
  }
}
