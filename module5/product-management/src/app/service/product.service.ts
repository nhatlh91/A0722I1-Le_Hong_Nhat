import {Injectable} from '@angular/core';
import {Product} from '../model/product';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {Observable} from 'rxjs';
import {de} from 'date-fns/locale';
const API_URL = `${environment.apiUrl}`;

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  constructor(private http: HttpClient) {
  }

  getAll(): Observable<Product[]> {
    return this.http.get<Product[]>(`${API_URL}/products`);
  }

  saveProduct(product: Product): Observable<Product> {
    return this.http.post<Product>(`${API_URL}/products`, product);
  }

  findById(id: number): Observable<Product> {
    return this.http.get<Product>(`${API_URL}/products/${id}`);
  }

  update(product: Product): Observable<Product> {
    return this.http.put<Product>(`${API_URL}/products/${product.id}`, product);
  }

  delete(id: number): Observable<Product> {
    return this.http.delete<Product>(`${API_URL}/products/${id}`);
  }

  searchByName(keyword: string): Observable<Product[]> {
    return this.http.get<Product[]>(`${API_URL}/products?name_like=${keyword}`);
  }

  searchByDescription(keyword: string): Observable<Product[]> {
    return this.http.get<Product[]>(`${API_URL}/products?description_like=${keyword}`);
  }

  search(keyword: string): Observable<Product[]> {
    return this.http.get<Product[]>(`${API_URL}/products${keyword}`);
  }
}

