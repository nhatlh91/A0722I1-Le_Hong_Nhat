import {Component, OnInit} from '@angular/core';
import {Facility} from '../../../model/facility';
import {FacilityService} from '../../../service/facility.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-facility-list',
  templateUrl: './facility-list.component.html',
  styleUrls: ['./facility-list.component.css']
})
export class FacilityListComponent implements OnInit {
  facilities: Facility[];
  pageSize = 5;
  p: number ;
  constructor(private factilityService: FacilityService) {
  }
  ngOnInit(): void {
    this.showList();
  }
  showList() {
    this.factilityService.getAll().subscribe(item => {
      this.facilities = item;
    });
  }
  pageChanged($event: number) {
    this.p = $event;
  }
  delete(id: number) {
    Swal.fire({
      title: 'Confirm to delete?',
      showCancelButton: true,
      confirmButtonText: 'Confirm',
    }).then((result) => {
      /* Read more about isConfirmed, isDenied below */
      if (result.isConfirmed) {
        Swal.fire('Deleted!', '', 'warning');
        this.factilityService.delete(id).subscribe(next => {
          this.showList();
        });
      }
    });
  }
}
