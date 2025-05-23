import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../models/user';
import { CrudService } from './crud.service';

@Injectable({
  providedIn: 'root'
})
export class UserService extends CrudService<User> {

  ENROLMENT_PATH = '/user';

  constructor() {
    super('/user');
  }

  login(username: string, password: string): Observable<User> {
    const params = new HttpParams()
      .set('username', username)
      .set('password', password);
    return this._http.post<User>(`${this.endPoint}/login`, null, { params });
  }

}
