import { Component, OnInit } from '@angular/core';
import { Priviledges } from '../../model/priviledges';

@Component({
  selector: 'app-sidemenu',
  templateUrl: './sidemenu.component.html',
  styleUrl: './sidemenu.component.css'
})
export class SidemenuComponent implements OnInit{

  userType:string
  options :Array<any>

  ngOnInit(): void {
   this.userType =localStorage.getItem("usertype")
   this.options=Priviledges.userPriviledges
  }

}
