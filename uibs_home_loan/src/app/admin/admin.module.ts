import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminRoutingModule } from './admin-routing.module';
import { OeComponent } from './oe/oe.component';
import { ReComponent } from './re/re.component';
import { CmComponent } from './cm/cm.component';
import { AhComponent } from './ah/ah.component';


@NgModule({
  declarations: [
    OeComponent,
    ReComponent,
    CmComponent,
    AhComponent
  ],
  imports: [
    CommonModule,
    AdminRoutingModule
  ]
})
export class AdminModule { }
