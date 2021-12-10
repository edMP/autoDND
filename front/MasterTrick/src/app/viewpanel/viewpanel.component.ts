import { Component, OnInit } from '@angular/core';
import { viewService } from '../services/view.service';
@Component({
  selector: 'app-viewpanel',
  templateUrl: './viewpanel.component.html',
  styleUrls: ['./viewpanel.component.css']
})
export class ViewpanelComponent implements OnInit {
  names:string[]=[]
  level:string[]=[]
  work:string[]=[]
  union:string[]=[]
  loginuser:string="auth user"
  displayedColumns: string[] =["name"]
  constructor(private view:viewService) { }

  ngOnInit(): void {
    
    this.names=this.view.loginUserViewname()
    this.level=this.view.loginUserViewlevel()
    this.work=this.view.loginUserWork()

   
  }
 

  

}
