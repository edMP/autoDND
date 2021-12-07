import { Injectable, Type } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, race } from 'rxjs';



@Injectable({
  providedIn: 'root'
})
export class DndService {
  info: any[] = [];
  dice!:string;
  walk:number=0;
  private urlEndpoint: string = "https://api.open5e.com";
  constructor(private http: HttpClient) {
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
  speed(work:string){
    
    fetch(`https://api.open5e.com/races/`+work)
      .then(res => res.json())
      .then(data => {
        this.walk=data.speed.walk
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
  
  type(work: string) {
    
     
    //console.log("https://api.open5e.com/classes/" + work)
    fetch("https://api.open5e.com/classes/" + work)
      .then(res => res.json())
      .then(data => {
        this.dice=data["hit_dice"]      
        
        
      })
      return this.dice;
      
  }

 


}

