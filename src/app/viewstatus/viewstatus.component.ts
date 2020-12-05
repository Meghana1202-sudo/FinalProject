import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from '../service.service';

@Component({
  selector: 'app-viewstatus',
  templateUrl: './viewstatus.component.html',
  styleUrls: ['./viewstatus.component.css']
})
export class ViewstatusComponent implements OnInit {

  Loans= new Array();
  selectedType;
  loan;
  message;
  search:string;
  requests:any={};
  custRequests:any[]=[];
  msg: string;
  interval: any;
 

  constructor( private serivce: ServiceService ,private route: Router) {
    this.display();
    
    console.log(this.Loans)
  } 
  ngOnInit(): void {
    
  }
  
  decline(reqs){
    console.log(reqs)
      this.serivce.AddCustDecl(reqs).subscribe(data=>{
      console.log(data);
      this.message="loanType Deleted Successfully";
      this.display(); 
    
    });
  }


  display(){
    this.serivce.getAllcust().subscribe(data=>{
      console.log(data);
      this.Loans = data;
      
     })
   }
  acceptReq(applicationId){
    
    this.serivce.AddCustReq(applicationId).subscribe(data=>{
      
      console.log(data);
    
      this.message="Accepted the request";
      this.display();
    });
  }

  SetDate(reqs){
    this.serivce.setdate(reqs).subscribe(data=>{
      console.log(data);
      this.message="Interview date is sheduled";
      
      this.display();
    });
  }
}
