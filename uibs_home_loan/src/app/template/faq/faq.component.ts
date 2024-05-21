// faq.component.ts
import { Component, OnInit } from '@angular/core';

interface FAQ {
    question: string;
    answer: string;
}

@Component({
    selector: 'app-faq',
    templateUrl: './faq.component.html',
    styleUrls: ['./faq.component.css']
})
export class FaqComponent implements OnInit {
    faqs: FAQ[] = [
        {
            question: 'What are the eligibility criteria for a home loan?',
            answer: 'Eligibility criteria usually include factors such as age, income, credit score, employment status, and property value.'
        },
        {
            question: 'How much home loan can I get?',
            answer: 'The amount of home loan you can get depends on your income, existing debts, credit score, and the value of the property you intend to buy.'
        },
        {
            question: 'What documents are required to apply for a home loan?',
            answer: 'Common documents required include proof of identity, address, income, property documents, and bank statements.'
        },
        {
            question: 'What are the different types of home loans available?',
            answer: 'Some common types of home loans include fixed-rate loans, adjustable-rate loans, FHA loans, VA loans, and jumbo loans.'
        },
        {
            question: 'Can I prepay or foreclose my home loan?',
            answer: 'Yes, most home loans allow prepayment or foreclosure. However, there may be certain conditions and charges associated with it, so it\'s essential to check with your lender.'
        },
        {
            question: 'What is the tenure for repaying a home loan?',
            answer: 'Home loan tenures typically range from 5 to 30 years, depending on the lender and your preference. Longer tenures may result in lower EMI but higher overall interest payments.'
        },
        {
            question: 'Can I transfer my existing home loan to another lender?',
            answer: 'Yes, you can transfer your existing home loan to another lender through a process called loan transfer or refinancing. This can help you get better interest rates or terms.'
        },
        
    ];

    constructor() { }

    ngOnInit(): void {
    }
}
