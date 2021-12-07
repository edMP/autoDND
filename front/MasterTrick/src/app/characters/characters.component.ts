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
  backgrounds:string []=[];
  background!:string;
  races:string[]=[];
  selectRace!:string;
  race!:string;
  classes:string[]=[];
  name!:string;
  ideals!:string;
  profeci_bonus:number=0;
  level:number=1;
  leguage!:string;
  bound!:string;
  selectClass!:string;
  class!:string;
  strength: number = 0;
  dexterity:number= 0;
  constitution:number= 0;
  intelligence:number= 0;
  wisdom:number= 0;
  charisma:number= 0;
  hit_dice:string="";
  mobility:number=0;
  
 

  post:any;
  constructor(public dnd:DndService) { }

  ngOnInit(): void {
    
    this.races=this.dnd.showRace();
    this.classes=this.dnd.showWork();
    this.backgrounds=this.dnd.showBackgraund();
   
     
    
  }
  selectRaces(){
  
   this.dnd.getrace(this.selectRace).subscribe((response)=>{
   
      this.post=response;
       
    })
    this.mobility=this.dnd.speed(this.selectRace)
   
    this.leguage=this.selectRace;
  }
  
 
  selectClassess(){
    this.hit_dice=this.dnd.type(this.selectClass)!
     
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
  profeci(){
    console.log(this.background)
    this.profeci_bonus=Math.ceil(1+(this.level/4))
    
  }

}
