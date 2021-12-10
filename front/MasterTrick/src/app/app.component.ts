import { Component, Input } from '@angular/core';
import { OnInit } from '@angular/core';

import { DndService } from './services/dnd.service';
import { LoginService } from './services/login.service';
import { viewService } from './services/view.service';

declare function datos():void;
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  @Input() name?: string;  
  posts:any;
  loginuser!:string;
  constructor(private login:LoginService,private dnd:DndService, private view:viewService ){}

  ngOnInit(){
    this.view.username(this)

  } 
  disconect(){
    this.login.disconect().subscribe(response=>{
      if(response== true){
        window.location.replace("http://localhost:4200/login");
      }
    })
  
}
}

