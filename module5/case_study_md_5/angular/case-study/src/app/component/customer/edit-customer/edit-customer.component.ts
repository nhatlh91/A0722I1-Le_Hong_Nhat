import { Component, OnInit } from '@angular/core';
import {CustomerService} from '../../../service/customer.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Customer} from '../../../model/Customer';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {CustomerTypeService} from '../../../service/customer-type.service';
import {CustomerType} from "../../../model/customer-type";

@Component({
  selector: 'app-edit-customer',
  templateUrl: './edit-customer.component.html',
  styleUrls: ['./edit-customer.component.css']
})
export class EditCustomerComponent implements OnInit {
  customer: Customer;
  customerForm: FormGroup;
  customerTypes: CustomerType[];

  constructor(private customerService: CustomerService,
              private customerTypeService: CustomerTypeService,
              private router: Router,
              private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(param => {
      const id = parseInt(param.get('id'), 10);
      this.customerService.getById(id).subscribe(next => {
        this.customer = next;
        this.customerTypeService.getAll().subscribe(item =>
        this.customerTypes = item);
        this.buildForm();
      });
    });
  }

  save() {
    this.customerService.update(this.customer);
    this.router.navigateByUrl('/customer/list');

  }

  buildForm() {
    this.customerForm = new FormGroup({
      customerCode: new FormControl(this.customer.id, [Validators.required, Validators.pattern(/^KH-\d{4}$/)]),
      customerName: new FormControl(this.customer.customerName, [Validators.required]),
      birthday: new FormControl(this.customer.birthday, [Validators.required]),
      gender: new FormControl(this.customer.gender, [Validators.required]),
      idNumber: new FormControl(this.customer.idNumber, [Validators.required, Validators.pattern(/\d{9,11}/)]),
      phone: new FormControl(this.customer.phone, [Validators.required, Validators.pattern(/^(091|090|\+8490|\+8491)\d{7}$/)]),
      email: new FormControl(this.customer.email, [Validators.email]),
      type: new FormControl(this.customer.type, [Validators.required]),
      address: new FormControl(this.customer.address, [Validators.required]),
    });
  }

}
