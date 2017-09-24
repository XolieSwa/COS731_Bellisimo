import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';

import { Product } from './product';

@Injectable()
export class ProductService {
  url = "http://localhost:8080/data/allproducts";
  constructor(private http:Http) { }
  getProductsWithObservable(): Observable<Product[]> {
    return this.http.get(this.url)
      .map(this.extractData)
      .catch(this.handleErrorObservable);
  }
  getProductsWithPromise(): Promise<Product[]> {
    return this.http.get(this.url).toPromise()
      .then(this.extractData)
      .catch(this.handleErrorPromise);
  }
  private extractData(res: Response) {
    let body = res.json();
    return body;
  }
  private handleErrorObservable (error: Response | any) {
    console.error(error.message || error);
    return Observable.throw(error.message || error);
  }
  private handleErrorPromise (error: Response | any) {
    console.error(error.message || error);
    return Promise.reject(error.message || error);
  }
}
