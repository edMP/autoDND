import { Component, OnInit } from '@angular/core';
import { Users } from '../models/users-models';
import { UserService } from '../services/user.service';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  users!:Users;
  constructor(
    private userservice:UserService
    ) { }

  ngOnInit(): void {
    this.users={
      nick:"maxin",
      name:"molin",
      last_name:"rafael",
      password:"1232456",
      email:"email@mail.com"  
    }
  }

  adduser(){
   console.log(this.users)
    this.userservice.createUser(this.users.nick,this.users.name,this.users.last_name,this.users.password,this.users.email).subscribe(add=>{

    })
  }

}
