import {Component, OnInit} from '@angular/core';
import {ProductService} from '../../../service/product.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Product} from '../../../model/product';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {CategoryService} from '../../../service/category.service';
import {Category} from '../../../model/category';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {
  product: Product;
  categories: Category[];
  rf: FormGroup;

  constructor(private productService: ProductService,
              private categoryService: CategoryService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(param => {
      const id = parseInt(param.get('id'), 10);
      this.productService.findById(id).subscribe(product => {
        this.rf =  new FormGroup({
          id: new FormControl(product.id),
          name: new FormControl(product.name, [Validators.required]),
          price: new FormControl(product.price, [Validators.required, Validators.min(0)]),
          description: new FormControl(product.description, [Validators.required]),
          category: new FormControl(product.category, [Validators.required]),
          date: new FormControl(product.date, [Validators.required]),
        });
      });
    });
    this.categoryService.getAll().subscribe(categories => {
      this.categories = categories;
    });
  }

  update() {
    this.productService.update(this.rf.value).subscribe(next => {
      Swal.fire(
        'Updated',
        'Return to product list',
        'success'
      ).then(r => {
        this.rf.reset();
        this.router.navigateByUrl('/products/list');
      });
    });
  }
}
