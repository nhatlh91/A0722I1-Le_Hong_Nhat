import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {Facility} from '../model/facility';
const API_URL = `${environment.apiUrl}/facilities`;

@Injectable({
  providedIn: 'root'
})
export class FacilityService {

  constructor(private httpClient: HttpClient) {}

  getAll() {
    return this.httpClient.get<Facility[]>(API_URL);
  }
  getById(id: number) {
    return this.httpClient.get<Facility>(`${API_URL}/${id}`);
  }

  save(facility: Facility) {
    return this.httpClient.post<Facility>(`${API_URL}`, facility);
  }

  update(facility: Facility) {
    return this.httpClient.put<Facility>(`${API_URL}/${facility.id}`, facility);
  }

  delete(id: number) {
    return this.httpClient.delete<Facility>(`${API_URL}/${id}`);
  }
}
