import { BreakpointObserver } from '@angular/cdk/layout';
import { StepperOrientation } from '@angular/cdk/stepper';
import { Component } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Observable, map } from 'rxjs';

@Component({
  selector: 'app-customerloanapplication',
  templateUrl: './customerloanapplication.component.html',
  styleUrl: './customerloanapplication.component.css'
})
export class CustomerloanapplicationComponent {

  stepperOrientation: Observable<StepperOrientation>;
  constructor(
    private fb: FormBuilder,breakpointObserver: BreakpointObserver,) {
    this.stepperOrientation = breakpointObserver
      .observe('(min-width: 3000px)')
      .pipe(map(({matches}) => (matches ? 'vertical' : 'horizontal')));
  }

  firstFormGroup = this.fb.group({
   
  });
  secondFormGroup = this.fb.group({
   
  });
  thirdFormGroup = this.fb.group({
   
  });
  forthFormGroup = this.fb.group({

  });
  fifthFormGroup = this.fb.group({

  });
  sixthFormGroup = this.fb.group({

  })
  seventhFormGroup = this.fb.group({

  });
  eightFormGroup = this.fb.group({

  });
  ninthFormGroup = this.fb.group({
    
  });
  tenthFormGroup = this.fb.group({
    
  })
}
