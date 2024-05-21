import { NgModule } from '@angular/core';
import { AsyncPipe, CommonModule } from '@angular/common';

import { CustomerRoutingModule } from './customer-routing.module';
import { ReactiveFormsModule } from '@angular/forms';
import { AddressDetailsComponent } from './address-details/address-details.component';
import { AllDocumentsUploadComponent } from './all-documents-upload/all-documents-upload.component';
import { CustomerAccountDetailsComponent } from './customer-account-details/customer-account-details.component';
import { CustomerDetailsComponent } from './customer-details/customer-details.component';
import { EducationDetailsComponent } from './education-details/education-details.component';
import { MortgageDetailsComponent } from './mortgage-details/mortgage-details.component';
import { PreviousLoanDetailsComponent } from './previous-loan-details/previous-loan-details.component';
import { ProfessionDetailsComponent } from './profession-details/profession-details.component';
import { PropertyDetailsComponent } from './property-details/property-details.component';
import { CustomerloanapplicationComponent } from './customerloanapplication/customerloanapplication.component';
import { HttpClientModule } from '@angular/common/http';
import { MatStepperModule } from '@angular/material/stepper';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatIconModule } from '@angular/material/icon';
import { MatCardModule } from '@angular/material/card';
import { MatSliderModule } from '@angular/material/slider';
import { CustomerViewPageComponent } from './customer-view-page/customer-view-page.component';


@NgModule({
  declarations: [
    AddressDetailsComponent,
    AllDocumentsUploadComponent,
    CustomerAccountDetailsComponent,
    CustomerDetailsComponent,
    EducationDetailsComponent,
    MortgageDetailsComponent,
    PreviousLoanDetailsComponent,
    ProfessionDetailsComponent,
    PropertyDetailsComponent,
    CustomerloanapplicationComponent,
    CustomerViewPageComponent
  ],
  imports: [
    ReactiveFormsModule,
    HttpClientModule,
    MatStepperModule,
    MatButtonModule,
    MatInputModule,
    MatFormFieldModule,
    AsyncPipe,
    MatSlideToggleModule,
    MatIconModule,
    MatCardModule,
    MatSliderModule,
    CustomerRoutingModule
  ]
})
export class CustomerModule { }
