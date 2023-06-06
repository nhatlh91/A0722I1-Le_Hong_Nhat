import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {ProductService} from '../../service/product.service';
import {Product} from '../../model/product';

@Component({
  selector: 'app-product-search',
  templateUrl: './product-search.component.html',
  styleUrls: ['./product-search.component.css']
})
export class ProductSearchComponent implements OnInit {
  rf: FormGroup;
  products: Product[] = [];
  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.rf = new FormGroup({
      name: new FormControl(''),
      description: new FormControl(''),
      beginDate: new FormControl(''),
      endDate: new FormControl(''),
    });
  }

  search() {
    console.log(this.rf.value.name);
    console.log(this.rf.value.description);
    console.log(this.rf.value.beginDate);
    console.log(this.rf.value.endDate);
    console.log(this.rf.value.endDate === '');
    const form = this.rf.value;
    let keyword = `?name_like=${this.rf.value.name}&description_like=${this.rf.value.description}&purchasingDate_gte=${this.rf.value.beginDate}`;
    if (this.rf.value.endDate !== '') {
      keyword += `&purchasingDate_lte=${this.rf.value.endDate}`;
    }
    console.log(keyword);
    this.productService.search(keyword).subscribe(next => {
      this.products = next;
      console.log(this.products);
    });
  }
}
