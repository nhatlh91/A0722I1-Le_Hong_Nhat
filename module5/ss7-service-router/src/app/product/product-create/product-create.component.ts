import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ProductService} from '../../service/product.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  productForm: FormGroup = new FormGroup({
  id: new FormControl('', [Validators.required]),
  name: new FormControl('', [Validators.required]),
  price: new FormControl('', [Validators.required, Validators.min(0)]),
  description: new FormControl('', [Validators.required]),
});
  constructor(private productService: ProductService,
              private router: Router) { }

  ngOnInit(): void {
  }

  submit() {
    const product = this.productForm.value;
    this.productService.saveProduct(product);
    // this.productForm.reset();
    this.router.navigateByUrl('/product/list');
  }

}
