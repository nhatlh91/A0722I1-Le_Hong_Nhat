import {Component, OnInit} from '@angular/core';
import {Customer} from '../../model/Customer';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {CustomerService} from '../service/customer.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-add-customer',
  templateUrl: './add-customer.component.html',
  styleUrls: ['./add-customer.component.css']
})
export class AddCustomerComponent implements OnInit {
  customers: Customer[];
  addCustomerForm: FormGroup;
  customerTypes: string[] = ['Member', 'Silver', 'Gold', 'Platinum', 'Diamond'];
  customer: Customer = {};

  constructor(private customeService: CustomerService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.buildForm();
  }

  save() {
    this.customeService.customers.push(this.customer);
    this.router.navigateByUrl('/customer/list');
  }

  private buildForm() {
    this.addCustomerForm = new FormGroup({
      customerCode: new FormControl('', [Validators.required, Validators.pattern(/^KH-\d{4}$/)]),
      customerName: new FormControl('', [Validators.required]),
      birthday: new FormControl('', [Validators.required]),
      gender: new FormControl('', [Validators.required]),
      idNumber: new FormControl('', [Validators.required, Validators.pattern(/\d{9,11}/)]),
      phone: new FormControl('', [Validators.required, Validators.pattern(/^(091|090|\+8490|\+8491)\d{7}$/)]),
      email: new FormControl('', [Validators.email]),
      typeOfCustomer: new FormControl('', [Validators.required]),
      address: new FormControl('', [Validators.required]),
    });
  }
}
