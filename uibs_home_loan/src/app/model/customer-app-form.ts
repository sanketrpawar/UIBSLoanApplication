import { AllPersonalDocs } from "./all-personal-docs";
import { CustomerAccountDetails } from "./customer-account-details";
import { CustomerAddress } from "./customer-address";
import { CustomerDetails } from "./customerdetails";
import { EducationDetails } from "./education-details";
import { Mortgage } from "./mortgage";
import { PreviousLoan } from "./previous-loan";
import { Profession } from "./profession";
import { PropertyDetails } from "./property-details";

export class CustomerAppForm {

 applicationNo:number;

  customerDetails:CustomerDetails;

  customerAddress:CustomerAddress;

  educationalDetails:EducationDetails;

  profession:Profession;

  mortgage:Mortgage;

  customeraccountDetails:CustomerAccountDetails;

  previousLoan:PreviousLoan;

  propertyDetails:PropertyDetails;

  allpersonalDocs:AllPersonalDocs;
  id: any;

}
