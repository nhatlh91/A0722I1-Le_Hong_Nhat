import {Injectable} from '@angular/core';
import {Customer} from '../../model/Customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  customers: Customer[] = [
    {
      customerCode: 'KH-0001',
      customerName: 'Nhân',
      birthday: '2000-12-24',
      gender: 'Male',
      idNumber: '386671772',
      phone: '0482991857',
      email: 'nhan@gmail.com',
      typeOfCustomer: 'Member',
      address: 'Cẩm Lệ'
    },
    {
      customerCode: 'KH-0002',
      customerName: 'Thành',
      birthday: '1993-07-11',
      gender: 'Male',
      idNumber: '388671322',
      phone: '0482991955',
      email: 'thanh@gmail.com',
      typeOfCustomer: 'Silver',
      address: 'Duy Xuyên'
    },
    {
      customerCode: 'KH-0004',
      customerName: 'Minh',
      birthday: '1993-04-18',
      gender: 'Male',
      idNumber: '794671752',
      phone: '0902991955',
      email: 'minh@gmail.com',
      typeOfCustomer: 'Silver',
      address: 'Hải Châu'
    },
    {
      customerCode: 'KH-0003',
      customerName: 'Vân',
      birthday: '1996-02-05',
      gender: 'Female',
      idNumber: '388666322',
      phone: '0482997382',
      email: 'van@gmail.com',
      typeOfCustomer: 'Gold',
      address: 'Đắc Lắc'
    },
    {
      customerCode: 'KH-0005',
      customerName: 'Huy',
      birthday: '1999-01-18',
      gender: 'Male',
      idNumber: '388632782',
      phone: '0912991955',
      email: 'huy@outlook.com',
      typeOfCustomer: 'Platinum',
      address: 'Sơn Trà'
    },
    {
      customerCode: 'KH-0006',
      customerName: 'Triêu',
      birthday: '2002-07-02',
      gender: 'Male',
      idNumber: '116671772',
      phone: '0902758892',
      email: 'trieu@gmail.com',
      typeOfCustomer: 'Gold',
      address: 'Quảng Nam'
    }
  ];

  getAll() {
    return this.customers;
  }

  getByCode(code: string) {
    let temp: Customer;
    this.customers.forEach((item: Customer) => {
      if (item.customerCode === code) {
        temp = item;
      }
    });
    return temp;
  }

  save(customer: Customer) {
    this.customers.push(customer);
  }

  delete(customer: Customer) {
    const idx = this.customers.indexOf(customer);
    this.customers.splice(idx, 1);
  }

  update(customer: Customer) {
    const temp: Customer[] = [];
    this.customers.map((item: Customer) => {
      item.customerCode === customer.customerCode ? temp.push(customer) : temp.push(item);
    });
    this.customers = temp;
  }
  constructor() {
  }
}
