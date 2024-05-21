import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CustomerDetails } from '../model/customerdetails';
import { CustomerAddress } from '../model/customer-address';
import { EducationDetails } from '../model/education-details';
import { PreviousLoan } from '../model/previous-loan';
import { PropertyDetails } from '../model/property-details';

@Injectable({
  providedIn: 'root'
})
export class CustomerApplicationService {

  constructor(private http:HttpClient) { }

  saveCustomerDetails(custDetails: CustomerDetails){
    return this.http.post('http://localhost:5000/uibs/customerDetails', custDetails);
  }

  saveCustomerAddress(addrDetails: CustomerAddress){
    return this.http.post('http://localhost:5000/uibs/customerAddress',addrDetails);
  }

  saveAllDocuments(fdata:FormData){
    return this.http.post('http://localhost:5000/uibs/AllPersonalDocs',fdata);
  }

  saveCustomerAccountDetails(custAccDetails: CustomerDetails){
    return this.http.post('http://localhost:5000/uibs/CustomerAccountDetails', custAccDetails);
  }

  saveEducationDetails(eduDetails: EducationDetails){
    return this.http.post('http://localhost:5000/uibs/customerEducationDetails',eduDetails);
  }

  saveMortgageDetails(formdata: FormData){
    return this.http.post('http://localhost:5000/uibs/customerMortgage',formdata);
  }

  savePreviousLoanDetails(previousLoanDetails: PreviousLoan){
    return this.http.post('http://localhost:5000/uibs/PreviousLoan', previousLoanDetails)
  }

  savePropertyDetails(propDetails: PropertyDetails){
    return this.http.post('http://localhost:5000/uibs/PropertyDetails', propDetails);
  }

  saveProfessionDetails(formdata: FormData){
    return this.http.post('http://localhost:5000/uibs/customerProfession',formdata);
  }

}
