import {environment} from '../../environments/environment';


import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Category} from '../model/category';
import {Patient} from '../model/patient';
const API_URL = `${environment.apiUrl}/patients`;
@Injectable({
  providedIn: 'root'
})
export class PatientService {
  constructor(private http: HttpClient) { }

  getAll(): Observable<Patient[]> {
    return this.http.get<Patient[]>(API_URL);
  }
}
