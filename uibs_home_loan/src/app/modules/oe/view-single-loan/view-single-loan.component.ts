import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AdminService } from '../../../services/admin.service';
import { CustomerAppForm } from '../../../model/customer-app-form';

@Component({
  selector: 'app-view-single-loan',
  templateUrl: './view-single-loan.component.html',
  styleUrl: './view-single-loan.component.css'
})
export class ViewSingleLoanComponent implements OnInit{

  constructor(private activateroute:ActivatedRoute, private adminService:AdminService, private router:Router)
  {

  }

  appId:any;

  ngOnInit(): void {
    
    // this.getApplicationId();
    this.appId=localStorage.getItem("appId");
    this.getSingleData();
  }


  // app_id:any

  // getApplicationId()
  // {
  //   this.activateroute.paramMap.subscribe(
  //     param=>
  //       {
  //         this.appId=param.get("id")

  //         this.getSingleData();
  //       }
  //   )
  // }

  customerLoanData:CustomerAppForm;
  getSingleData()
  {
    this.adminService.viewDetails(this.appId).subscribe(
        (data:CustomerAppForm)=>{
          this.customerLoanData=data;
        }
        
      )
  }

  previousPage(){
    this.router.navigateByUrl('oe/prev');
  }
}
