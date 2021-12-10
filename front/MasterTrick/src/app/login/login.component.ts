import { Component, OnInit } from '@angular/core';
import { Users } from '../models/users-models';
import { LoginService } from '../services/login.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  nick!:string;
  password!:string;
  constructor(private loginser:LoginService) { }

  ngOnInit(): void {
  }

  makelogin(){
   
    this.loginser.login(this.nick,this.password).subscribe(response=>{
      localStorage.setItem('auth_token',response['token'])
    })

  }

}
