import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material';
import { Register} from '../shared/model/register';
import { RegisterService } from '../shared/service/register.service';
import { Router} from '@angular/router';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.scss']
})
export class AccountComponent implements OnInit {
  constructor(
    private rs: RegisterService,
    private router: Router
  ) {
  }

  ngOnInit() {

  }
  logout() {
    this.rs.logout();
    this.router.navigate(['/login']);

  }
}
