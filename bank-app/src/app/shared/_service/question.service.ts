import { HttpParams } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../models/user';
import { CrudService } from './crud.service';
import { Question } from '../models/question';

@Injectable({
  providedIn: 'root'
})
export class QuestionService extends CrudService<Question> {

  ENROLMENT_PATH = '/question';

  constructor() {
    super('/answer');
  }

  getRosterByTeamIdActive(id: number) {
    return this._http.get<[]>(`${this.endPoint}/team/${id}`)
  }

}

