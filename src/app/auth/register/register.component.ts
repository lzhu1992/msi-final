import { Component, OnInit , Inject} from '@angular/core';
import { FormGroup, FormBuilder} from '@angular/forms';
import { RegisterService} from '../../shared/service/register.service';
import { Router } from '@angular/router';
// import { MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  registerFormGroup: FormGroup;
  constructor(
    private rs: RegisterService,
    private fb: FormBuilder,
    private router: Router,
    // public dialog: MatDialog
  ) { }

  ngOnInit() {
    this.registerFormGroup = this.fb.group({
      email: '',
      account: '',
      type: '',
      ssn: '',
      password: ''
    });
  }
  onSubmit() {
    console.log(this.registerFormGroup.value);
    if (this.registerFormGroup.valid) {
      this.rs.register(this.registerFormGroup.value)
        .subscribe(res => {
          if (res.success) {
            this.router.navigate(['/login']);
          } else {
            // show error text.
          }
        });
    } else {
      return false;
    }
  }

//   openDialog(): void {
//     let dialogRef = this.dialog.open(DialogOverviewExampleDialog, {
//       width: '250px',
//     });
//
//     dialogRef.afterClosed().subscribe(result => {
//       console.log('The dialog was closed');
//     });
//   }
//
// }
//
// @Component({
//   selector: 'dialog-overview-example-dialog',
//   templateUrl: 'dialog-overview-example-dialog.html'
// })
// export class DialogOverviewExampleDialog {
//
//   constructor(
//     public dialogRef: MatDialogRef<DialogOverviewExampleDialog>,
//     @Inject(MAT_DIALOG_DATA) public data: any) { }
//
//   onNoClick(): void {
//     this.dialogRef.close();
//   }

}
