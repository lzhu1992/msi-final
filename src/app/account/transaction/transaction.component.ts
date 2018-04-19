// import { Component, OnInit } from '@angular/core';
// import {Register} from '../../shared/model/register';
// import {MatTableDataSource} from '@angular/material';
// import {RegisterService} from '../../shared/service/register.service';
// import {Transaction} from '../../shared/model/transaction';
// import {Dashboard} from '../../shared/model/dashboard';
//
//
// @Component({
//   selector: 'app-transaction',
//   templateUrl: './transaction.component.html',
//   styleUrls: ['./transaction.component.scss']
// })
// export class TransactionComponent implements OnInit {
//
//   displayedColumns = ['tdate', 'recipient', 'amount', 'deposit', 'describe'];
//   dataSource: MatTableDataSource<Transaction> = new MatTableDataSource<Transaction>();
//
//
//   constructor(private rs: RegisterService) {
//   }
//
//   ngOnInit() {
//     this.rs.loggedin
//       .subscribe(u => {
//         this.rs.getTransaction(u)
//           .subscribe(res => this.dataSource.data = res);
//       });
//   }
// }
//
