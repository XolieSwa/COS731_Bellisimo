import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {routes} from './app.router';
import { AppComponent } from './app.component';
import { ClothingComponent } from './clothing/clothing.component';
import { FoodComponent } from './food/food.component';
import { ContactComponent } from './contact/contact.component';

@NgModule({
  declarations: [
    AppComponent,
    ClothingComponent,
    FoodComponent,
    ContactComponent
  ],
  imports: [
    BrowserModule,
    routes
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
