import {Injectable} from '@angular/core';
import {ExtraService} from '../model/extra-service';

@Injectable({
  providedIn: 'root'
})
export class ExtraServiceService {
  extraServices: ExtraService[] = [
    {
      id: 1,
      name: 'massage',
      price: 400000,
      unit: 1,
      isReady: true
    },
    {
      id: 2,
      name: 'karaoke',
      price: 200000,
      unit: 1,
      isReady: true
    },
    {
      id: 3,
      name: 'dinner',
      price: 500000,
      unit: 1,
      isReady: true
    },
    {
      id: 4,
      name: 'e-bike',
      price: 100000,
      unit: 1,
      isReady: true
    }
  ];

  constructor() {
  }

  getAll() {
    return this.extraServices;
  }

  getById(id: number) {
    let extraService: ExtraService;
    for (const item of this.extraServices) {
      if (item.id === id) {
        extraService = item;
        break;
      }
    }
    return extraService;
  }
}
