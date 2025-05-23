import { Component, inject, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { SecurityService } from '../../shared/_service/security.service';
import { Question } from '../../shared/models/question';
import { Security } from '../../shared/models/security';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { IconService } from '../../shared/_service/icon.service';
import { Icon } from '../../shared/models/icon';
import { User } from '../../shared/models/user';

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

  route = inject(ActivatedRoute);
  fb = inject(FormBuilder);
  questionForm!: FormGroup;

  _securityService = inject(SecurityService)
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
        console.log(response)
        this.icons = response
      }
    })
  }

  validateAccount() {
    if (this.questionForm.invalid) {
      this.markAllFieldsAsTouched();
      return
    }
    const security: Security = new Security()
    const user: User = new User()
    user.id = this.id
    security.user = user
    const icon: Icon = new Icon()
    icon.id = this.selectedIcon!.id
    security.icon = icon
    security.question = this.question
    security.answer = this.questionForm.value.answer
    this._securityService.checkIfAnswerUserExists(security).subscribe({
      next: response => {
        console.log(response)
      }
    }) 
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
