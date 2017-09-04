import { AppComponent } from './app.component';
import { ClothingComponent } from './clothing/clothing.component';
import { FoodComponent } from './food/food.component';
import { ContactComponent } from './contact/contact.component';
import { HomeComponent } from './home/home.component';

export const AppRoutes: any = [
{path: '' , redirectTo: 'home', pathMatch: 'full'},
{path: 'home', component :HomeComponent  },
{path: 'clothing', component :ClothingComponent  },
{path: 'food', component : FoodComponent  },
{path: 'contact', component : ContactComponent}
];

export const AppComponents: any = [
    AppComponent,
    ClothingComponent,
    FoodComponent,
    ContactComponent,
    HomeComponent
];