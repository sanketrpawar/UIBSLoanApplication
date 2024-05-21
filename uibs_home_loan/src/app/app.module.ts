import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './template/home/home.component';
import { HeaderComponent } from './template/header/header.component';
import { AboutComponent } from './template/about/about.component';
import { ContactComponent } from './template/contact/contact.component';
import { TestimonialsComponent } from './template/testimonials/testimonials.component';
import { InquiryComponent } from './template/inquiry/inquiry.component';
import { EmiCalculatorComponent } from './template/emi-calculator/emi-calculator.component';
import { LoginComponent } from './template/login/login.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RegistrationComponent } from './template/registration/registration.component';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import {MatSliderModule} from '@angular/material/slider';
import { CibilCheckerComponent } from './customer/cibil-checker/cibil-checker.component';
import { MatIconModule } from '@angular/material/icon';
import { MatCardModule } from '@angular/material/card';
import { FaqComponent } from './template/faq/faq.component';
import { UserModule } from './user/user.module';
import { DashboardComponent } from './includes/dashboard/dashboard.component';
import { DashboardHeaderComponent } from './includes/dashboard-header/dashboard-header.component';
import { SidemenuComponent } from './includes/sidemenu/sidemenu.component';
// import { CustomerapplicationformModule } from './customerapplicationform/customerapplicationform.module';
import { CommonModule } from '@angular/common';
import { OtpComponent } from './template/otp/otp.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    AboutComponent,
    ContactComponent,
    TestimonialsComponent,
    InquiryComponent,
    EmiCalculatorComponent,
    LoginComponent,
    RegistrationComponent,
    CibilCheckerComponent,
    FaqComponent,
    DashboardComponent,
    DashboardHeaderComponent,
    SidemenuComponent,
    OtpComponent
  ],
  imports: [
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatSlideToggleModule,
    MatSliderModule,
    MatIconModule,
    MatCardModule,
    UserModule,
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
