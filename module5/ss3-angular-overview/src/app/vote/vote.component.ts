import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-vote',
  templateUrl: './vote.component.html',
  styleUrls: ['./vote.component.css']
})
export class VoteComponent implements OnInit {
  vote?: number;
  constructor() { }

  ngOnInit(): void {
  }

  vote1(rate: number) {
    this.vote = rate;
  }
}
