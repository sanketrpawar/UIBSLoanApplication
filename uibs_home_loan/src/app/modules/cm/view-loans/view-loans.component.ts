import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AdminService } from '../../../services/admin.service';
import { CustomerAppForm } from '../../../model/customer-app-form';
import jsPDF from 'jspdf';
import { FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-view-loans',
  templateUrl: './view-loans.component.html',
  styleUrl: './view-loans.component.css'
})
export class ViewLoansComponent implements OnInit{

  constructor(private activateroute:ActivatedRoute, private adminService:AdminService, private router:Router, private fb:FormBuilder){}

  customerData:CustomerAppForm;
  appId:any;

  ngOnInit(): void {
    this.getCustomerLoanInfo();

    // this.emiCalculatorForm = this.fb.group(
    //   {
    //     loanAmount: [],
    //     interestRate: [],
    //     loanTenure: []
    //   }
    // )

    // if (this.emiCalculatorForm.controls['loanAmount'].value != null) {
    //   this.calculateEmi();
    // }
  }

  customerLoanData:CustomerAppForm

  getCustomerLoanInfo() {
    // let id = localStorage.getItem("viewdetails")
    // this.adminService.getCustomerLoanData(id).subscribe(
    //   (data: CustomerAppForm) => {
    //     this.customerData = data
    //     this.loanAmountValue = data.customerinfo.totalloanrequired

       
    //   }
    // )
  }

  getSingleData()
  {
    this.adminService.viewDetails(this.appId).subscribe(
        (data:CustomerAppForm)=>{
          this.customerLoanData=data;
        }
        
      )
  }

  sanction:any;

  sanctionedAmount:number
  sanctionedDate:Date

  assignSanctionData(){

  // this.sanctionedAmount = (this.totalAmount - (this.totalAmount * 0.05))
    this.sanctionedDate = new Date()
    // this.cb.detectChanges();
    // this.renderChart(la, this.totalInterest);

    this.sanctionData();
  }

  sanctionData()
  {
    this.sanction = {
      app_id: this.customerData.id,

      applicantName: this.customerData.customerDetails.customerName,
      mobileNo: this.customerData.customerDetails.mobileNo,
      email: this.customerData.customerDetails.email,
      loanAmountSanctioned: this.sanctionedAmount,
      // rateOfInterest: this.interestValue,
      // loanTenure: this.loanTenureValue,
      // monthlyEmiAmount: this.emi
    }
  }

  @ViewChild('content', { static: true }) el!: ElementRef;

  generatePDF() {

    this.adminService.saveSanctionDetails(this.sanction).subscribe();

    let pdf = new jsPDF('p', 'pt', 'a3');

    pdf.html(this.el.nativeElement, {
      callback: (pdf) => {
        // Convert the PDF to a blob

  
        // 
        pdf.save("CustomerLoanApplication.pdf");
      }
    })
  }
}

// export class CmLoanDetailsComponent implements OnInit {

//   constructor(private adminservice: AdminService, private fb: FormBuilder) {

//   }

//   ngOnInit(): void {
//     this.getCustomerLoanInfo();

//     this.emiCalculatorForm = this.fb.group(
//       {
//         loanAmount: [],
//         interestRate: [],
//         loanTenure: []
//       }
//     )

//     if (this.emiCalculatorForm.controls['loanAmount'].value != null) {
//       this.calculateEmi();
//     }
//   }


//   sanction: SanctionLetter

//   customerData: CustomerLoanApplication
//   getCustomerLoanInfo() {
//     let id = localStorage.getItem("viewdetails")
//     this.adminservice.getCustomerLoanData(id).subscribe(
//       (data: CustomerLoanApplication) => {
//         this.customerData = data
//         this.loanAmountValue = data.customerinfo.totalloanrequired

       
//       }
//     )
//   }



//   emiCalculatorForm: FormGroup

//   emi: number
//   totalAmount: number
//   totalInterest: number
//   hide: boolean = true

//   chart: any;

//   loanAmountValue: number;

//   updateLoanAmount() {
//     this.emiCalculatorForm.patchValue({
//       loanAmount: this.loanAmountValue
//     });
//   }

//   interestValue: number = 8;

//   updateInterestRate() {
//     this.emiCalculatorForm.patchValue({
//       interestRate: this.interestValue
//     });
//   }

//   loanTenureValue: number = 12;
//   updateLoanTenure() {
//     this.emiCalculatorForm.patchValue({
//       loanTenure: this.loanTenureValue
//     });
//   }


//   sanctionedAmount: number
//   sanctionedDate: Date

//   calculateEmi() {

//     let la: number = this.emiCalculatorForm.controls['loanAmount'].value
//     let ir: number = this.emiCalculatorForm.controls['interestRate'].value
//     let lt: number = this.emiCalculatorForm.controls['loanTenure'].value

//     // this.emi = (la * ir * Math.pow((1 + ir), lt)) / (Math.pow((1 + ir), lt) - 1);

//     // this.totalAmount = this.emi * lt;

//     // this.totalInterest = this.totalAmount - la;


//     const monthlyInterestRate = ir / 12 / 100;
//     const emiFactor = Math.pow(1 + monthlyInterestRate, lt);
//     this.emi = (la * monthlyInterestRate * emiFactor) / (emiFactor - 1);
//     this.totalAmount = this.emi * lt;
//     this.totalInterest = this.totalAmount - la;
//     this.hide = false


    
//     this.sanctionedAmount = (this.totalAmount - (this.totalAmount * 0.05))
//     this.sanctionedDate = new Date()
//     // this.cb.detectChanges();
//     this.renderChart(la, this.totalInterest);

//     this.sanctionData();
//   }

//   sanctionData()
//   {
//     this.sanction = {
//       app_id: this.customerData.id,

//       applicantName: this.customerData.customerinfo.firstName,
//       mobileNo: this.customerData.customerinfo.mobileNo,
//       email: this.customerData.customerinfo.email,
//       loanAmountSanctioned: this.sanctionedAmount,
//       rateOfInterest: this.interestValue,
//       loanTenure: this.loanTenureValue,
//       monthlyEmiAmount: this.emi
//     }
//   }

//   renderChart(loanAmount: number, interestRate: number) {
//     this.chart = new Chart('canvas', {
//       type: 'pie',
//       data: {
//         labels: ['Loan Amount', 'Interest Rate'],
//         datasets: [
//           {
//             data: [loanAmount, interestRate],
//             backgroundColor: ['orange', '#36A2EB'],
//             hoverBackgroundColor: ['#90EE90', '#36A2EB']
//           }
//         ]
//       },

//     });
//   }

//   @ViewChild('content', { static: true }) el!: ElementRef;

//   generatePDF() {

//     this.adminservice.saveSanctionDetails(this.sanction).subscribe();

//     let pdf = new jsPDF('p', 'pt', 'a3');

//     pdf.html(this.el.nativeElement, {
//       callback: (pdf) => {
//         // Convert the PDF to a blob

  
//         // 
//         pdf.save("CustomerLoanApplication.pdf");
//       }
//     })
//   }
  
// }