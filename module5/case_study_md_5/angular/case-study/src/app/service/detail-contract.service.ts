import {Injectable} from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {DetailContract} from '../model/detail-contract';

const API_URL = `${environment.apiUrl}/detail-contracts`;

@Injectable({
  providedIn: 'root'
})
export class DetailContractService {

  constructor(private httpClient: HttpClient) {
  }

  getAll(): Observable<DetailContract[]> {
    return this.httpClient.get<DetailContract[]>(`${API_URL}`);
  }

  getById(id: number): Observable<DetailContract> {
    return this.httpClient.get<DetailContract>(`${API_URL}/${id}`);
  }

  save(detailContract: DetailContract): Observable<DetailContract> {
    return this.httpClient.post<DetailContract>(`${API_URL}`, detailContract);
  }
}
