import { BreakpointObserver } from '@angular/cdk/layout';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Observable, map } from 'rxjs';
import { CustomerApplicationService } from '../../services/customer-application.service';
import { StepperOrientation } from '@angular/cdk/stepper';

@Component({
  selector: 'app-education-details',
  templateUrl: './education-details.component.html',
  styleUrl: './education-details.component.css'
})
export class EducationDetailsComponent implements OnInit{

  constructor(private fb: FormBuilder,breakpointObserver: BreakpointObserver, private custApplService: CustomerApplicationService) {
    this.stepperOrientation = breakpointObserver.observe('(min-width: 800px)').pipe(map(({matches}) => (matches ? 'horizontal' : 'vertical')));
  }

  educationDetails: FormGroup;

  ngOnInit(): void {
    this.educationDetails = this.fb.group({
      educationalSpecialization:[],
      passingYear:[],
      qualification:[]
    })
  }

  onSubmit(){
    this.custApplService.saveEducationDetails(this.educationDetails.value).subscribe();
    console.log(this.educationDetails.value);
  }

  stepperOrientation: Observable<StepperOrientation>;
 

}
