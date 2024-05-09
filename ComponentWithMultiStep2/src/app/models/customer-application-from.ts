import { AllPersonalDocs } from "./all-personal-docs";
import { CustomerAccountDetails } from "./customer-account-details";
import { CustomerAddress } from "./customer-address";
import { CustomerDetails } from "./customer-details";
import { EducationalDetail } from "./educational-detail";
import { Ledger } from "./ledger";
import { LoanDisbursement } from "./loan-disbursement";
import { Mortgage } from "./mortgage";
import { PreviousLoan } from "./previous-loan";
import { Profession } from "./profession";
import { PropertyDetails } from "./property-details";
import { SanctionLetter } from "./sanction-letter";

export class CustomerApplicationFrom {
    
    id: string;
    customerDetails : CustomerDetails;
    customerAddress : CustomerAddress;
    educationDetails : EducationalDetail;
    profession : Profession;
    mortgage : Mortgage;
    customerAccountDetails : CustomerAccountDetails;
    previousLoan : PreviousLoan;
    propertyDetails : PropertyDetails;
    allPersonalDocs : AllPersonalDocs;
    sanctionLetter : SanctionLetter;
    ledger : Ledger;
    loanDisbursement : LoanDisbursement;
}
