import {Injectable} from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Recordz} from '../model/recordz';

const API_URL = `${environment.apiUrl}/records`;

@Injectable({
  providedIn: 'root'
})
export class RecordService {

  constructor(private http: HttpClient) {
  }
  getAll(): Observable<Recordz[]> {
    return this.http.get<Recordz[]>(`${API_URL}`);
  }

  saveProduct(record: Recordz): Observable<Recordz> {
    return this.http.post<Recordz>(`${API_URL}`, record);
  }

  findById(id: number): Observable<Recordz> {
    return this.http.get<Recordz>(`${API_URL}/${id}`);
  }

  update(record: Recordz): Observable<Recordz> {
    return this.http.put<Recordz>(`${API_URL}/${record.id}`, record);
  }

  delete(id: number): Observable<Recordz> {
    return this.http.delete<Recordz>(`${API_URL}/${id}`);
  }
}
