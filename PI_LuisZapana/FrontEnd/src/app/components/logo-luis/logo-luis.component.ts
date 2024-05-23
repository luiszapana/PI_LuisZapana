import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-logo-luis',
  templateUrl: './logo-luis.component.html',
  styleUrl: './logo-luis.component.css'
})
export class LogoLuisComponent implements OnInit{
  
  constructor(private router:Router){ }

  ngOnInit(): void {
    
  }

  login(){
    this.router.navigate(['/login'])
  }
}
