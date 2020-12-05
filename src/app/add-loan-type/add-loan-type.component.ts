import { Component, OnInit } from '@angular/core';
import { ServiceService } from '../service.service';

@Component({
  selector: 'app-add-loan-type',
  templateUrl: './add-loan-type.component.html',
  styleUrls: ['./add-loan-type.component.css']
})
export class AddLoanTypeComponent implements OnInit {

  message;
  constructor(private service: ServiceService ) { }
  ngOnInit() {
  }
  addLoans(type) {
    this.message=null;
    console.log(type.value);
    this.service.addLoanType(type.value).subscribe( data =>{
      console.log(data);
      this.message = data.message;
      type.reset();
    }, err => {
      console.log('error');
    }, () => {
      console.log('success');
    })
  }
}
