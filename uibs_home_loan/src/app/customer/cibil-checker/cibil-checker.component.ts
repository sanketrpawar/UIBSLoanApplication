import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CibilService } from '../../services/cibil.service';
import { MatDialog } from '@angular/material/dialog';
import { User } from '../../model/user';
import { OtpComponent } from '../../template/otp/otp.component';

@Component({
  selector: 'app-cibil-checker',
  templateUrl: './cibil-checker.component.html',
  styleUrl: './cibil-checker.component.css'
})
export class CibilCheckerComponent implements OnInit{

  showInputBox: boolean = false;
  constructor(private fb:FormBuilder, private router:Router, private cibilService: CibilService, private dialog: MatDialog){}
  form:FormGroup;
  

  ngOnInit(): void {
    
    this.form = this.fb.group({
      id:[],
      fullName:['', Validators.required],
      mobileNo:['', Validators.required],
      email:['', Validators.required],
      pancardNo:['', Validators.required],
      employmentType:['', Validators.required],
      otp:[],
      cibilScore:this.fb.group({
        id:[],
        cibilScore:[],
        cibilScoreDate:[],
        status:[]
      })
    });
   
  }

  getOTP(){
    // this.cibilService.saveUser(this.form.value);
    this.cibilService.otpGenerate(this.form.value).subscribe(
      (data:User)=>{
        let u_id=data.id.toString();
        let u_otp= data.otp.toString();
        localStorage.setItem("u_id",u_id);
        localStorage.setItem("u_otp",u_otp);
        console.log(data.id);
        console.log(u_id);
        console.log("otp")
        console.log(u_otp);
      }
    );
    console.log(this.form.value);
    this.showInputBox = !this.showInputBox;
  }

  generateCibil(){

    let u_id=localStorage.getItem("u_id");
    let u_otp = localStorage.getItem("u_otp");
    console.log(u_id);
    console.log(u_otp);

    this.cibilService.getCibil(u_id,u_otp).subscribe(
      (data: User)=>{
        let u_cibil = data.cibilScore.cibilScore.toString();
        let u_cibil_date = data.cibilScore.cibilScoreDate.toString();

        localStorage.setItem("u_cibil",u_cibil);
        localStorage.setItem("u_cibil_date",u_cibil_date);

        // console.log(u_cibil);
        // console.log(u_cibil_date);
        
      }
    );
    
      
      this.dialog.open(OtpComponent);
    
  }

}















// onSubmit(){
    
//   alert("Product details saved")
// console.log(this.userCibilForm.value)
// this.cibilService.saveUser(this.userCibilForm.value).subscribe();
// }