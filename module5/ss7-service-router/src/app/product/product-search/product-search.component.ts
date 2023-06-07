import {Component, EventEmitter, OnInit, Output} from '@angular/core';
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
  @Output() newItemEvent = new EventEmitter<Product[]>();

  constructor(private productService: ProductService) {
  }

  ngOnInit(): void {
    this.rf = new FormGroup({
      name: new FormControl(''),
      description: new FormControl(''),
      beginDate: new FormControl(''),
      endDate: new FormControl(''),
    });
  }

  search() {
    let keyword = '?';
    const name = this.rf.value.name;
    console.log(`name: ${name}`);
    if (name !== '' && name != null) {
      keyword += `name_like=${name}&`;
    }
    const description = this.rf.value.description;
    console.log(`description: ${description}`);
    if (description !== '' && description != null) {
      keyword += `description_like=${description}&`;
    }
    const beginDate = this.rf.value.beginDate;
    console.log(`beginDate: ${beginDate}`);
    if (beginDate !== '' && beginDate != null) {
      keyword += `purchasingDate_gte=${beginDate}&`;
    }
    const endDate = this.rf.value.endDate;
    console.log(`endDate: ${endDate}`);
    if (endDate !== '' && endDate != null) {
      keyword += `purchasingDate_lte=${endDate}`;
    }
    console.log(`keyword: ${keyword}`);
    this.productService.search(keyword).subscribe(next => {
      console.log(next);
      this.newItemEvent.emit(next);
    });
  }
}
