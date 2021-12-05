import { Injectable, Type } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Users } from '../models/users-models';
import { Observable } from 'rxjs';
@Injectable({
    providedIn: 'root'
})
export class UserService{
    private urlEndPoint:string='http://localhost:8080';
    private httpHeaders = new HttpHeaders({'contet-type':'application/json'});

    constructor(private http: HttpClient) { }
    
    createUser(nick:String,name:String,last_name:String,password:String,email:String): Observable<any>{
        return this.http.post(`${this.urlEndPoint}/createuser`,{nick,name,last_name,password,email},{headers:this.httpHeaders})
    
    }


}