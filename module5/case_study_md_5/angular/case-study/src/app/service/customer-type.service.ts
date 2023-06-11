import {Injectable} from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Customer} from '../model/Customer';
import {CustomerType} from '../model/customer-type';

const API_URL = `${environment.apiUrl}/customer-types`;

@Injectable({
  providedIn: 'root'
})
export class CustomerTypeService {
  constructor(private httpClient: HttpClient) {
  }

  getAll(): Observable<CustomerType[]> {
    return this.httpClient.get<CustomerType[]>(API_URL);
  }

  getById(id: number): Observable<CustomerType> {
    return this.httpClient.get<CustomerType>(`${API_URL}/${id}`);
  }

  save(type: CustomerType) {
    this.httpClient.post(`${API_URL}`, type);
  }

  delete(id: number) {
    this.httpClient.delete(`${API_URL}/${id}`);
  }

  update(type: CustomerType) {
    this.httpClient.put<Customer>(`${API_URL}/${type.id}`, type);
  }

}
