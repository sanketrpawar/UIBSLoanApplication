import { BreakpointObserver } from '@angular/cdk/layout';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { CustomerApplicationService } from '../../services/customer-application.service';
import { Observable, map } from 'rxjs';
import { StepperOrientation } from '@angular/cdk/stepper';

@Component({
  selector: 'app-property-details',
  templateUrl: './property-details.component.html',
  styleUrl: './property-details.component.css'
})
export class PropertyDetailsComponent implements OnInit{

  constructor(private fb: FormBuilder,breakpointObserver: BreakpointObserver, private custApplService: CustomerApplicationService, private activatedRoute: ActivatedRoute) {
    this.stepperOrientation = breakpointObserver.observe('(min-width: 800px)').pipe(map(({matches}) => (matches ? 'horizontal' : 'vertical')));
  }

  propertyDetails: FormGroup;
  ngOnInit(): void {
      this.propertyDetails = this.fb.group({
        propertyType: [],
        propertyArea:[],
        constructionArea:[],
        propertyPrice:[],
        constructionPrice:[],
        propertyAddress:[]
      })
  }

  onSubmit(){
    this.custApplService.savePropertyDetails(this.propertyDetails.value).subscribe();
    console.log(this.propertyDetails.value);
  }

  stepperOrientation: Observable<StepperOrientation>;
}
