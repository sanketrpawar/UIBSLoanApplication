import { Component, OnInit } from '@angular/core';
import { AdminService } from '../../../services/admin.service';
import { CustomerAppForm } from '../../../model/customer-app-form';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-loans',
  templateUrl: './view-loans.component.html',
  styleUrl: './view-loans.component.css'
})
export class ViewLoansComponent implements OnInit{

  constructor(private adminService:AdminService, private router:Router){}
  
  loans:CustomerAppForm[];

  ngOnInit(): void {
    
    this.viewLoansFromCRM();
  }

  selectedItems: CustomerAppForm[] = [];

  toggleSelection(id: any) {
    const index = this.selectedItems.indexOf(id);
    if (index === -1) {
      this.selectedItems.push(id);
    } else {
      this.selectedItems.splice(index, 1);
    }
  }

  viewLoansFromCRM(){
    this.adminService.viewLoansFromCRM().subscribe(
      (data:CustomerAppForm[])=>{
        this.loans=data;
      }
    )
  }

  hide:boolean=false;

  viewDetails(id:any){
    
    localStorage.setItem("appId", id);
    // this.router.navigateByUrl("oe/view_single_loan/"+id);
    // window.location.reload();
    // this.hide=true;
  }

  isSelected(id: any): boolean {
    return this.selectedItems.includes(id);
  }

  msg:string;

  loanDetails:CustomerAppForm[];
  // alert=true;

  sendToOE(){
    console.log(this.selectedItems);
    
    if(this.selectedItems.length===0){
    alert('dfsd')
    this.msg="Select the required enquiries."
  }
  // else{
  //   this.adminService.sendLoansToCM(this.selectedItems).subscribe(
  //     (data:CustomerAppForm[])=>{
  //       this.loanDetails=data;
  //       this.msg="Forwarded to OE"
  //     }
      
  //   );

    
  // }
  // }
  }
}
