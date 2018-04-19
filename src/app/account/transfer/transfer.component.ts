import { Component, OnInit } from '@angular/core';
import {FormGroup, FormBuilder} from '@angular/forms';
import {RegisterService} from '../../shared/service/register.service';
import {MatDialog} from '@angular/material';
import {Router} from '@angular/router';
import {Dashboard} from '../../shared/model/dashboard';
import { Login} from '../../shared/model/login';

@Component({
  selector: 'app-transfer',
  templateUrl: './transfer.component.html',
  styleUrls: ['./transfer.component.scss']
})
export class TransferComponent implements OnInit {



  TransactionFormGroup: FormGroup;

  constructor(
    private rs: RegisterService,
    private fb: FormBuilder,
    private router: Router,

  ) { }

  onSubmit() {

    this.rs.loggedin
      .subscribe(u => {
        if (this.TransactionFormGroup.valid) {
          this.rs.transfer( u, this.TransactionFormGroup.value)
            .subscribe(res => {
              if (res.success) {
                this.router.navigate(['/account/success']);
              } else {
                 // this.openDialog();
                return false;
              }
            });
        } else {
          return false;
        }
      });
  }

  ngOnInit() {
    this.TransactionFormGroup = this.fb.group({
      recipient: '',
      amount: ''

    });
  }

}
