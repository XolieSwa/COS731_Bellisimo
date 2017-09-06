import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";

@Component({
  selector: 'app-women',
  templateUrl: './women.component.html',
  styleUrls: ['./women.component.css']
})
export class WomenComponent  {

  constructor(private router: Router) { }
 navigate() {
        this.router.navigate(["clothing"]);
        this.router.navigate(["food"]);
        this.router.navigate(["contact"]);
        this.router.navigate(["home"]);
        this.router.navigate(["login"]);
        this.router.navigate(["women"]);
}

Women = [
  { id: 11, name: 'Mr. Nice', price: 'R150.59',image:"../assets/img/women/women1.jpg"},
  { id: 12, name: 'Narco', price: 'R25.59',image:"../assets/img/women/women1.jpg" },
  { id: 13, name: 'Bombasto', price: '18.90',image:"../assets/img/women/women1.jpg"},
  { id: 14, name: 'Celeritas', price: 'R90.59',image:"../assets/img/women/women1.jpg" },
  { id: 15, name: 'Magneta', price: 'R150.59',image:"../assets/img/women/women1.jpg" },
  { id: 16, name: 'RubberMan', price: 'R150.59',image:"../assets/img/women/women1.jpg"},
  { id: 17, name: 'Dynama', price: 'R150.59',image:"../assets/img/women/women1.jpg"},
  { id: 18, name: 'Dr IQ', price: 'R150.59',image:"../assets/img/women/women1.jpg"},
  { id: 19, name: 'Magma', price: 'R150.59',image:"../assets/img/women/women1.jpg" },
  { id: 20, name: 'Tornado', price: 'R150.59',image:"../assets/img/women/women1.jpg"}
];

WOMENLISTS = this.Women;
}

