import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { RegistrationService } from '../../services/registration.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrl: './registration.component.css'
})
export class RegistrationComponent implements OnInit{

  registrationForm: FormGroup;
  submitted = false;

  constructor(private formBuilder: FormBuilder, private activateRoute:ActivatedRoute, private registrationService:RegistrationService) { }

  ngOnInit(): void {
    this.registrationForm = this.formBuilder.group({
      id:[],
      firstName: ['', Validators.required],
      middleName: [''],
      lastName: ['', Validators.required],
      mobileNo: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      DOB: ['', Validators.required],
      age: ['', Validators.required],
      gender: ['', Validators.required],
      username: ['', Validators.required],
      password: ['', [Validators.required, Validators.minLength(6)]]
    });
  }

  onSubmit() {
  //   this.submitted = true;

  //   if (this.registrationForm.invalid) {
  //     return;
  //   }

  //   console.log(this.registrationForm.value);
  //   // Here you can submit the form data to your backend service or handle it as required
  // }
  alert('done')
    console.log(this.registrationForm.value);
    this.registrationService.registerCustomer(this.registrationForm.value).subscribe();
  }
}
