import {Component, OnInit} from '@angular/core';
import Swal from 'sweetalert2';
import {Recordz} from '../../../model/recordz';
import {RecordService} from '../../../service/record.service';
import {PatientService} from '../../../service/patient.service';

@Component({
  selector: 'app-record-list',
  templateUrl: './record-list.component.html',
  styleUrls: ['./record-list.component.css']
})
export class RecordListComponent implements OnInit {
  records: Recordz[] = [];
  p = 1;

  constructor(private recordService: RecordService,
              private patientService: PatientService) {
  }

  getAll() {
    this.recordService.getAll().subscribe(item => {
      this.records = item;
    });
  }

  ngOnInit(): void {
    this.getAll();
  }

  delete(id: number) {
    this.recordService.findById(id).subscribe(next => {
      Swal.fire({
        title: `Xác nhận xoá thông tin bệnh án BA-${next.id}`,
        showCancelButton: true,
        confirmButtonText: 'OK',
      }).then((result) => {
        /* Read more about isConfirmed, isDenied below */
        if (result.isConfirmed) {
          this.recordService.delete(id).subscribe(next2 => {
            Swal.fire('Đã xoá!', '', 'success');
            this.getAll();
          });
        }
      });
    });
  }
}
