import { Component, OnInit } from '@angular/core';
import {CustomerService} from '../service/customer.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Customer} from '../../model/Customer';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-edit-customer',
  templateUrl: './edit-customer.component.html',
  styleUrls: ['./edit-customer.component.css']
})
export class EditCustomerComponent implements OnInit {
  customer: Customer;
  customerForm: FormGroup;
  customerTypes: string[] = ['Member', 'Silver', 'Gold', 'Platinum', 'Diamond'];

  constructor(private customerService: CustomerService,
              private router: Router,
              private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(param => {
      const code = param.get('customerCode');
      this.customer = this.customerService.getByCode(code);
    });
    this.buildForm();
  }

  save() {
    this.customerService.update(this.customer);
    this.router.navigateByUrl('/customer/list');

  }

  buildForm() {
    this.customerForm = new FormGroup({
      customerCode: new FormControl(this.customer.customerCode, [Validators.required, Validators.pattern(/^KH-\d{4}$/)]),
      customerName: new FormControl(this.customer.customerName, [Validators.required]),
      birthday: new FormControl(this.customer.birthday, [Validators.required]),
      gender: new FormControl(this.customer.gender, [Validators.required]),
      idNumber: new FormControl(this.customer.idNumber, [Validators.required, Validators.pattern(/\d{9,11}/)]),
      phone: new FormControl(this.customer.phone, [Validators.required, Validators.pattern(/^(091|090|\+8490|\+8491)\d{7}$/)]),
      email: new FormControl(this.customer.email, [Validators.email]),
      typeOfCustomer: new FormControl(this.customer.typeOfCustomer, [Validators.required]),
      address: new FormControl(this.customer.address, [Validators.required]),
    });
  }

}
