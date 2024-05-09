import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CustomerDetails } from '../models/customer-details';
import { CustomerAddress } from '../models/customer-address';
import { EducationalDetail } from '../models/educational-detail';
import { Profession } from '../models/profession';
import { Mortgage } from '../models/mortgage';
import { CustomerAccountDetails } from '../models/customer-account-details';
import { PreviousLoan } from '../models/previous-loan';
import { PropertyDetails } from '../models/property-details';

@Injectable({
  providedIn: 'root'
})
export class CustomerApplicationService {

  constructor(private http:HttpClient) { }

  saveCustomerDetails(custDetails: CustomerDetails){
    return this.http.post('http://localhost:5000/customerDetails', custDetails);
  }

  saveCustomerAddress(addrDetails: CustomerAddress){
    return this.http.post('http://localhost:5000/customerAddress',addrDetails);
  }

  saveEducationDetails(eduDetails: EducationalDetail){
    return this.http.post('http://localhost:5000/customerEducationDetails',eduDetails);
  }

  saveProfessionDetails(formdata: FormData){
    return this.http.post('http://localhost:5000/customerProfession',formdata);
  }

  saveMortgageDetails(formdata: FormData){
    return this.http.post('http://localhost:5000/customerMortgage',formdata);
  }

  saveCustomerAccountDetails(custAccDetails: CustomerAccountDetails){
    return this.http.post('http://localhost:5000/CustomerAccountDetails', custAccDetails);
  }

  savePreviousLoanDetails(prevLoanDetails: PreviousLoan){
    return this.http.post('http://localhost:5000/PreviousLoan',prevLoanDetails)
  }

  savePropertyDetails(propDetails: PropertyDetails){
    return this.http.post('http://localhost:5000/PropertyDetails', propDetails);
  }

  saveAllDocuments(fdata:FormData){
    
    return this.http.post('http://localhost:5000/AllPersonalDocs',fdata);
  }
}
