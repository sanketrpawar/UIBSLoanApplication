import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable, map } from 'rxjs';
import { BreakpointObserver } from '@angular/cdk/layout';
import { CustomerApplicationService } from '../../services/customer-application.service';
import { StepperOrientation } from '@angular/cdk/stepper';

@Component({
  selector: 'app-address-details',
  templateUrl: './address-details.component.html',
  styleUrl: './address-details.component.css'
})
export class AddressDetailsComponent implements OnInit {
  constructor(private fb: FormBuilder,breakpointObserver: BreakpointObserver, private custApplService: CustomerApplicationService, private activatedRoute: ActivatedRoute) {
    this.stepperOrientation = breakpointObserver.observe('(min-width: 800px)').pipe(map(({matches}) => (matches ? 'horizontal' : 'vertical')));
  }

  customerAddressForm: FormGroup;

  ngOnInit(): void {
    this.customerAddressForm = this.fb.group({
      // id: [],
      areaName: [],
      cityName: [],
      district: [],
      state: [],
      pinCode:[],
      houseNo: [],
      streetName: []
    });
  }

  onSubmit(){
    this.custApplService.saveCustomerAddress(this.customerAddressForm.value).subscribe();
    console.log(this.customerAddressForm.value);
  }
  stepperOrientation: Observable<StepperOrientation>;
}