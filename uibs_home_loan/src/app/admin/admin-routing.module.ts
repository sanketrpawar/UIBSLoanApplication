import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ViewEnquiryComponent } from '../modules/re/view-enquiry/view-enquiry.component';
import { AddEnquiryComponent } from '../modules/re/add-enquiry/add-enquiry.component';
import { SendMailComponent } from '../modules/re/send-mail/send-mail.component';

const routes: Routes = [];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
