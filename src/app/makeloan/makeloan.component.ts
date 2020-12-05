import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from '../service.service';

@Component({
  selector: 'app-makeloan',
  templateUrl: './makeloan.component.html',
  styleUrls: ['./makeloan.component.css']
})
export class MakeloanComponent implements OnInit {

  Loans= new Array();
  loan;
  constructor( private serivce: ServiceService ,private route: Router) {
    this.display();
  }

  ngOnInit() {
  }
  display() {
    this.serivce.getAllFormStatus().subscribe( data =>{
      console.log(data);
      this.Loans = data
    });
  }


}
