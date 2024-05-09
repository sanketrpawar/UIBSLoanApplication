import { Component } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Observable, map } from 'rxjs';
import { BreakpointObserver } from '@angular/cdk/layout';
import { StepperOrientation } from '@angular/cdk/stepper';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'ComponentWithMultiStep2';

  stepperOrientation: Observable<StepperOrientation>;
  constructor(
    private fb: FormBuilder,breakpointObserver: BreakpointObserver,) {
    this.stepperOrientation = breakpointObserver
      .observe('(min-width: 800px)')
      .pipe(map(({matches}) => (matches ? 'horizontal' : 'vertical')));
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
