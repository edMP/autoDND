import { Injectable, Type } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { localStorageJWT } from '../static/locla-storage';

@Injectable({
    providedIn: 'root'
})
export class JWTAuthService{
   login(token:string){
    

    localStorage.setItem(localStorageJWT.LS_Credentail_tocken,'');
    
   }

}