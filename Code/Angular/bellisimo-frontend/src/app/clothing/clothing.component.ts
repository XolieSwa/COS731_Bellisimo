import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";

@Component({
  selector: 'app-clothing',
  templateUrl: './clothing.component.html',
  styleUrls: ['./clothing.component.css']
})
export class ClothingComponent {

constructor(private router: Router) { }
  navigate() {
        this.router.navigate(["clothing"]);
        this.router.navigate(["food"]);
        this.router.navigate(["contact"]);
        this.router.navigate(["home"]);
    }

}
