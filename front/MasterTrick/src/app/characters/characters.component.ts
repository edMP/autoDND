import { Component, OnInit } from '@angular/core';
import { Background } from '../models/background-model';
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
  character!:characters;
  backgrounds:string []=[];
 background!:Background;
 tempname!:string;
 tempdescription!:string;
  setdes!:string;
  races:string[]=[];
  selectRace!:string;
  race!:string;
  classes:string[]=[];
  name!:string;
  ideals:string = "";
  alignement:string = "";
  personality_trails:string="";
  profeci_bonus:string="0";
  level:string="1";
  leguage!:string;
  bound:string= "";
  selectClass!:string;
  class!:string;
  strength: string="0";
  dexterity:string="0";
  constitution:string="0";
  intelligence:string="0";
  wisdom:string="0";
  charisma:string="0";
  hit_dice:string="";
  mobility:string="0";
  
 

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
   this.dnd.speed(this.selectRace,this)
   
    this.leguage=this.selectRace;
  }
  
 
  selectClassess(){
    this.dnd.type(this.selectClass, this)
     
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
    this.strength=""+att[0]
    this.dexterity=""+att[1]
    this.constitution=""+att[2]
    this.intelligence=""+att[3]
    this.wisdom=""+att[4]
    this.charisma=""+att[5]   
  }
  profeci(){
    
    this.profeci_bonus=""+Math.ceil(1+(parseInt(this.level)/4))
    
  }
  create(){
    
    this.background = {
      name:this.tempname,
      description:this.tempdescription
    }
    
   
    this.dnd.createCharacter(
      this.level,this.name,this.selectClass,this.selectRace
      ,this.strength,this.dexterity,this.constitution,this.intelligence,this.wisdom
      ,this.charisma,this.alignement,this.hit_dice,this.personality_trails
      ,this.ideals,this.profeci_bonus,this.mobility,this.leguage,this.bound
      ,this.background
      ).subscribe(response=>{
         if(response == true){
          window.location.replace("http://localhost:4200/view");
         }
        })
  } 

}
