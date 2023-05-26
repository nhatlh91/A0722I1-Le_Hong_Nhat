import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-count-down',
  templateUrl: './count-down.component.html',
  styleUrls: ['./count-down.component.css']
})
export class CountDownComponent implements OnInit {
  timer = 10;
  interval;
  message?;

  constructor() {
  }

  ngOnInit(): void {
  }

  start() {
    this.interval = setInterval(() => {
      this.timer--;
      if (this.timer === 0) {
        clearInterval(this.interval);
        this.message = 'Đếm ngược hoàn tất';
      }
    }, 1000);
  }

  pause() {
    clearInterval(this.interval);
  }

  reset() {
    this.message = '';
    this.timer = 10;
  }
}
