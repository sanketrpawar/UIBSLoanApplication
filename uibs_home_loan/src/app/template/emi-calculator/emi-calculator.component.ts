import { Component, SimpleChanges } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

import {Chart,  registerables} from 'chart.js';

Chart.register(...registerables );

@Component({
  selector: 'app-emi-calculator',
  templateUrl: './emi-calculator.component.html',
  styleUrl: './emi-calculator.component.css'
})
export class EmiCalculatorComponent {

  emiForm: FormGroup;
  emi: number;
  emiCalculated: boolean = false;
  public chart: any;

  emiChartData: any[] = [
    { data: [], label: 'EMI' }
  ];

emiChartLabels: any[] = ['Principal', 'Interest'];
loanAmount: number;
totalInterest: number;

// @ViewChild('piechart') piechart: ElementRef;
// chartInstance: Chart<'pie', [any, any][], any>;

  constructor(private fb: FormBuilder) { }

  ngOnInit(): void {
    this.emiForm = this.fb.group({
      loanAmount: [100000],
      interestRate: [8],
      loanTenure: [5]
    }); 
    
    this.calculateEMI();
      
  }

  ngOnChanges(changes: SimpleChanges): void {
    console.log('ngOnChanges triggered:', changes);
    if (changes['loanAmount'] || changes['interestRate'] || changes['loanTenure']) {
      console.log('Calculating EMI and updating pie chart...');
      
      this.calculateEMI();
      // this.updatePieChart(this.loanAmount,this.totalInterest);
      // this.renderPieChart(this.loanAmount,this.totalInterest);
    }
  }
  calculateEMI(): void {
  
    this.loanAmount = this.emiForm.get('loanAmount').value;
    const interestRate = this.emiForm.get('interestRate').value / (12*100); // Monthly interest rate
    const loanTenure = this.emiForm.get('loanTenure').value * 12; // Total number of months

    this.emi = this.loanAmount * interestRate * Math.pow(1 + interestRate, loanTenure) / (Math.pow(1 + interestRate, loanTenure) - 1);

    const totalPayment = this.emi * loanTenure;
    let interest = totalPayment - this.loanAmount;  
    this.totalInterest=interest;  
     this.emiCalculated = true;
     this.renderPieChart(this.loanAmount,this.totalInterest);
     
  
  }


  
  renderPieChart(loanAmount,totalInterest){
    
     const myChart = new Chart("piechart", {
      type: 'pie',
      data: {
          labels: this.emiChartLabels,
          datasets: [{
              label: 'EMI PIE CHART',
              data: [loanAmount,totalInterest],
              backgroundColor: [
                  'rgba(255, 99, 132, 0.2)',
                  'rgba(5, 118, 27, 0.61)',
                  'rgba(255, 206, 86, 0.2)',
                  'rgba(75, 192, 192, 0.2)',
                  'rgba(153, 102, 255, 0.2)',
                  'rgba(255, 159, 64, 0.2)'
              ],
              borderColor: [
                  'rgba(255, 99, 132, 1)',
                  'rgba(54, 162, 235, 1)',
                  'rgba(255, 206, 86, 1)',
                  'rgba(75, 192, 192, 1)',
                  'rgba(153, 102, 255, 1)',
                  'rgba(255, 159, 64, 1)'
              ],
              borderWidth: 2,

            }]
          }      
  });

  // Update the chart every 2 seconds
  setInterval(() => {
    myChart.update();
  }, 2000);
}
}
