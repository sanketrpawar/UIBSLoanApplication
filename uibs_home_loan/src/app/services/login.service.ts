import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';
import { Login } from '../model/login';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http:HttpClient) { }

  loginUser(username:string, password:string){
  const params = new HttpParams()
      .set('username', username)
      .set('password', password)

      return this.http.post("http://localhost:2222/uibs/login_customer", {}, {params})
  }
}
