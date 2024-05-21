import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ViewLoansComponent } from '../cm/view-loans/view-loans.component';

const routes: Routes = [
  {
    path:'view_loans', component:ViewLoansComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CmRoutingModule { }
