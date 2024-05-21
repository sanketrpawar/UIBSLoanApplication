import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ViewEnquiryComponent } from './view-enquiry/view-enquiry.component';
import { AddEnquiryComponent } from './add-enquiry/add-enquiry.component';
import { ViewLoansComponent } from './view-loans/view-loans.component';
import { ViewSingleLoanComponent } from './view-single-loan/view-single-loan.component';


const routes: Routes = [
  {
    path:'view_enquiry', component:ViewEnquiryComponent
  },
  {
    path:'add_enquiry', component:AddEnquiryComponent
  },
  {
    path:'view_loans', component:ViewLoansComponent, children:[
      {
        path:'view_single_loan', component:ViewSingleLoanComponent
          
      }
    ]
  }
  
  
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class OeRoutingModule { }
