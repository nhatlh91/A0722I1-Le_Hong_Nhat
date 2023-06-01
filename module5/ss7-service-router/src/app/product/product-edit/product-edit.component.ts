import { Component, OnInit } from '@angular/core';
import {ProductService} from '../../service/product.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Product} from '../../model/product';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {
  product: Product;
  editForm: FormGroup;

  constructor(private productService: ProductService,
              private activatedRoute: ActivatedRoute,
              private router: Router) { }

  ngOnInit(): void {
    this.findById();
    this.loadForm();
  }

  findById() {
    this.activatedRoute.paramMap.subscribe(param => {
      const id = parseInt(param.get('id'), 10);
      this.product = this.productService.findById(id);
    });
  }

  loadForm() {
    this.editForm = new FormGroup({
      id: new FormControl(this.product.id, [Validators.required]),
      name: new FormControl(this.product.name, [Validators.required]),
      price: new FormControl(this.product.price, [Validators.required, Validators.min(0)]),
      description: new FormControl(this.product.description, [Validators.required]),
    });
  }

  update() {
    this.productService.update(this.editForm.value);
    this.router.navigateByUrl('/product/list');
  }
}
