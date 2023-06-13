import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ProductService} from '../../../service/product.service';
import {Router} from '@angular/router';
import {CategoryService} from '../../../service/category.service';
import {Category} from '../../../model/category';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  rf: FormGroup;
  categories: Category[];
  constructor(private productService: ProductService,
              private categoryService: CategoryService,
              private router: Router) { }

  ngOnInit(): void {
    this.rf = new FormGroup({
      name: new FormControl('', [Validators.required]),
      price: new FormControl('', [Validators.required, Validators.min(0)]),
      description: new FormControl('', [Validators.required]),
      category: new FormControl('', [Validators.required]),
      date: new FormControl('', [Validators.required])
    });
    this.categoryService.getAll().subscribe(item => {
      this.categories = item;
    });
  }

  save() {
    this.productService.saveProduct(this.rf.value).subscribe(next => {
      Swal.fire(
        'Saved',
        'Return to product list',
        'success'
      ).then(r => {
        this.rf.reset();
        this.router.navigateByUrl('/products/list');
      });
      });
  }
}

