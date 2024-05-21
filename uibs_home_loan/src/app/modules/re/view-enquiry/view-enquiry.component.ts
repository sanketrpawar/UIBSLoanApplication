import { Component, OnInit } from '@angular/core';
import { AdminService } from '../../../services/admin.service';
import { Enquiry } from '../../../model/enquiry';
import { SuccessMsg } from '../../../model/success-msg';

@Component({
  selector: 'app-view-enquiry',
  templateUrl: './view-enquiry.component.html',
  styleUrl: './view-enquiry.component.css'
})
export class ViewEnquiryComponent implements OnInit{

  constructor(private adminService:AdminService){}

  enquiry:Enquiry[];

  ngOnInit(): void {
    this.getEnquiries();
  }

  getEnquiries(){
    this.adminService.viewEnquiries().subscribe(
      (data:Enquiry[])=>{
        this.enquiry=data;
      }
    );
  }

  selectedItems: Enquiry[] = [];
  // alert:boolean=true

toggleSelection(id: any) {
  const index = this.selectedItems.indexOf(id);
  if (index === -1) {
    this.selectedItems.push(id);
  } else {
    this.selectedItems.splice(index, 1);
  }
}

  msg:string;

  enquiryDetails:Enquiry[];
  // alert=true;

  sendToOE(){
    console.log(this.selectedItems);
    
    if(this.selectedItems.length===0){
    alert('dfsd')
    this.msg="Select the required enquiries."
  }
  else{
    this.adminService.sendEnquiriesToOE(this.selectedItems).subscribe(
      (data:Enquiry[])=>{
        this.enquiryDetails=data;
        this.msg="Forwarded to OE"
      }
      
    );

    
  }
  }

  
isSelected(id: any): boolean {
  return this.selectedItems.includes(id);
}
}
