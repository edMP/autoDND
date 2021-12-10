import { Injectable, Type } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
@Injectable({
    providedIn: 'root'
})
export class viewService{
    private urlEndPoint:string='http://localhost:8080';
    private token = localStorage.getItem('auth_token');
    private httpHeaders = new HttpHeaders({
        'content-type':'application/json',
        'athorization':'Bearer '+this.token
    });
    private header = new Headers();
    private headers = {
        method: "GET",
        headers: this.header
        };

    constructor(private http: HttpClient) {
        this.header.append("Authorization", "Bearer " + this.token);
        this.header.append("Content-type", "application/json");
     }

    loginUserViewname(){
        var name: string[]=[];
        fetch(this.urlEndPoint+"/currentcharacters/", this.headers)
        .then(res=>res.json())
        .then(data=>{
            for(let a of data){
           
             name.push(a.character_name)   
            
            }
        })       
        return name
    }
    loginUserViewlevel(){
        var level: string[]=[];
        fetch(this.urlEndPoint+"/currentcharacters/", this.headers)
        .then(res=>res.json())
        .then(data=>{
            for(let a of data){
           
             level.push(a.level)   
            
            }
        })       
        return level
    }
    loginUserWork(){
        var work: string[]=[];
        fetch(this.urlEndPoint+"/currentcharacters/", this.headers)
        .then(res=>res.json())
        .then(data=>{
            for(let a of data){
           
             work.push(a.profesion)   
            
            }
        })       
        return work
    }

    username(componentes: any){

        fetch(this.urlEndPoint+"/currentusername", this.headers )
        .then(res=>res.json())
        .then(data=>{
            componentes.loginuser = data['username']
        }); 
    }
}
