import {Injectable} from '@angular/core';
import {Product} from '../model/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  products: Product[] = [
    {
      id: 1,
      name: 'IPhone 12',
      price: 24000000,
      description: 'New'
    }, {
      id: 2,
      name: 'IPhone 11',
      price: 15600000,
      description: 'Like new'
    }, {
      id: 3,
      name: 'IPhone X',
      price: 9680000,
      description: '97%'
    }, {
      id: 4,
      name: 'IPhone 8',
      price: 7540000,
      description: '98%'
    }, {
      id: 5,
      name: 'IPhone 11 Pro',
      price: 18950000,
      description: 'Like new'
    }
  ];

  constructor() {
  }

  getAll() {
    return this.products;
  }

  saveProduct(product: Product) {
    this.products.push(product);
  }

  findById(id: number): Product {
    let result: Product;
    this.products.forEach((item: Product) =>{
      if (item.id === id) {
        result = item;
      }
    });
    return result;
  }

  update(product: Product) {
    const tempList: Product[] = [];
    this.products.forEach((item: Product) => {
      item.id === product.id ? tempList.push(product) : tempList.push(item);
    });
    this.products = tempList;
  }

  delete(id: number) {
    const idx: number = this.products.indexOf(this.findById(id));
    this.products.splice(idx, 1);
  }
}
