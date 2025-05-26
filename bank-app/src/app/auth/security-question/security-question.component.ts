import { Component, inject, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SecurityService } from '../../shared/_service/security.service';
import { Question } from '../../shared/models/question';
import { AnswerUser, IconUser } from '../../shared/models/security';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { IconService } from '../../shared/_service/icon.service';
import { Icon } from '../../shared/models/icon';
import { User } from '../../shared/models/user';
import { IconUserService } from '../../shared/_service/icon-user.service';
import { forkJoin } from 'rxjs';

@Component({
  selector: 'app-security-question',
  imports: [CommonModule, FormsModule, ReactiveFormsModule],
  templateUrl: './security-question.component.html',
  styleUrl: './security-question.component.css'
})
export class SecurityQuestionComponent implements OnInit {

  id?: number;
  question?: Question;
  icons?: Icon[] 
  selectedIcon?: Icon;
  questionForm!: FormGroup;

  route = inject(ActivatedRoute);
  fb = inject(FormBuilder);
  router = inject(Router);


  _securityService = inject(SecurityService)
  _iconUserService = inject(IconUserService)
  _iconService = inject(IconService)

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.id = parseInt(params['id']);
      this.getQuestion(this.id);
      this.getIcons(this.id);
    })
    this.questionForm = this.startForm()
  }

  startForm(): FormGroup {
    return this.fb.group({
      answer: ['', [Validators.required]],
    });
  }

  getQuestion(id: any) {
    this._securityService.getRandomQuestionForUser(id).subscribe({
      next: response => {
        this.question = response
      }
    })
  }

  getIcons(id: any) {
    this._iconService.getIconsForUser(id).subscribe({
      next: response => {
        this.icons = response
      }
    })
  }

validateAccount() {
  if (this.questionForm.invalid) {
    this.markAllFieldsAsTouched();
    return;
  }

  const user: User = new User();
  user.id = this.id;

  const icon: Icon = new Icon();
  icon.id = this.selectedIcon!.id;

  const ansUsr: AnswerUser = new AnswerUser();
  ansUsr.user = user;
  ansUsr.question = this.question;
  ansUsr.answer = this.questionForm.value.answer;

  const icnUser: IconUser = new IconUser();
  icnUser.user = user;
  icnUser.icon = icon;

  forkJoin([
    this._securityService.checkIfAnswerUserExists(ansUsr),
    this._iconUserService.checkIfIconUserExists(icnUser)
  ]).subscribe({
    next: ([answer, icon]) => {
      if (!(answer && icon)) {
        console.warn("⛔ Validación fallida: respuesta o icono no existen.");
        return;
      }

      this.router.navigate(['/signup']);
    },
    error: (err) => {
      console.error("💥 Error al validar:", err);
    }
  });
}


  selectIcon(icon: Icon): void {
    this.selectedIcon = icon;
  }

  isSelected(icon: Icon): boolean {
    return this.selectedIcon === icon;
  }

  markAllFieldsAsTouched() {
    Object.values(this.questionForm!.controls).forEach(control => {
      control.markAsTouched();
    });
  }

}
