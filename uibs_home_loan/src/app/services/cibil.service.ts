import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class CibilService {

  constructor(private http:HttpClient) { }

  // saveUser(user:User) {
  //   return this.http.post("http://localhost:3333/uibs/check_cibil", user);
  // }

  otpGenerate(user:User){
    return this.http.post("http://localhost:3331/cibil_otp_generation",user);
  }

  getCibil(id:string, otp:string){
    const params = new HttpParams().set('otp',otp)
    console.log(id);
    console.log(otp);
    return this.http.post("http://localhost:4444/cibil_check/"+id,{params});
  }
}
