import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CmRoutingModule } from './cm-routing.module';
import { ViewLoansComponent } from './view-loans/view-loans.component';


@NgModule({
  declarations: [
    ViewLoansComponent
  ],
  imports: [
    CommonModule,
    CmRoutingModule
  ]
})
export class CmModule { }
