import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from '../service.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  Loans= new Array();
  selectedType;
  message;
  search:string;
  loan;
  
  constructor( private serivce: ServiceService ,private route: Router) {
    this.display();
  }
  ngOnInit(): void {
    
  }
  
  display() {
    this.serivce.getAllType().subscribe( data =>{
      console.log(data);
      this.Loans = data
    });
  }
  updateLoanType(loan) {
       console.log(loan);
       this.selectedType= loan;
     }
  deleteLoanType(id){
    this.serivce.deleteLoansType(id).subscribe(data=>{
      console.log(data);
      this.message="loanType Deleted Successfully";
      this.display();
    });

  }
  editType(loan) {
    console.log(loan.value);
    this.serivce.updateLoanType(loan.value).subscribe(data => {
      console.log(data);
      this.message = data.message;
      this.route.navigate(['get-alltype']);
    
    }, () =>{
      console.log('success');  
    });
  }
}