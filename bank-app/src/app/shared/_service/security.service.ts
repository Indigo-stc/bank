import { HttpParams } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../models/user';
import { CrudService } from './crud.service';
import { Question } from '../models/question';
import { AnswerUser } from '../models/security';

@Injectable({
  providedIn: 'root'
})
export class SecurityService extends CrudService<AnswerUser> {

  ENROLMENT_PATH = '/answer';

  constructor() {
    super('/answer');
  }

  getRandomQuestionForUser(id: number) {
    return this._http.get<Question>(`${this.endPoint}/question/${id}`)
  }

  checkIfAnswerUserExists(answerUser: AnswerUser): Observable<boolean> {
    return this._http.post<boolean>(`${this.endPoint}/exists`, answerUser);
  }

}
