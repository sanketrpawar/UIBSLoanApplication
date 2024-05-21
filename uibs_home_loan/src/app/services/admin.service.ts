import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Enquiry } from '../model/enquiry';
import { CustomerAppForm } from '../model/customer-app-form';
import { SanctionLetter } from '../model/sanction-letter';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  
  

  constructor(private http :HttpClient) { }

  viewEnquiries(){
    return this.http.get('http://localhost:3333/getEnquiries');
  }

  sendEnquiriesToOE(enquiry:Enquiry[]) {
    return this.http.post('http://localhost:3333/sendToOE', enquiry);
  }

  getFromCRM(){
    return this.http.get('http://localhost:4444/getEnquiriesFromCRM');
  }

  getLoanApps(){
    return this.http.get('http://localhost:3333/getLoanApp');
  }

  sendLoanToOE(loan:CustomerAppForm[]){
    return this.http.post('http://localhost:3333/saveLoansFromCRM', loan);
  }

  viewLoansFromCRM() {
    return this.http.get('http://localhost:4444/getLoansFromCRM')
  }

  viewDetails(id:number){
    return this.http.get('http://localhost:4444/viewDetails/'+id);
  }

  saveSanctionDetails(sanction:SanctionLetter){
    return this.http.post('http://localhost:7777/uibs/postSanctionLetter',sanction);
  }

  getCustomerLoanData(id:any){
    return this.http.get('http://localhost:7777/uibs/getLoanDetailsFromOE/'+id);
  }

  sendLoansToCM(loans: CustomerAppForm[]) {
    // return this.http.post('');
  }
}
