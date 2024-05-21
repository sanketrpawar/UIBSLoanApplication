import { Component, OnInit } from '@angular/core';
import { AdminService } from '../../../services/admin.service';
import { Enquiry } from '../../../model/enquiry';

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
    this.adminService.getFromCRM().subscribe(
      (data:Enquiry[])=>{
        this.enquiry=data;
      }
    );
  }

  // viewDetails(){
  //   this.adminService.
  // }
}
