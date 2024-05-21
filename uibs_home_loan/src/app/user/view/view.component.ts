import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';
import { Customer } from '../../model/customer';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrl: './view.component.css'
})
export class ViewComponent implements OnInit{

  user:Customer;

  constructor(private userService:UserService, private router:Router) { }
  ngOnInit(): void {
    
    this.getUser();
  }

  getUser(){

    let id:string;
    console.log('aaaaaaaa')
    id=localStorage.getItem("uid");
    this.userService.getCustomer(id).subscribe(
      (data:Customer)=>{
        this.user=data;
      }
    );
  }

  navigateToCAF(){
    alert("hh");
    this.router.navigateByUrl("caf/loanApp")
  }
}
