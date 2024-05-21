import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CustomerViewPageComponent } from './customer-view-page/customer-view-page.component';
import { CustomerloanapplicationComponent } from './customerloanapplication/customerloanapplication.component';
import { CibilCheckerComponent } from './cibil-checker/cibil-checker.component';

const routes: Routes = [
  
  {
    path:'loginUser/:id', component:CustomerViewPageComponent, children:[
      {
        path:'caf', component:CustomerloanapplicationComponent
      },
      {
        path:'checkCibil', component:CibilCheckerComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CustomerRoutingModule { }
