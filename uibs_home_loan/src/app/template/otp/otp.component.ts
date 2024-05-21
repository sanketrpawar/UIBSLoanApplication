import { Component, OnInit } from '@angular/core';
import { CibilService } from '../../services/cibil.service';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-otp',
  templateUrl: './otp.component.html',
  styleUrl: './otp.component.css'
})
export class OtpComponent implements OnInit{

  constructor(private ref:MatDialogRef<OtpComponent>, private cibilService: CibilService){}
  closepopup(){

      this.ref.close();
  }

  formData:any;
  
  ngOnInit():void {
    let uCibil_score = localStorage.getItem("u_cibil");
    let uCibil_date = localStorage.getItem("u_cibil_date");
    this.formData={
      cibilsc : uCibil_score,
      cibilDate: uCibil_date
    }
    console.log("otp component");
    console.log(uCibil_score);
    console.log(uCibil_date);
  }
  
}

