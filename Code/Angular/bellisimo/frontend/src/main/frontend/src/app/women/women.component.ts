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

  //adding
  productCategory: String;
  categoryType: string;
  categorySubType: string;
  description: string;
  size: string;
  price: number;
  imagePath: string;

  //productObject
  product = new Product();


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
    this.fetchProducts();

  }
  fetchProducts(): void {
    this.productService.getProductsWithObservable()
      .subscribe( products => this.products = products,
        error => this.errorMessage = <any>error);
  }

  addProduct(): void {
    this.productService.addProductWithObservable(this.product)
      .subscribe( product => {
          this.fetchProducts();
          this.reset();
          this.productCategory = product.category;
          this.categoryType = product.categoryType;
          this.categorySubType = product.categorySubType;
          this.description = product.description;
          this.size = product.size;
          this.price = product.price;
          this.imagePath= product.imagePath;
        },
        error => this.errorMessage = <any>error);
  }

  updateProduct(): void {
    this.productService.updateProductWithObservable(this.product)
      .subscribe( product => {
          this.fetchProducts();
          this.reset();
          this.productCategory = product.category;
          this.product.id = product.id;
        },
        error => this.errorMessage = <any>error);
  }
  private reset() {
    this.product.id = null;
    this.product.category = null;
    this.errorMessage = null;
    this.productCategory = null;
  }
}

