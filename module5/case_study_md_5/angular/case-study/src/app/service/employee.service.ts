import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Facility} from '../model/facility';
import {environment} from '../../environments/environment';
import {Employee} from '../model/employee';
const API_URL = `${environment.apiUrl}/employees`;


@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  constructor(private httpClient: HttpClient) {}

  getAll() {
    return this.httpClient.get<Employee[]>(API_URL);
  }
  getById(id: number) {
    return this.httpClient.get<Employee>(`${API_URL}/${id}`);
  }

  save(employee: Employee) {
    return this.httpClient.post<Employee>(`${API_URL}`, employee);
  }

  update(employee: Employee) {
    return this.httpClient.put<Employee>(`${API_URL}/${employee.id}`, employee);
  }

  delete(id: number) {
    return this.httpClient.delete<Facility>(`${API_URL}/${id}`);
  }
}
