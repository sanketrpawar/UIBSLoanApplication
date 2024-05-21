import { BreakpointObserver } from '@angular/cdk/layout';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { CustomerApplicationService } from '../../services/customer-application.service';
import { StepperOrientation } from '@angular/cdk/stepper';
import { Observable, map } from 'rxjs';

@Component({
  selector: 'app-all-documents-upload',
  templateUrl: './all-documents-upload.component.html',
  styleUrl: './all-documents-upload.component.css'
})
export class AllDocumentsUploadComponent implements OnInit{

  constructor(private fb: FormBuilder, breakporintObserver: BreakpointObserver, private custApplService: CustomerApplicationService, private activatedRoute: ActivatedRoute) {
    this.stepperOrientation = breakporintObserver.observe('(min-width: 800px)').pipe(map(({matches}) => (matches ? 'horizontal' : 'vertical')));
  }

  docUpload: FormGroup;
  ngOnInit(): void {
      this.docUpload = this.fb.group({
        personalData:[]
      })
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
      var jd=JSON.stringify(this.docUpload.value);
      let formData:FormData=new FormData();
      
      formData.append("panCard",this.pancard);
      formData.append("aadhar",this.aadharcard);
      formData.append("incomeTaxReturn",this.incomeTaxReturn);
      formData.append("photo",this.photo);
      formData.append("signature",this.signature);
      formData.append("thumb",this.thumb);
      formData.append("bankCheque",this.bankCheque);
      formData.append("bankStatement",this.bankStatement);
      formData.append("addressProof",this.addressProof);
      formData.append("personalData",jd);
      
      // this.custApplService.saveAllDocuments(formData).subscribe();
      this.custApplService.saveAllDocuments(formData).subscribe();
     
      
  }
  stepperOrientation: Observable<StepperOrientation>;
}
