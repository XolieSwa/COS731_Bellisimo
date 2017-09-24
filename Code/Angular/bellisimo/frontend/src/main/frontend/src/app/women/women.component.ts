import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";
import { Observable } from 'rxjs';

import {ProductService} from "../product/product.service";
import {Product} from "../product/product";

@Component({
  selector: 'app-women',
  templateUrl: './women.component.html',
  styleUrls: ['./women.component.css']
})
export class WomenComponent   implements OnInit{

  //variables
  observableProducts: Observable<Product[]>
  products: Product[];
  errorMessage: String;

  //constructor
  constructor(private router: Router, private productService: ProductService) {}

//routing
navigate() {
        this.router.navigate(["clothing"]);
        this.router.navigate(["food"]);
        this.router.navigate(["contact"]);
        this.router.navigate(["home"]);
        this.router.navigate(["login"]);
        this.router.navigate(["women"]);
}

  ngOnInit(): void {
    this.observableProducts = this.productService.getProductsWithObservable();
    this.observableProducts.subscribe(
      products => this.products = products,
      error =>  this.errorMessage = <any>error)

  }
}

