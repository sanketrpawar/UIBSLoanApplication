import { BreakpointObserver } from '@angular/cdk/layout';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CustomerApplicationService } from '../../services/customer-application.service';
import { Observable, map } from 'rxjs';
import { StepperOrientation } from '@angular/cdk/stepper';

@Component({
  selector: 'app-customer-details',
  templateUrl: './customer-details.component.html',
  styleUrl: './customer-details.component.css'
})
export class CustomerDetailsComponent implements OnInit{

  constructor(private fb: FormBuilder,breakpointObserver: BreakpointObserver, private custApplService: CustomerApplicationService) {
    this.stepperOrientation = breakpointObserver.observe('(min-width: 800px)').pipe(map(({matches}) => (matches ? 'horizontal' : 'vertical')));
  }

  customerDetails: FormGroup;

  ngOnInit(): void {
      this.customerDetails = this.fb.group({
        customerName:[], 
        mobileNo:[],
        emailID : [],
        adharNo : [],
        pancardNo : [],
        gender: [],
        customerDOB :[], 
        customerAge :[],
        loanType:[],
        maritalStatus:[],
        statusCode :[],
        totalLoanRequired : [],
        cibilScore :[]
      })
  }

  onSubmit(){
    this.custApplService.saveCustomerDetails(this.customerDetails.value).subscribe();
    console.log(this.customerDetails.value);
  }
  stepperOrientation: Observable<StepperOrientation>;
}
