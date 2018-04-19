import { Component, OnInit } from '@angular/core';
import { RegisterService} from '../../shared/service/register.service';
import { Login } from '../../shared/model/login';
import { Dashboard } from '../../shared/model/dashboard';
import {Transaction} from '../../shared/model/transaction';
import {MatTableDataSource} from '@angular/material';
import {environment} from '../../../environments/environment';
@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {
  depositdat: number;
  // private PDF_LINK = `${environment.API_URL}` + '/transaction_pdf';
  name: string;
  displayedColumns = ['tdate', 'recipient', 'amount', 'deposit', 'describe'];
  dataSource: MatTableDataSource<Transaction> = new MatTableDataSource<Transaction>();

  constructor(
    private rs: RegisterService
  ) { }

  ngOnInit() {
    console.log(this.rs.loggedin);
    this.rs.loggedin
      .subscribe(u => {
        this.rs.getDeposit(u)
          .then((dashboard: Dashboard) => {
            this.depositdat = dashboard.amount;
            this.name = dashboard.name;
          });
        this.rs.getTransaction(u)
          .subscribe(res => this.dataSource.data = res);
      });
  }
}
