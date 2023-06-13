import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormControl, FormGroup, ValidatorFn, Validators} from '@angular/forms';
import {ContractService} from '../../../service/contract.service';
import {CustomerService} from '../../../service/customer.service';
import {EmployeeService} from '../../../service/employee.service';
import {FacilityService} from '../../../service/facility.service';
import {Facility} from '../../../model/facility';
import {Customer} from '../../../model/Customer';
import {Employee} from '../../../model/employee';
import Swal from 'sweetalert2';
import {Router} from '@angular/router';

@Component({
  selector: 'app-contract-create',
  templateUrl: './contract-create.component.html',
  styleUrls: ['./contract-create.component.css']
})
export class ContractCreateComponent implements OnInit {
  rf: FormGroup;
  facilities: Facility[];
  customers: Customer[];
  employees: Employee[];

  constructor(private contractService: ContractService,
              private customerService: CustomerService,
              private employeeService: EmployeeService,
              private facilityService: FacilityService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.facilityService.getAll().subscribe(next => {
      this.facilities = next;
    });
    this.employeeService.getAll().subscribe(next => {
      this.employees = next;
    });
    this.customerService.getAll().subscribe(next => {
      this.customers = next;
    });
    this.rf = new FormGroup({
      employee: new FormControl('', [Validators.required]),
      customer: new FormControl('', [Validators.required]),
      facility: new FormControl('', [Validators.required]),
      beginDate: new FormControl('', [Validators.required]),
      endDate: new FormControl('', [Validators.required]),
      deposit: new FormControl('', [Validators.required, Validators.min(500)]),
      totalAmount: new FormControl(''),
    });
  }

  save() {
    this.contractService.save(this.rf.value).subscribe(next => {
      Swal.fire('Saved', '', 'success')
        .then(next2 => {
          this.rf.reset();
          this.router.navigateByUrl('/contract/list');
        });
    });
  }

  calTheCost() {
    const totalAmount = this.rf.value.facility.cost;
    this.rf.controls.totalAmount.setValue(totalAmount);
  }

  checkEndDate($event) {
    this.rf.controls.endDate.setValidators(CustomValidator($event.target.value));
  }
}

export function CustomValidator(input: string): ValidatorFn {
  return (control: AbstractControl): { [key: string]: any } => {
    const checkin: Date = new Date(input);
    const checkout: Date = new Date(control.value);
    const isValid = checkout.valueOf() -  checkin.valueOf() >= 0;
    return isValid ? null : {wrongTime: 'Wrong date'};
  };
}
