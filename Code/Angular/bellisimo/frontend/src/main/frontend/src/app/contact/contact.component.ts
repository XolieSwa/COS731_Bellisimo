import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})


@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent  {
constructor(private router: Router) { }

 navigate() {
   this.router.navigate(["clothing"]);
   this.router.navigate(["food"]);
   this.router.navigate(["contact"]);
   this.router.navigate(["home"]);
   this.router.navigate(["login"]);
   this.router.navigate(["women"]);
   this.router.navigate(["starters"]);
   this.router.navigate(["dessert"]);
}
}
