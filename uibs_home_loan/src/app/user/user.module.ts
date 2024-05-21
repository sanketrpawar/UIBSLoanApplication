import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UserRoutingModule } from './user-routing.module';
import { ViewComponent } from './view/view.component';
import { HttpClientModule } from '@angular/common/http';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';


@NgModule({
  declarations: [
    ViewComponent
  ],
  imports: [
    CommonModule,
    UserRoutingModule,
    HttpClientModule,
    NoopAnimationsModule
  ]
})
export class UserModule { }
