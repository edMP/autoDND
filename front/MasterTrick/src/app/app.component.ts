import { Component, Input } from '@angular/core';
import { OnInit } from '@angular/core';
import { DndService } from './services/dnd.service';

declare function datos():void;
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  @Input() name?: string;  
  posts:any;
  constructor(private dnd:DndService ){}

  ngOnInit(){
   /* this.dnd.gettype().subscribe((response)=>{
      console.log(response);
      this.posts=response;
    })*/
  } 
}
  

