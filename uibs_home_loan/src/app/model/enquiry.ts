import { CibilScore } from "./cibil-score";

export class Enquiry {

    id:string;
    enquiryName:string;
    age:number;
    email:string;
    mobileNo:number;
    pancardNo:string;
    remark:string;
    submissionDate:Date;
    loanApplied:boolean;
    cibilScore:CibilScore;
}
