import { Injectable } from '@angular/core';
import { Register } from '../model/register';
import { Login } from '../model/login';
import { Observable } from 'rxjs/Observable';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators/map';
import {Subject} from 'rxjs/Subject';
import {BehaviorSubject} from 'rxjs/BehaviorSubject';
import { environment } from '../../../environments/environment';

import { Transaction} from '../model/transaction';
import { Transfer} from '../model/transfer';
import 'rxjs/add/operator/map';

@Injectable()
export class RegisterService {

  private REGISTER_API_URL = `${environment.API_URL}`;
  loggedin: Subject<Login> = new BehaviorSubject<Login>(null);

  constructor(
    private http: HttpClient
  ) { }

  login(login: Login): Observable<{success: boolean, user: Login}> {
    return this.http.post<{success: boolean, user: Login}>(`${this.REGISTER_API_URL}/login`, login)
      .pipe(
        map((res: {success: boolean, user: Login}) => {
          if (res && res.success) {
            this.loggedin.next(login);
          }
          return res;
        })
      );
  }
  logout() {
    this.loggedin.next(null);
  }

  register(register: Register): Observable<{success: boolean}> {
    return this.http.post<{success: boolean}>(`${this.REGISTER_API_URL}/register`, register);
  }

  getDeposit(login: Login): Promise<any> {
    return this.http.get<any>(`${this.REGISTER_API_URL}/deposit/` + login.email).toPromise();
  }

  transfer(login: Login, transfer: Transfer ): Observable<{success: boolean}>{
    return this.http.post<{success: boolean}>(`${this.REGISTER_API_URL}/transfer`, {transfer, login});
  }
  getTransaction(login: Login): Observable<Transaction[]> {
    return this.http.get<Transaction[]>(`${this.REGISTER_API_URL}/transaction/` + login.email);
  }

}
