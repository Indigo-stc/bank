import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../models/user';
import { CrudService } from './crud.service';
import { Icon } from '../models/icon';

@Injectable({
  providedIn: 'root'
})
export class IconService extends CrudService<User> {

  ENROLMENT_PATH = '/icon';

  constructor() {
    super('/icon');
  }

  getIconsForUser(userId: number): Observable<Icon[]> {
    return this._http.get<Icon[]>(`${this.endPoint}/user/${userId}`);
  }

}
