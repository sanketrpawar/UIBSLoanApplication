import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ViewEnquiryComponent } from './view-enquiry/view-enquiry.component';
import { AddEnquiryComponent } from './add-enquiry/add-enquiry.component';
import { SendMailComponent } from './send-mail/send-mail.component';
import { ViewLoanComponent } from './view-loan/view-loan.component';

const routes: Routes = [
  {
    path:'view_enquiry', component:ViewEnquiryComponent
  },
  {
    path:'add_enquiry', component:AddEnquiryComponent
  },
  {
    path:'view_loans', component:ViewLoanComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ReRoutingModule { }
