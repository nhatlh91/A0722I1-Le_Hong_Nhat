import {Injectable} from '@angular/core';
import {Customer} from '../model/Customer';
import {environment} from '../../environments/environment';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

const API_URL = `${environment.apiUrl}/customers`;

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  customers: Customer[] = [];

  constructor(private httpClient: HttpClient) {
  }

  getAll(): Observable<Customer[]> {
    return this.httpClient.get<Customer[]>(API_URL);
  }

  getById(id: number): Observable<Customer[]> {
    return this.httpClient.get<Customer[]>(`${API_URL}/${id}`);
  }

  save(customer: Customer) {
    this.httpClient.post(`${API_URL}`, customer);
  }

  delete(id: number) {
    this.httpClient.delete(`${API_URL}/${id}`);
  }

  update(customer: Customer) {
    this.httpClient.put<Customer>(`${API_URL}/${customer.id}`, customer);
  }
}
