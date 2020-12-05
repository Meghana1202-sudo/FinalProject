import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from '../service.service';

@Component({
  selector: 'app-changepassword',
  templateUrl: './changepassword.component.html',
  styleUrls: ['./changepassword.component.css']
})
export class ChangepasswordComponent implements OnInit {

  ngOnInit() {
  }
  constructor(private service:  ServiceService, private route: Router) { }

  password;
  cpassword;
  check;
  cdata;
  passwords(event) {
    this.password = event.target.value;
  }
  cpasswords(event) {
    this.cpassword = event.target.value;
    console.log(this.cpassword);
    if (this.password === this.cpassword) {
      this.check = false;
    } else {
      this.check = true;
    }
  }
  changepassword(form) {
    console.log(form.value);
    this.cdata = null;
    console.log(form.value);
    
    this.service.changePassword(form.value).subscribe(data => {
      console.log(data);
      this.cdata = data.message;
      localStorage.setItem('loginDetails', JSON.stringify(data));
      localStorage.setItem('demo', JSON.stringify(data.studentBeans));
      if (data.message === 'Success') {
        this.route.navigateByUrl('/login');
      }
    }, err => {
      this.cdata = err.message;
    }, () => {
      console.log('success');
    });
  }
}