import { Injectable, Type } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { localStorageJWT } from '../static/locla-storage';

import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class LoginService{
    private urlEndPoint:string='http://localhost:8080';
    private token = localStorage.getItem('auth_token');
    private httpHeaders = new HttpHeaders({'content-type':'application/json'});
    constructor(private http: HttpClient){
        this.httpHeaders = this.httpHeaders.append("Authorization", "Bearer " + this.token);
    }

    login(nick:string,password:string): Observable<any>{

        return this.http.post(`${this.urlEndPoint}/login`,{nick,password},{headers:this.httpHeaders})
    }
    disconect(){
      return this.http.get(`${this.urlEndPoint}/logout/`,{headers:this.httpHeaders})
    }
    
}