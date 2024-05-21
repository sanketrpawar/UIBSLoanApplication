import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { EnquiryService } from '../../services/enquiry.service';

@Component({
  selector: 'app-inquiry',
  templateUrl: './inquiry.component.html',
  styleUrl: './inquiry.component.css'
})
export class InquiryComponent implements OnInit{

  constructor(private fb:FormBuilder, private activateRoute:ActivatedRoute, private enquiryService:EnquiryService){}
  enquiryForm:FormGroup;
  // flag:boolean=false;

  ngOnInit(): void {
    this.enquiryForm=this.fb.group(
      {
        id:[],
        enquiryName:['',[Validators.required, Validators.minLength(3), Validators.maxLength(50)]],
        age:['',[Validators.required, Validators.min(18), Validators.max(100)]],
        email: ['', [Validators.required, Validators.email]],
        mobileNo: ['', [Validators.required, Validators.pattern('^[789][0-9]{9}$')]],
        pancardNo: ['', [Validators.required, Validators.pattern('^[A-Z]{5}[0-9]{4}[A-Z]{1}$')]],
        remark:[],
        submissionDate:[],
        loanApplied:[],
        cibilScore:this.fb.group({
          id:[],
          cibilScore:[],
          cibilScoreDate:[],
          status:[]
        })
      }
    )
  }


onSubmit(){
    
  // if(this.flag){
  //     alert('update product');
  //     this.productService.updateProduct(this.productForm.value).subscribe();
  // }

  // else{
    alert("Product details saved")
  console.log(this.enquiryForm.value)
  this.enquiryService.saveEnquiry(this.enquiryForm.value).subscribe();
  
  // }
}

// getEditInfo(){
//   let id:string
//   this.activeRoute.paramMap.subscribe(
//     map => {
//       id = map.get('data')
//       console.log("Add product component get id: "+id)
//     }
//   )

//   if(id!=null){
//     this.enquiryService.getSingleProduct(id).subscribe(
//       (product:Enquiry)=>this.enquiryForm.patchValue(product)
//     )
//     this.flag=true;
//   }
}
