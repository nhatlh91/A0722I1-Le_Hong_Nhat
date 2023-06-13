import {Component, OnInit} from '@angular/core';
import {FacilityService} from '../../../service/facility.service';
import {ActivatedRoute, Router} from '@angular/router';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-facility-edit',
  templateUrl: './facility-edit.component.html',
  styleUrls: ['./facility-edit.component.css']
})
export class FacilityEditComponent implements OnInit {
  rf: FormGroup;
  facilityTypes: string[] = ['Vila', 'House', 'Room'];
  rentTypes: string[] = ['Hour', 'Day', 'Month', 'Year'];
  constructor(private facilityService: FacilityService,
              private router: Router,
              private activatedRoute: ActivatedRoute) {
  }
  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(param => {
      const id = parseInt(param.get('id'), 10);
      this.facilityService.getById(id).subscribe(next => {
        this.rf = new FormGroup({
          id: new FormControl(next.id),
          type: new FormControl(next.type, [Validators.required]),
          name: new FormControl(next.name, [Validators.required]),
          area: new FormControl(next.area, [Validators.required, Validators.min(50)]),
          cost: new FormControl(next.cost, [Validators.required, Validators.min(500000)]),
          capacity: new FormControl(next.capacity, [Validators.required, Validators.min(2), Validators.max(10)]),
          rentType: new FormControl(next.rentType, [Validators.required]),
          roomStandard: new FormControl(next.roomStandard),
          otherConvenience: new FormControl(next.otherConvenience),
          poolArea: new FormControl(next.poolArea, [Validators.min(20)]),
          floor: new FormControl(next.floor, [Validators.min(1)]),
          extraServices: new FormControl(next.extraServices)
        });
      });
    });
  }
  save() {
    this.facilityService.update(this.rf.value).subscribe(next => {
      Swal.fire('Saved', '', 'success')
        .then(r => {
          this.router.navigateByUrl('/facility/list');
        });
    });
  }
}
