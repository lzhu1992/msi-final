import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './auth/login/login.component';
import {RegisterComponent} from './auth/register/register.component';
import { AccountComponent } from './account/account.component';
import { TransferComponent} from './account/transfer/transfer.component';
import { DashboardComponent} from './account/dashboard/dashboard.component';
import { LogsuccessComponent} from './account/logsuccess/logsuccess.component';
import { ProfileComponent} from './account/profile/profile.component';
const routes: Routes = [

  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'register',
    component: RegisterComponent

  },
  {
    path: 'transfer',
    component: TransferComponent,

  },
  {
    path: 'account',
    component: AccountComponent,
    children: [
      {
        path: 'dashboard',
        component: DashboardComponent
      },
      {
        path: 'transfer',
        component: TransferComponent
      },
      {
        path: 'success',
        component: LogsuccessComponent
      },
      {
        path: 'profile',
        component: ProfileComponent
      },
    ]
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
