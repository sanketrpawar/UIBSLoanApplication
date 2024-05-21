import { Component, OnInit } from '@angular/core';
import { AdminService } from '../../../services/admin.service';
import { CustomerAppForm } from '../../../model/customer-app-form';

@Component({
  selector: 'app-view-loan',
  templateUrl: './view-loan.component.html',
  styleUrl: './view-loan.component.css'
})
export class ViewLoanComponent implements OnInit{

  constructor(private adminService:AdminService){}
  
  loans:CustomerAppForm[];

  ngOnInit(): void {  
    this.viewLoanApps();
  }

  viewLoanApps(){
    this.adminService.getLoanApps().subscribe(
      (data:CustomerAppForm[])=>{
        this.loans=data;
      }
    );
  }

  selectedItems: CustomerAppForm[] = [];
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

  enquiryDetails:CustomerAppForm[];
  // alert=true;

  sendLoanAppToOE(){

    console.log(this.selectedItems);
    
    if(this.selectedItems.length===0){
    alert('dfsd')
    this.msg="Select the required enquiries."
  }
  else{
    this.adminService.sendLoanToOE(this.selectedItems).subscribe(
      (data:CustomerAppForm[])=>{
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
