import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from '../service.service';

@Component({
  selector: 'app-viewloans',
  templateUrl: './viewloans.component.html',
  styleUrls: ['./viewloans.component.css']
})
export class ViewloansComponent implements OnInit {

  Loans= new Array();
  selectedType;
  message;
  search:string;
loan;
  // message:string;
  constructor( private serivce: ServiceService ,private route: Router) {
    this.display();
  }
  ngOnInit(): void {
    
  }

  display() {
    this.serivce.getAllcust().subscribe( data =>{
      console.log(data);
      this.Loans = data
    });
  }


}
