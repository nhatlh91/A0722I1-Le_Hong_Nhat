import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-ss6-login',
  templateUrl: './ss6-login.component.html',
  styleUrls: ['./ss6-login.component.css']
})
export class Ss6LoginComponent implements OnInit {
  loginForm: FormGroup;

  constructor() {
  }

  ngOnInit(): void {
    this.loginForm = new FormGroup({
      email: new FormControl('', [Validators.required, Validators.email]),
      password: new FormControl('', [Validators.required, Validators.minLength(6)])
    });
  }
}
