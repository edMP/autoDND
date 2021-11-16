import { Injectable, Type } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, race } from 'rxjs';



@Injectable({
  providedIn: 'root'
})
export class DndService {
  info: any[] = [];
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
    fetch(`https://api.open5e.com/races/`)
      .then(res => res.json())
      .then(data => {
        for (let a of data.results) {
          races.push(a.slug)
        }
      })
    return races;

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
          
        document.getElementById("dice")!.innerHTML=data["hit_dice"];
          this.info.push(data["hit_dice"])
          this.info.push(data["prof_armor"])

        
      })
     console.log(this.info)
    return this.info;

  }


}

