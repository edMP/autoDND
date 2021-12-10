import { Injectable, Type } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { localStorageJWT } from '../static/locla-storage';

import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class LoginService{
    private urlEndPoint:string='http://localhost:8080';

    private httpHeaders = new HttpHeaders({'content-type':'application/json'});
    constructor(private http: HttpClient){}

    login(nick:string,password:string): Observable<any>{

        return this.http.post(`${this.urlEndPoint}/login`,{nick,password},{headers:this.httpHeaders})
    }
    
}