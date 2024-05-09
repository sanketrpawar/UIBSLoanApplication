import { BreakpointObserver } from '@angular/cdk/layout';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { CustomerApplicationService } from '../../services/customer-application.service';
import { ActivatedRoute } from '@angular/router';
import { Observable, map } from 'rxjs';
import { StepperOrientation } from '@angular/cdk/stepper';

@Component({
  selector: 'app-profession-details',
  templateUrl: './profession-details.component.html',
  styleUrl: './profession-details.component.css'
})
export class ProfessionDetailsComponent implements OnInit{

  constructor(private fb: FormBuilder,breakpointObserver: BreakpointObserver, private custApplService: CustomerApplicationService, private activatedRoute: ActivatedRoute) {
    this.stepperOrientation = breakpointObserver.observe('(min-width: 800px)').pipe(map(({matches}) => (matches ? 'horizontal' : 'vertical')));
  }

  profession: FormGroup;
  ngOnInit(): void {
    this.profession= this.fb.group({
      professionType:[],
      professionSalary:[],
      professionSalaryType:[],
      professionWorkingPeriod:[],
      professionDesignation:[]
    })
  }

  professionsalartSlips: any;
  onSalary(event: any){
    this.professionsalartSlips=event.target.files[0]
  }
  onSubmit(){

    var jd= JSON.stringify(this.profession.value);
    let formData:FormData=new FormData();

    formData.append("professionsalarySlips",this.professionsalartSlips);
    formData.append("Professiondata",jd);

    this.custApplService.saveProfessionDetails(formData).subscribe();
    console.log(this.profession.value);
  }
  stepperOrientation: Observable<StepperOrientation>;
}
