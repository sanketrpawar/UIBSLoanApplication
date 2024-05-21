import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './template/home/home.component';
import { AboutComponent } from './template/about/about.component';
import { ContactComponent } from './template/contact/contact.component';
import { InquiryComponent } from './template/inquiry/inquiry.component';
import { EmiCalculatorComponent } from './template/emi-calculator/emi-calculator.component';
import { TestimonialsComponent } from './template/testimonials/testimonials.component';
import { LoginComponent } from './template/login/login.component';
import { RegistrationComponent } from './template/registration/registration.component';
import { FaqComponent } from './template/faq/faq.component';
import { DashboardComponent } from './includes/dashboard/dashboard.component';


const routes: Routes = [
  {
    path:'', redirectTo:'home',pathMatch:'full'
  },
  {
    path:'home', component:HomeComponent, children:[
      {
        path:'about', component:AboutComponent, pathMatch:'full'
      },
      {
        path:'contact', component:ContactComponent
      },
      {
        path:'inquiry', component:InquiryComponent
      },
      {
        path:'emiCalc', component:EmiCalculatorComponent
      },
      {
        path:'testimonials', component:TestimonialsComponent
      },
      {
        path:'login', component:LoginComponent
      },
      {
        path:'registration', component:RegistrationComponent
      },
      {
        path:'faq', component:FaqComponent
      }
    ]
  },
  {
    path:'customer', loadChildren:()=>import("./customer/customer.module").then(file=>file.CustomerModule)
  },
  
  {
    path:'dashboard', component:DashboardComponent, children:[
      {
        path:'re', loadChildren:()=>import('./modules/re/re.module').then(path=>path.ReModule)
      },
      {
        path:'oe', loadChildren:()=>import('./modules/oe/oe.module').then(path=>path.OeModule)
      },
      {
        path:'cm', loadChildren:()=>import('./modules/cm/cm.module').then(path=>path.CmModule)
      }
    ]
    
  },
  {
    path:'oe', loadChildren:()=>import('./modules/oe/oe.module').then(path=>path.OeModule)
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
