import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { OeRoutingModule } from './oe-routing.module';
import { AddEnquiryComponent } from './add-enquiry/add-enquiry.component';
import { ViewEnquiryComponent } from './view-enquiry/view-enquiry.component';
import { ReactiveFormsModule } from '@angular/forms';
import { ViewLoansComponent } from './view-loans/view-loans.component';
import { ViewSingleLoanComponent } from './view-single-loan/view-single-loan.component';


@NgModule({
  declarations: [
    AddEnquiryComponent,
    ViewEnquiryComponent,
    ViewLoansComponent,
    ViewSingleLoanComponent
  ],
  imports: [
    CommonModule,
    OeRoutingModule,
    ReactiveFormsModule
  ]
})
export class OeModule { }
