import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ReRoutingModule } from './re-routing.module';
import { ViewEnquiryComponent } from './view-enquiry/view-enquiry.component';
import { AddEnquiryComponent } from './add-enquiry/add-enquiry.component';
import { SendMailComponent } from './send-mail/send-mail.component';
import { ReactiveFormsModule } from '@angular/forms';
import { ViewLoanComponent } from './view-loan/view-loan.component';


@NgModule({
  declarations: [
    ViewEnquiryComponent,
    AddEnquiryComponent,
    SendMailComponent,
    ViewLoanComponent
  ],
  imports: [
    CommonModule,
    ReRoutingModule,
    ReactiveFormsModule
  ]
})
export class ReModule { }
