import {ModuleWithProviders} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';

import { AppComponent } from './app.component';
import { ClothingComponent } from './clothing/clothing.component';
import { FoodComponent } from './food/food.component';
import { ContactComponent } from './contact/contact.component';

export const router : Routes = [
{path: '' , redirectTo: 'clothing', pathMatch: 'full'},
{path: 'clothing', component :ClothingComponent  },
{path: 'food', component : FoodComponent  },
{path: 'contact', component : ContactComponent}
];

export const routes : ModuleWithProviders = RouterModule.forRoot(router);