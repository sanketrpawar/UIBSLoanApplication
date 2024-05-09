import { Component } from '@angular/core';
import { CustomerApplicationService } from '../../services/customer-application.service';
import { HttpClient } from '@angular/common/http';
import { Observable, map } from 'rxjs';
import { StepperOrientation } from '@angular/cdk/stepper';
import { BreakpointObserver } from '@angular/cdk/layout';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-all-personal-documents-details',
  templateUrl: './all-personal-documents-details.component.html',
  styleUrl: './all-personal-documents-details.component.css'
})
export class AllPersonalDocumentsDetailsComponent {

  constructor(private fb: FormBuilder,breakpointObserver: BreakpointObserver, private custApplService: CustomerApplicationService, private activatedRoute: ActivatedRoute) {
    this.stepperOrientation = breakpointObserver.observe('(min-width: 800px)').pipe(map(({matches}) => (matches ? 'horizontal' : 'vertical')));
  }

  
  pancard:any
  onPancard(event:any)
  {
    this.pancard=event.target.files[0]
   
  }

  aadharcard:any
  onAadhar(event:any)
  {
    this.aadharcard=event.target.files[0]
  }

  incomeTaxReturn:any
  onIncomeTax(event:any)
  {
    this.incomeTaxReturn=event.target.files[0]
  }

  photo:any
  onPhoto(event:any)
  {
    this.photo=event.target.files[0]
  }

  signature:any
  onSignature(event:any)
  {
    this.signature=event.target.files[0]
  }

  thumb:any
  onThumb(event:any){
    this.thumb = event.target.files[0]
  }

  bankCheque: any
  onBankCheck(event:any){
    this.bankCheque = event.target.files[0]
  }

  bankStatement:any
  onBankStatement(event: any){
    this.bankStatement = event.target.files[0]
  }

  addressProof:any
  onAddressProof(event:any)
  {
    this.addressProof=event.target.files[0]
  }


  onSubmit(){
      // alert('document')
      let formData:FormData=new FormData();
      
      formData.append("panCard",this.pancard);
      formData.append("aadhar",this.aadharcard);
      formData.append("incomeTaxReturn",this.incomeTaxReturn);
      formData.append("photo",this.photo);
      formData.append("signature",this.signature);
      formData.append("thumb",this.thumb);
      formData.append("bankCheque",this.bankCheque);
      formData.append("bankStatement",this.bankStatement);
      formData.append("addressProof",this.addressProof)
      
      // this.custApplService.saveAllDocuments(formData).subscribe();
      this.custApplService.saveAllDocuments(formData).subscribe();
     
      
  }
  stepperOrientation: Observable<StepperOrientation>;

  
}
