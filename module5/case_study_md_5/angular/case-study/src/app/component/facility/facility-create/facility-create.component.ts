import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Facility} from '../../../model/facility';
import {FacilityService} from '../../../service/facility.service';
import Swal from 'sweetalert2';
import {Router} from '@angular/router';

@Component({
  selector: 'app-facility-create',
  templateUrl: './facility-create.component.html',
  styleUrls: ['./facility-create.component.css']
})
export class FacilityCreateComponent implements OnInit {
  rf: FormGroup;
  facility: Facility;
  facilityTypes: string[] = ['Vila', 'House', 'Room'];
  rentTypes: string[] = ['Hour', 'Day', 'Month', 'Year'];

  constructor(private facilityService: FacilityService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.rf = new FormGroup({
      type: new FormControl('', [Validators.required]),
      name: new FormControl('', [Validators.required]),
      area: new FormControl('', [Validators.required, Validators.min(50)]),
      cost: new FormControl('', [Validators.required, Validators.min(500000)]),
      capacity: new FormControl('', [Validators.required, Validators.min(2), Validators.max(10)]),
      rentType: new FormControl('', [Validators.required]),
      roomStandard: new FormControl(''),
      otherConvenience: new FormControl(''),
      poolArea: new FormControl('', [Validators.min(20)]),
      floor: new FormControl('', [Validators.min(1)]),
      extraServices: new FormControl('')
    });
  }

  save() {
    this.facilityService.save(this.rf.value).subscribe(next => {
      Swal.fire('Saved', '', 'success');
      this.router.navigateByUrl('/facility/list');
    });
  }
}
