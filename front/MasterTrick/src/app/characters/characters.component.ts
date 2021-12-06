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
  strength: number = 0;
  dexterity:number= 0;
  constitution:number= 0;
  intelligence:number= 0;
  wisdom:number= 0;
  charisma:number= 0;


 

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
  attributes(){
    var att:number[]=[]
    for(var a=0;a<6;a++){
      var control=0;
      let less=[];
      while(control<=4){
        less.push(Math.floor(Math.random()*(7-1))+1)
        control++;
      }
      less.sort(function(a,b){return b-a})
      less.pop()
      att.push(less.reduce((a,b)=>a+b,0))
      
    }
    this.strength=att[0]
    this.dexterity=att[1]
    this.constitution=att[2]
    this.intelligence=att[3]
    this.wisdom=att[4]
    this.charisma=att[5]   
  }
  create(){
    
  }

}
