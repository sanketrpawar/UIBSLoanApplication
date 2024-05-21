import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ViewComponent } from './view/view.component';

// import { EmiCalculatorComponent } from '../template/emi-calculator/emi-calculator.component';
// import { HomeComponent } from '../template/home/home.component';
// import { AboutComponent } from '../template/about/about.component';
// import { InquiryComponent } from '../template/inquiry/inquiry.component';
// import { ContactComponent } from '../template/contact/contact.component';
// import { RegistrationComponent } from '../template/registration/registration.component';
// import { LoginComponent } from '../template/login/login.component';
// import { TestimonialsComponent } from '../template/testimonials/testimonials.component';
// import { FaqComponent } from '../template/faq/faq.component';

const routes: Routes = [
  {
    path:'loginuser/:id', component:ViewComponent
  }
  // {
  //   path:'caf', loadChildren:()=>import('../customerapplicationform/customerapplicationform.module').then(file=>file.CustomerapplicationformModule)
  // }
 

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserRoutingModule { }
