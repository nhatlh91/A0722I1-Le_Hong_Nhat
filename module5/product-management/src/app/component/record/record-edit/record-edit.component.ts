import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormControl, FormGroup, ValidatorFn, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import Swal from 'sweetalert2';
import {Patient} from '../../../model/patient';
import {RecordService} from '../../../service/record.service';
import {PatientService} from '../../../service/patient.service';
import {Recordz} from '../../../model/recordz';

@Component({
  selector: 'app-record-edit',
  templateUrl: './record-edit.component.html',
  styleUrls: ['./record-edit.component.css']
})
export class RecordEditComponent implements OnInit {
  record: Recordz;
  patients: Patient[];
  rf: FormGroup;

  constructor(private recordService: RecordService,
              private patientService: PatientService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(param => {
      const id = parseInt(param.get('id'), 10);
      this.recordService.findById(id).subscribe(rc => {
        this.rf = new FormGroup({
          id: new FormControl(rc.id),
          patient: new FormControl(rc.patient, [Validators.required]),
          in: new FormControl(rc.in, [Validators.required]),
          out: new FormControl(rc.out, [Validators.required]),
          reason: new FormControl(rc.reason, [Validators.required]),
          solution: new FormControl(rc.solution, [Validators.required]),
          doctor: new FormControl(rc.doctor, [Validators.required, Validators.pattern(/[a-z]|[A-z]| /)]),
        });
      });
    });
    this.patientService.getAll().subscribe(patients => {
      this.patients = patients;
    });
  }

  update() {
    this.recordService.update(this.rf.value).subscribe(next => {
      Swal.fire(
        'Cập nhật thành công',
        '',
        'success'
      ).then(r => {
        this.rf.reset();
        this.router.navigateByUrl('/records/list');
      });
    });
  }

  checkEndDate($event) {
    console.log($event.target.value);
    this.rf.controls.out.setValidators(CustomValidator($event.target.value));
  }
}

export function CustomValidator(input: string): ValidatorFn {
  return (control: AbstractControl): { [key: string]: any } => {
    const checkin: Date = new Date(input);
    const checkout: Date = new Date(control.value);
    const isValid = checkout.valueOf() - checkin.valueOf() >= 0;
    return isValid ? null : {wrongTime: 'Wrong date'};
  };
}
