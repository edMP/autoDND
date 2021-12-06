import { Component, OnInit } from '@angular/core';
import { Users } from '../models/users-models';
import { UserService } from '../services/user.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent implements OnInit {
  
  users!:Users;
  newnick!:string;
  newname!:string;
  newlastname!:string;
  newpassword!:string;
  newemail!:string;

  constructor(
    private userservice:UserService,private router:Router
    ) { }

  ngOnInit(): void {
  
  }
  checknick(){
    var patt = new RegExp(/\W/g);
    if(this.newnick.length<=4 || patt.test(this.newnick)){
      return false;
    }else{
      return true
    }

  }
 
  checkPassword(){
    var patt = new RegExp(/\*\W[+!@#$%^&*]/g);
    if(this.newpassword.length<6 && !patt.test(this.newpassword)){
      return false;
    }else{
      return true;
    }
    
  }
  checkEmail(){
    var patt=/^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$/;
    
  if(patt.test(this.newemail)){
    return true;
  }else{
    return false;
  }
  }

  adduser(){
    if(this.checknick()==false){
      document.getElementById("check")!.innerHTML="invalid nick";
      
    }else if(this.checkPassword()==false){
      document.getElementById("check")!.innerHTML="invalid password";

    }else if(this.checkEmail()==false){
      document.getElementById("check")!.innerHTML="invalid email";
      
    }else{
      this.users={
        nick:this.newnick,
        name:this.newname,
        last_name:this.newlastname,
        password:this.newpassword,
        email:this.newemail
  
      }   
     
      this.userservice.createUser(this.users.nick,this.users.name,this.users.last_name,this.users.password,this.users.email).subscribe(add=>{
        if(add == false){
          document.getElementById("check")!.innerHTML="the user already exists";
        }else{
          window.location.replace("http://localhost:4200/login");
        }
          
        
      })
    }
  
  }

}
