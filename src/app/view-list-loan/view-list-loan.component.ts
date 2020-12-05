import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from '../service.service';

@Component({
  selector: 'app-view-list-loan',
  templateUrl: './view-list-loan.component.html',
  styleUrls: ['./view-list-loan.component.css']
})
export class ViewListLoanComponent implements OnInit {

  loanRequest=new Array();
  constructor( private serivce: ServiceService ,private route: Router) {
    this.display();
  }
  ngOnInit() {
  }
  display() {
    this.serivce.getAllType().subscribe( data =>{
      console.log(data);
      this.loanRequest = data
    });
  }


}
