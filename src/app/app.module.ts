import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {MatCardModule, MatFormFieldModule, MatDividerModule, MatButtonModule, MatInputModule,
  MatTableModule, MatDialogModule, MatTabsModule, MatIconModule} from '@angular/material';
import { AppRoutingModule } from './app-routing.module';
import { ServiceWorkerModule } from '@angular/service-worker';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule} from '@angular/forms';
import { environment } from '../environments/environment';
import { FooterComponent } from './common/footer/footer.component';
import { HeaderComponent } from './common/header/header.component';
import { HomeComponent } from './home/home.component';
import { AuthComponent } from './auth/auth.component';
import { LoginComponent } from './auth/login/login.component';
import { RegisterComponent } from './auth/register/register.component';
import { SharedComponent } from './shared/shared.component';
import { AccountComponent } from './account/account.component';
import { RegisterService} from './shared/service/register.service';
import { HttpClientModule } from '@angular/common/http';
import { TransferComponent } from './account/transfer/transfer.component';
import { LogoutComponent } from './account/logout/logout.component';
import { LogsuccessComponent } from './account/logsuccess/logsuccess.component';
import { DashboardComponent } from './account/dashboard/dashboard.component';
// import { TransactionComponent } from './account/transaction/transaction.component';
import {MatButtonToggleModule} from '@angular/material/button-toggle';
import { ProfileComponent } from './account/profile/profile.component';
@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    HeaderComponent,
    HomeComponent,
    AuthComponent,
    LoginComponent,
    RegisterComponent,
    SharedComponent,
    AccountComponent,
    TransferComponent,
    LogoutComponent,
    LogsuccessComponent,
    DashboardComponent,
    ProfileComponent,
    // TransactionComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatCardModule,
    MatTableModule,
    MatFormFieldModule,
    MatDividerModule,
    MatButtonModule,
    MatInputModule,
    MatDialogModule,
    MatTabsModule,
    MatIconModule,
    MatButtonToggleModule,
    ServiceWorkerModule.register('/ngsw-worker.js', { enabled: environment.production })
  ],
  providers: [RegisterService],
  bootstrap: [AppComponent]
})
export class AppModule { }
