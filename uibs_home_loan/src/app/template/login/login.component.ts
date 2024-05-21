import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { EnquiryService } from '../../services/enquiry.service';
import { LoginService } from '../../services/login.service';
import { SuccessMsg } from '../../model/success-msg';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit{

  constructor(private fb:FormBuilder, private loginService:LoginService, private router:Router) { }

  loginForm:FormGroup;

  ngOnInit(): void {
    
    this.loginForm=this.fb.group({
      username:[],
      password:[]
    })
  }

  loginSubmit(){

    let un = this.loginForm.controls['username'].value
    let pwd = this.loginForm.controls['password'].value

    let id:number;
    let username = this.loginForm.controls['username'].value;
    let password = this.loginForm.controls['password'].value;

    if(un === 're' && pwd === 're@123')
      {
          localStorage.setItem("usertype",un)
          this.router.navigateByUrl('/dashboard/re')
      }

    else if(un === 'oe' && pwd === 'oe@123')
      {
        localStorage.setItem("usertype",un)
        this.router.navigateByUrl('/dashboard/oe')
      }

    else if(un === 'cm' && pwd === 'cm@123')
      {
        localStorage.setItem("usertype",un)
        this.router.navigateByUrl('/dashboard/cm')
      }

      else {

    console.log(this.loginForm.value);
    console.log(this.loginForm.controls['username'].value);
    this.loginService.loginUser(username, password).subscribe(
      (data:SuccessMsg)=>
        {
          
        id = data.id
        
        this.router.navigateByUrl('customer/loginUser/'+id);
        console.log(id);
        localStorage.setItem("uid",id.toString())
        }
    );
  }  
}
}