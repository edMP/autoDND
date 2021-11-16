import { Component, OnInit } from '@angular/core';
import { characters } from '../models/characters-model';
import { DndService } from '../services/dnd.service';

@Component({
  selector: 'app-characters',
  templateUrl: './characters.component.html',
  styleUrls: ['./characters.component.css']
})


/*
controlador de creacion de personajes
*/
export class CharactersComponent implements OnInit {
  races:string[]=[];
  selectRace!:string;
  race!:string;

  classes:string[]=[];
  selectClass!:string;
  class!:string;
  

  post:any;
  constructor(private dnd:DndService) { }

  ngOnInit(): void {
    
    this.races=this.dnd.showRace();
    this.classes=this.dnd.showWork();
  }
  selectRaces(){
  console.log(this.selectRace);
   this.dnd.getrace(this.selectRace).subscribe((response)=>{
   
      this.post=response;
       console.log(this.post)
    })
  }

  selectClassess(){
    
   /*this.dnd.gettype(this.selectClass).subscribe((response)=>{
      console.log(response)
      this.post=response; 
      console.log("hola mundo")
      
    })*/
    this.dnd.type(this.selectClass);
   
    
  }

}
