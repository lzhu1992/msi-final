import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, FormArray, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import {RegisterService} from '../shared/service/register.service';
import {Register} from '../shared/model/register';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.scss']
})
export class AuthComponent implements OnInit {
  loginFormGroup: FormGroup;
  err: boolean = false;


  constructor(
    private fb: FormBuilder,
    private rs: RegisterService,
    private router: Router

  ) { }

  ngOnInit() {

    this.loginFormGroup = this.fb.group({
      email: '',
      password: ''
    });


  }


  onSubmit() {
    console.log(this.loginFormGroup.value);
    if(this.loginFormGroup.valid) {
      this.rs.login(this.loginFormGroup.value)
        .subscribe(res => {
          if (res.success) {

            this.router.navigate(['/account']);
          } else {
            this.err = true;

          }
        });
    }else {
      return false;
    }
  }


  updateErr() {
    if (!this.err) {
      this.err = true;
    }
  }



}


