import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from "@angular/router";
import {AppComponents, AppRoutes} from './app.router';
import { AppComponent } from './app.component';
import { ClothingComponent } from './clothing/clothing.component';
import { FoodComponent } from './food/food.component';
import { ContactComponent } from './contact/contact.component';
import { HomeComponent } from './home/home.component';
import { StartersComponent } from './starters/starters.component';
import { LoginComponent } from './login/login.component';
import { WomenComponent } from './women/women.component';

@NgModule({
  declarations: [
    AppComponent,
    ClothingComponent,
    FoodComponent,
    ContactComponent,
    HomeComponent,
    AppComponents,
    StartersComponent,
    LoginComponent,
    WomenComponent
  ],
  imports: [
    BrowserModule,
    RouterModule,
    RouterModule.forRoot(AppRoutes)
   
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }