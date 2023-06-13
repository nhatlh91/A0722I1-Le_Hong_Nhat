import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {CustomerService} from '../../../service/customer.service';
import {Router} from '@angular/router';
import {CustomerTypeService} from '../../../service/customer-type.service';
import {CustomerType} from '../../../model/customer-type';

@Component({
  selector: 'app-add-customer',
  templateUrl: './add-customer.component.html',
  styleUrls: ['./add-customer.component.css']
})
export class AddCustomerComponent implements OnInit {
  rf: FormGroup;
  customerTypes: CustomerType[];

  constructor(private customerService: CustomerService,
              private customertypeService: CustomerTypeService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.buildForm();
    this.customertypeService.getAll().subscribe(next => {
      this.customerTypes = next;
    });
  }

  save() {
    this.customerService.save(this.rf.value).subscribe(next => {
      this.rf.reset();
      this.router.navigateByUrl('/customer/list');
    });
  }

  private buildForm() {
    this.rf = new FormGroup({
      customerCode: new FormControl('', [Validators.required, Validators.pattern(/^KH-\d{4}$/)]),
      customerName: new FormControl('', [Validators.required]),
      birthday: new FormControl('', [Validators.required]),
      gender: new FormControl('', [Validators.required]),
      idNumber: new FormControl('', [Validators.required, Validators.pattern(/\d{9,11}/)]),
      phone: new FormControl('', [Validators.required, Validators.pattern(/^(091|090|\+8490|\+8491)\d{7}$/)]),
      email: new FormControl('', [Validators.email]),
      type: new FormControl('', [Validators.required]),
      address: new FormControl('', [Validators.required])
    });
  }
}
