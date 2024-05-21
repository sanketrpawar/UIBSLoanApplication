import { BreakpointObserver } from '@angular/cdk/layout';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { CustomerApplicationService } from '../../services/customer-application.service';
import { ActivatedRoute } from '@angular/router';
import { Observable, map } from 'rxjs';
import { StepperOrientation } from '@angular/cdk/stepper';

@Component({
  selector: 'app-previous-loan-details',
  templateUrl: './previous-loan-details.component.html',
  styleUrl: './previous-loan-details.component.css'
})
export class PreviousLoanDetailsComponent implements OnInit{

  constructor(private fb: FormBuilder,breakpointObserver: BreakpointObserver, private custApplService: CustomerApplicationService, private activatedRoute: ActivatedRoute) {
    this.stepperOrientation = breakpointObserver.observe('(min-width: 800px)').pipe(map(({matches}) => (matches ? 'horizontal' : 'vertical')));
  }

  previousLoan:FormGroup;

  ngOnInit(): void {
    this.previousLoan = this.fb.group({
      previousLoanAmount:[],
      paidAmount:[],
      remainingAmount:[],
      defaulterCount:[],
      loanStatus:[],
      remark:[]
    })
  }

  onSubmit(){
    this.custApplService.savePreviousLoanDetails(this.previousLoan.value).subscribe();
    console.log(this.previousLoan.value);
  }
  stepperOrientation: Observable<StepperOrientation>;
}
