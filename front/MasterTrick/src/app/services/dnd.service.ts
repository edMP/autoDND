import { Injectable, Type } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, race } from 'rxjs';



@Injectable({
  providedIn: 'root'
})
export class DndService {

  private urlEndpoint: string = "https://api.open5e.com";
  constructor(private http: HttpClient) {
  }

  gettype(work: string) {
    return this.http.get(`${this.urlEndpoint}/classes/` + work);

  }
  type(work: string) {
    var info: any[] = [];

    //console.log("https://api.open5e.com/classes/" + work)
    fetch("https://api.open5e.com/classes/" + work)
      .then(res => res.json())
      .then(data => {
        for (let i of data.work) {
          info.push(i.hit_dice)
          info.push(i.prof_armor)

        }
      })
    return info;

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


}

