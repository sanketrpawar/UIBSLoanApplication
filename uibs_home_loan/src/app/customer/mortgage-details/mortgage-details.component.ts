import { BreakpointObserver } from '@angular/cdk/layout';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { CustomerApplicationService } from '../../services/customer-application.service';
import { Observable, map } from 'rxjs';
import { StepperOrientation } from '@angular/cdk/stepper';

@Component({
  selector: 'app-mortgage-details',
  templateUrl: './mortgage-details.component.html',
  styleUrl: './mortgage-details.component.css'
})
export class MortgageDetailsComponent implements OnInit{

  constructor(private fb: FormBuilder,breakpointObserver: BreakpointObserver, private custApplService: CustomerApplicationService) {
    this.stepperOrientation = breakpointObserver.observe('(min-width: 800px)').pipe(map(({matches}) => (matches ? 'horizontal' : 'vertical')));
  }

  mortgage: FormGroup
  ngOnInit(): void {
    this.mortgage = this.fb.group({
      propertyValue:[],
      propertyType:[],
      loanonProperty:[]
    })
  }

  profertyProof: any;
  onPropertyProof(event : any){
    this.profertyProof = event.target.files[0]
  }
  propertyInsurance: any;
  onPropertyInsurance(event: any){
    this.propertyInsurance = event.target.files[0]
  }
  
  onSubmit(){
    var jd= JSON.stringify(this.mortgage.value);
    let formData:FormData=new FormData();

    formData.append("propertyProof",this.profertyProof);
    formData.append("propertyInsurance",this.propertyInsurance);
    formData.append("Mortgagedata",jd);
    this.custApplService.saveMortgageDetails(formData).subscribe();
    console.log(this.mortgage.value);
  }
  stepperOrientation: Observable<StepperOrientation>;
}
