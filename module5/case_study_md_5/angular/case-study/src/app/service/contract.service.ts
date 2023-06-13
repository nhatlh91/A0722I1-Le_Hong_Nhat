import { Injectable } from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Contract} from '../model/contract';
const API_URL = `${environment.apiUrl}/contracts`;

@Injectable({
  providedIn: 'root'
})
export class ContractService {
  constructor(private httpClient: HttpClient) {
  }

  getAll(): Observable<Contract[]> {
    return this.httpClient.get<Contract[]>(API_URL);
  }

  getById(id: number): Observable<Contract> {
    return this.httpClient.get<Contract>(`${API_URL}/${id}`);
  }

  save(contract: Contract): Observable<Contract> {
    return this.httpClient.post<Contract>(API_URL, contract);
  }

  delete(id: number) {
    return this.httpClient.delete<Contract>(`${API_URL}/${id}`);
  }

  update(contract: Contract) {
    return this.httpClient.put<Contract>(`${API_URL}/${contract.id}`, contract);
  }
}
