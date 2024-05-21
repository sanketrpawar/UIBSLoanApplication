import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Customer } from '../model/customer';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  constructor(private http:HttpClient) { }

  registerCustomer(customer:Customer){
    return this.http.post("http://localhost:2222/uibs/register_customer", customer);
  }
}
