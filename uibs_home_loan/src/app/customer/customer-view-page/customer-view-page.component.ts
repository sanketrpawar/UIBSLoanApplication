import { Component, OnInit } from '@angular/core';
import { Customer } from '../../model/customer';
import { UserService } from '../../services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-customer-view-page',
  templateUrl: './customer-view-page.component.html',
  styleUrl: './customer-view-page.component.css'
})
export class CustomerViewPageComponent implements OnInit{

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

}
