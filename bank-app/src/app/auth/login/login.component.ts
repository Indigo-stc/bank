import { CommonModule } from '@angular/common';
import { Component, inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { UserService } from '../../shared/_service/user.service';
import { Router } from '@angular/router';
import { User } from '../../shared/models/user';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule, ReactiveFormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit {

  fb = inject(FormBuilder);
  loginForm!: FormGroup;
  
  router = inject(Router);
  _userService = inject(UserService)
  errorMessage: any;

  ngOnInit(): void {
    this.loginForm = this.startForm()
  }

  startForm(): FormGroup {
    return this.fb.group({
      username: ['', [Validators.required]],
      password: ['', [Validators.required]],
    });
  }

  login() {
    const { username, password } = this.loginForm.value;
    this._userService.login(username, password).subscribe({
      next: response => {
        console.log("sds" + response)
        this.getRoster(response)
      },
      error: error => {
        this.errorMessage = error.error.description || error.error.message
      }
    })
  }

  getRoster(user: User) {
    this.router.navigate(['/security-question/', user.id]); 
  }

}
