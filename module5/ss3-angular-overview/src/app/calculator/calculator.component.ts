import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {
  result: any = undefined;

  constructor() {
  }

  ngOnInit(): void {
  }

  sum(firstNumber: string, secondNumber: string) {
    this.result = +firstNumber + +secondNumber;
  }

  sub(firstNumber: string, secondNumber: string) {
    this.result = +firstNumber - +secondNumber;
  }

  mul(firstNumber: string, secondNumber: string) {
    this.result = +firstNumber * +secondNumber;
  }

  div(firstNumber: string, secondNumber: string) {
    if (+secondNumber !== 0) {
      this.result = +firstNumber / +secondNumber;
    } else {
      this.result = 'Không thể chia cho số 0';
    }
  }
}
