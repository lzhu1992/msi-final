import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, FormBuilder} from '@angular/forms';
import { RegisterService} from '../../shared/service/register.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  loginFormGroup: FormGroup;
  err: boolean = false;
  constructor(
    private rs: RegisterService,
    private fb: FormBuilder,
    private router: Router
  ) {
  }

  ngOnInit() {
    this.loginFormGroup = this.fb.group({
      email: '',
      password: ''
    });
  }
  onSubmit() {
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
  onRegister() {
    this.router.navigate(['/register']);
  }

  updateErr() {
    if (!this.err) {
      this.err = true;
    }
  }

}
