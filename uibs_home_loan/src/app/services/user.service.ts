import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http:HttpClient) { }

  getCustomer(id:string){
    console.log('fghj')
    return this.http.get('http://localhost:2222/uibs/get_login_user/'+id);
  }
}
// http://localhost:2222/uibs/get_login_user/