import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ServiceService } from '../service.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  error: string;

  constructor(private auth: ServiceService) { }

  Regsiter(form: NgForm) {
    this.error = null;
    this.auth.registerUser(form.value)
      .subscribe(res => {
        console.log(res);
        form.reset();
      }, err => {
        console.log(err);
        this.error = err.error.message;
      });
  }
  ngOnInit() {
  }
  ngOnDestroy() {
    this.error = null;
  }
}
