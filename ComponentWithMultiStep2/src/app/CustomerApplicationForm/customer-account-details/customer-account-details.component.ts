import { BreakpointObserver } from '@angular/cdk/layout';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { CustomerApplicationService } from '../../services/customer-application.service';
import { ActivatedRoute } from '@angular/router';
import { Observable, map } from 'rxjs';
import { StepperOrientation } from '@angular/cdk/stepper';

@Component({
  selector: 'app-customer-account-details',
  templateUrl: './customer-account-details.component.html',
  styleUrl: './customer-account-details.component.css'
})
export class CustomerAccountDetailsComponent implements OnInit{

  constructor(private fb: FormBuilder,breakpointObserver: BreakpointObserver, private custApplService: CustomerApplicationService, private activatedRoute: ActivatedRoute) {
    this.stepperOrientation = breakpointObserver.observe('(min-width: 800px)').pipe(map(({matches}) => (matches ? 'horizontal' : 'vertical')));
  }

  customerAccountDetails: FormGroup;
  ngOnInit(): void {
    this.customerAccountDetails = this.fb.group({
      accounType:[],
      accountHolderName:[],
      accountStatus:[],
      accountNo:[]
    })
  }

onSubmit(){
    this.custApplService.saveCustomerAccountDetails(this.customerAccountDetails.value).subscribe();
    console.log(this.customerAccountDetails.value);
  }
  stepperOrientation: Observable<StepperOrientation>;
}
