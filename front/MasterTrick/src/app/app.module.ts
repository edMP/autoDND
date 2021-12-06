import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {  HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CharactersComponent } from './characters/characters.component';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import { MatOptionModule } from '@angular/material/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatSelectModule} from '@angular/material/select';
import { LoginComponent } from './login/login.component';
import { UserpanelComponent } from './userpanel/userpanel.component';
import { ViewpanelComponent } from './viewpanel/viewpanel.component';
import { RegisterComponent } from './register/register.component';
import {MatButtonModule} from '@angular/material/button';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ModalComponent } from './modal/modal.component';

const routes:Routes=[
 
  {path:'personaje',component: CharactersComponent},
  {path:'login',component: LoginComponent},
  {path:'register',component: RegisterComponent},
  {path:'**',pathMatch:'full',redirectTo:'modal'}
];


@NgModule({
  declarations: [
    AppComponent,
    CharactersComponent,
    LoginComponent,
    UserpanelComponent,
    ViewpanelComponent,
    RegisterComponent,
    ModalComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    FormsModule,
    HttpClientModule,
    MatFormFieldModule,
    MatInputModule,
    MatOptionModule,
    MatSelectModule,    
    BrowserAnimationsModule,
    MatButtonModule,
    NgbModule
    
   
    
  ],
  providers: [],
  bootstrap: [AppComponent],
  exports:[
    RouterModule,
  
  ]
})
export class AppModule { }
