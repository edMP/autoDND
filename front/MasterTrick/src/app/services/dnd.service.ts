import { Injectable, Type } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, race } from 'rxjs';
import { Background } from '../models/background-model';



@Injectable({
  providedIn: 'root'
})
export class DndService {
  info: any[] = [];
  dice!:string;
  walk:number=0;
  private token = localStorage.getItem('auth_token');
  private urlEndpoint: string = "https://api.open5e.com";
  private serverEndpoint:string="http://localhost:8080";
  private httpHeaders = new HttpHeaders({'content-type':'application/json'});

  private header = new Headers();
    private httpheaders = {
        method: "POST",
        headers: this.header
        };

  constructor(private http: HttpClient) {
        this.header.append("Authorization", "Bearer " + this.token);
        this.header.append("Content-type", "application/json");
        this.httpHeaders = this.httpHeaders.append("Authorization", "Bearer " + this.token);
  }

  gettype(work: string) {
    return this.http.get(`${this.urlEndpoint}/classes/` + work);

  }
  

  getrace(race: string) {
    return this.http.get(`${this.urlEndpoint}/races/`+race);

  }

  showRace() {
    var races: any[] = [];
    fetch(`https://api.open5e.com/races`)
      .then(res => res.json())
      .then(data => {
        for (let a of data.results) {
          races.push(a.slug)
        }
      })
    return races;
  }
  speed(work:string,character:any){
    
    fetch(`https://api.open5e.com/races/`+work)
      .then(res => res.json())
      .then(data => {
        character.mobility=data.speed.walk
      })
    return this.walk;

  }
  showBackgraund(){
    var background: any[] = [];
    fetch(`https://api.open5e.com/backgrounds/`)
      .then(res => res.json())
      .then(data => {
        for (let a of data.results) {
          background.push(a.name)
        }
      })
    return background;

  }

  showWork() {
    var work: any[] = [];
    fetch(`https://api.open5e.com/classes/`)
      .then(res => res.json())
      .then(data => {
        for (let a of data.results) {
          work.push(a.slug)
        }
      }
      )
    return work;

  }
  
  type(work: string, character: any) {    
     
    //console.log("https://api.open5e.com/classes/" + work)
    fetch("https://api.open5e.com/classes/" + work)
      .then(res => res.json())
      .then(data => {
        this.dice=data["hit_dice"]
        // actualizar componente
        character.hit_dice = data["hit_dice"]
      })

      return this.dice;
      
  }
  createCharacter(level:string,name:string,profession:string,race:string,strength:string,dexterity:string,
        constitution:string,intelligence:string,wisdom:string,charisma:string,alignment:string,hit_dice:string,
        personality_trails:string,ideals:string,profeci_bonus:string,mobility:string,lenguage:string,
        bound:string,backgrounds:Background): Observable<any>{
          
          return this.http.post(`${this.serverEndpoint}/addcharacter/`,{
            level,name,profession,race,strength,dexterity,constitution,intelligence,wisdom,charisma
            ,alignment,hit_dice,personality_trails,ideals,profeci_bonus,mobility,lenguage,bound,backgrounds}
            ,{headers : this.httpHeaders});

  }
 


}

