import {Component, OnInit} from '@angular/core';
import {Contract} from '../../../model/contract';
import {ContractService} from '../../../service/contract.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-contract-list',
  templateUrl: './contract-list.component.html',
  styleUrls: ['./contract-list.component.css']
})
export class ContractListComponent implements OnInit {
  contracts: Contract[];
  pageSize = 5;
  p: number;

  constructor(private contractService: ContractService) {
  }

  ngOnInit(): void {
    this.showList();
  }

  showList() {
    this.contractService.getAll().subscribe(next => {
      this.contracts = next;
    });
  }

  pageChanged($event: number) {
    this.p = $event;
  }

  delete(id) {
    Swal.fire({
      title: 'Confirm to delete this contract',
      showCancelButton: true,
      confirmButtonText: 'Confirm',
    }).then((result) => {
      if (result.isConfirmed) {
        this.contractService.delete(id).subscribe(next => {
          Swal.fire('Deleted!', '', 'success');
          this.showList();
        });
      }
    });
  }
}
