import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-ss6-register',
  templateUrl: './ss6-register.component.html',
  styleUrls: ['./ss6-register.component.css']
})
export class Ss6RegisterComponent implements OnInit {
  registerForm: FormGroup;
  countries: string[] = ['Vietnam', 'India', 'Malaysia', 'Thailand'];

  constructor() {
  }

  ngOnInit(): void {
    this.registerForm = new FormGroup({
      email: new FormControl('', [Validators.required, Validators.email]),
      password: new FormControl('', [Validators.required, Validators.minLength(6)]),
      confirmPassword: new FormControl('', ),
      country: new FormControl('', [Validators.required]),
      age: new FormControl('', [Validators.required, Validators.min(18)]),
      gender: new FormControl('', [Validators.required]),
      phone: new FormControl('', [Validators.required, Validators.pattern(/^\+84\d{9,10}$/)]),
    });
  }
}
