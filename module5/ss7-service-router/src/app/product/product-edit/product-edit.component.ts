import {Component, OnInit} from '@angular/core';
import {ProductService} from '../../service/product.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Product} from '../../model/product';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {CategoryService} from '../../service/category.service';
import {Category} from '../../model/category';

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
              private router: Router,
              private fb: FormBuilder) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(param => {
      const id = parseInt(param.get('id'), 10);
      this.productService.findById(id).subscribe(item => {
        this.product = item;
        this.rf =  new FormGroup({
          id: new FormControl(this.product.id),
          name: new FormControl(this.product.name, [Validators.required]),
          price: new FormControl(this.product.price, [Validators.required, Validators.min(0)]),
          description: new FormControl(this.product.description, [Validators.required]),
          category: new FormControl(this.product.category, [Validators.required]),
          purchasingDate: new FormControl(this.product.purchasingDate, [Validators.required]),
        });
      });
    });
    this.categoryService.getAll().subscribe(item => {
      this.categories = item;
    });
    // this.rf =  new FormGroup({
    //   id: new FormControl(this.product.id),
    //   name: new FormControl(this.product.name, [Validators.required]),
    //   price: new FormControl(this.product.price, [Validators.required, Validators.min(0)]),
    //   description: new FormControl(this.product.description, [Validators.required]),
    //   category: new FormControl(this.product.category, [Validators.required]),
    //   purchasingDate: new FormControl(this.product.purchasingDate, [Validators.required]),
    // });
    // this.rf = this.fb.group({
    //   id: this.product.id,
    //   name: [this.product.name, Validators.required],
    //   price: [this.product.price, Validators.required, Validators.min(0)],
    //   description: [this.product.description, Validators.required],
    //   category: [this.product.category, Validators.required],
    //   purchasingDate: [this.product.purchasingDate, Validators.required]
    // });
  }

  update() {
    this.productService.update(this.rf.value).subscribe(next => {
      alert('Updated successfully');
      this.router.navigateByUrl('/product/list');
    });

  }
}
