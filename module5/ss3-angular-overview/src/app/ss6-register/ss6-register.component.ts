import { Component, OnInit } from '@angular/core';
import {FormGroup} from '@angular/forms';

@Component({
  selector: 'app-ss6-register',
  templateUrl: './ss6-register.component.html',
  styleUrls: ['./ss6-register.component.css']
})
export class Ss6RegisterComponent implements OnInit {
  registerForm = new FormGroup({

  });

  countries: string[] = ['Vietnam', 'India', 'Malaysia', 'Thailand'];

  constructor() { }

  ngOnInit(): void {
  }

  protected readonly FormGroup = FormGroup;
}
