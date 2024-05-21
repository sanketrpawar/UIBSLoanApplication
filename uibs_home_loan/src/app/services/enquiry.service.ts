import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Enquiry } from '../model/enquiry';

@Injectable({
  providedIn: 'root'
})
export class EnquiryService {

  constructor(private http:HttpClient) { }

  saveEnquiry(enquiry:Enquiry) {
    return this.http.post("http://localhost:1111/uibs/saveEnquiry", enquiry);
  }
}
