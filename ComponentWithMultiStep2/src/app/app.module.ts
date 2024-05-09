import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { CustomerDetailsComponent } from './CustomerApplicationForm/customer-details/customer-details.component';
import { AddressDetailsComponent } from './CustomerApplicationForm/address-details/address-details.component';
import { EducationDetailsComponent } from './CustomerApplicationForm/education-details/education-details.component';
import { ProfessionDetailsComponent } from './CustomerApplicationForm/profession-details/profession-details.component';
import { MortgageDetailsComponent } from './CustomerApplicationForm/mortgage-details/mortgage-details.component';
import { CustomerAccountDetailsComponent } from './CustomerApplicationForm/customer-account-details/customer-account-details.component';
import { PreviousLoanDetailsComponent } from './CustomerApplicationForm/previous-loan-details/previous-loan-details.component';
import { PropertyDetailsComponent } from './CustomerApplicationForm/property-details/property-details.component';
import { SanctionLetterDetailsComponent } from './CustomerApplicationForm/sanction-letter-details/sanction-letter-details.component';
import { LedgerDetailsComponent } from './CustomerApplicationForm/ledger-details/ledger-details.component';
import { LoanDisbursementDetailsComponent } from './CustomerApplicationForm/loan-disbursement-details/loan-disbursement-details.component';
import { AllPersonalDocumentsDetailsComponent } from './CustomerApplicationForm/all-personal-documents-details/all-personal-documents-details.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AsyncPipe } from '@angular/common';
import {MatButtonModule} from '@angular/material/button';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatSlideToggleModule} from '@angular/material/slide-toggle';
import {MatStepperModule} from '@angular/material/stepper';
import { AllDocumentsUploadComponent } from './CustomerApplicationForm/all-documents-upload/all-documents-upload.component';

@NgModule({
  declarations: [
    AppComponent,
    CustomerDetailsComponent,
    AddressDetailsComponent,
    EducationDetailsComponent,
    ProfessionDetailsComponent,
    MortgageDetailsComponent,
    CustomerAccountDetailsComponent,
    PreviousLoanDetailsComponent,
    PropertyDetailsComponent,
    SanctionLetterDetailsComponent,
    LedgerDetailsComponent,
    LoanDisbursementDetailsComponent,
    AllPersonalDocumentsDetailsComponent,
    AllDocumentsUploadComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatStepperModule,
    MatButtonModule,
    MatInputModule,
    MatFormFieldModule,
    AsyncPipe,
    MatSlideToggleModule
  ],
  providers: [
    provideAnimationsAsync()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
